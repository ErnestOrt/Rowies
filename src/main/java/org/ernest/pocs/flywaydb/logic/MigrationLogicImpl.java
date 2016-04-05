package org.ernest.pocs.flywaydb.logic;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.ernest.pocs.flywaydb.entities.Database;
import org.ernest.pocs.flywaydb.entities.DatabasesConfiguration;
import org.ernest.pocs.flywaydb.entities.ExecutionInfo;
import org.ernest.pocs.flywaydb.entities.InstanceInformation;
import org.ernest.pocs.flywaydb.exceptions.NotConfigurationFoundException;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;
import org.flywaydb.core.api.MigrationInfo;
import org.flywaydb.core.api.MigrationInfoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class MigrationLogicImpl implements MigrationLogic {

	private static final String BASELINE_VERSION = "0";

	@Value("${scripts.locations}") private String scriptsLocations;
	
	Map<String, Database> databases = new HashMap<String, Database>();
	
	@PostConstruct
	public void setDatabases() throws IOException, URISyntaxException{
		DatabasesConfiguration conf = new Gson().fromJson(new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("databases.json").toURI()))), DatabasesConfiguration.class);
		conf.getDatabases().stream().forEach(db -> databases.put(db.getCode(), db));
	}
	
	@Override
	public Collection<Database> getDbs() {
		return databases.values();
	}

	@Override
	public void baseline(String env) throws FlywayException, NotConfigurationFoundException {
		Flyway flyway = buildFlywayInstance(env);
		flyway.setBaselineVersionAsString(BASELINE_VERSION);
		flyway.baseline();
	}

	@Override
	public void migrate(String env) throws FlywayException, NotConfigurationFoundException {
		buildFlywayInstance(env).migrate();
	}

	@Override
	public void validate(String env) throws FlywayException, NotConfigurationFoundException {
		buildFlywayInstance(env).validate();
	}

	@Override
	public void repair(String env) throws FlywayException, NotConfigurationFoundException {
		buildFlywayInstance(env).repair();
	}

	@Override
	public InstanceInformation info(String env) throws NotConfigurationFoundException {
		if(!databases.containsKey(env)){
			throw new NotConfigurationFoundException("Not properties found for env: " + env);
		}	
		Database db = databases.get(env);
		
		InstanceInformation instanceInformation = new InstanceInformation();
		instanceInformation.setImgCode(db.getImgCode());
		instanceInformation.setCode(db.getCode());
		instanceInformation.setName(db.getName());
		
		MigrationInfoService info = buildFlywayInstance(env).info();

		MigrationInfo current = info.current();
		if (current != null) {
			instanceInformation.setCurrent(new ExecutionInfo(current.getVersion().toString(), current.getDescription(), current.getInstalledOn().toString()));
		}

		instanceInformation.setExecutionsPendingList(
				Arrays.asList(info.pending()).stream()
											 .map(pending -> { return new ExecutionInfo(pending.getVersion().toString(), pending.getDescription());})
											 .collect(Collectors.toList()));
		return instanceInformation;
	}
	
	private Flyway buildFlywayInstance(String env) throws NotConfigurationFoundException {
		
		if(!databases.containsKey(env)){
			throw new NotConfigurationFoundException("Not properties found for env: " + env);
		}
		
		Database db = databases.get(env);
		
		Flyway flyway = new Flyway();
		flyway.setLocations(scriptsLocations);
		flyway.setDataSource(db.getStringConnection(), db.getUser(), db.getPass());
				
		return flyway;
	}
}