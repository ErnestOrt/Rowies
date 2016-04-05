package org.ernest.pocs.flywaydb.logic;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.ernest.pocs.flywaydb.entities.Database;
import org.ernest.pocs.flywaydb.entities.InstanceInformation;
import org.ernest.pocs.flywaydb.exceptions.NotConfigurationFoundException;
import org.flywaydb.core.api.FlywayException;

public interface MigrationLogic {

	Collection<Database> getDbs();
	void baseline(String env) throws FlywayException, NotConfigurationFoundException;	
	void migrate(String env) throws FlywayException, NotConfigurationFoundException;
	void validate(String env) throws FlywayException, NotConfigurationFoundException;
	void repair(String env) throws FlywayException, NotConfigurationFoundException;
	InstanceInformation info(String env) throws FlywayException, NotConfigurationFoundException;
	
}