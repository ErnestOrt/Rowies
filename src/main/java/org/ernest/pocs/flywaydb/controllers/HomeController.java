package org.ernest.pocs.flywaydb.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.ernest.pocs.flywaydb.entities.Database;
import org.ernest.pocs.flywaydb.entities.InstanceInformation;
import org.ernest.pocs.flywaydb.exceptions.NotConfigurationFoundException;
import org.ernest.pocs.flywaydb.logic.MigrationLogic;
import org.flywaydb.core.api.FlywayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@Autowired
	MigrationLogic migrationLogic;
	
	@RequestMapping("/") String home(Model model) throws FlywayException, NotConfigurationFoundException {
				
		List<Database> dbs = new ArrayList<Database>(migrationLogic.getDbs());
		dbs.sort(Comparator.comparing(Database::getSorting));
		
		List<InstanceInformation> instances = new ArrayList<InstanceInformation>();
		for (Database db : dbs) { instances.add(migrationLogic.info(db.getCode()));}	
		model.addAttribute("instances", instances);
		
		return "home"; 
	}
	
	@RequestMapping("/validate/{env}")
	@ResponseBody
	String validate(@PathVariable("env") String env) throws FlywayException, NotConfigurationFoundException {
		migrationLogic.validate(env);
		return "validate done";
	}
	@RequestMapping("/baseline/{env}")
	@ResponseBody
	String baseline(@PathVariable("env") String env) throws FlywayException, NotConfigurationFoundException {
		migrationLogic.baseline(env);
		return "baseline done";
	}
	@RequestMapping("/migrate/{env}")
	@ResponseBody
	String migrate(@PathVariable("env") String env) throws FlywayException, NotConfigurationFoundException {
		migrationLogic.migrate(env);
		return "migrate done";
	}
	@RequestMapping("/repair/{env}")
	@ResponseBody
	String repair(@PathVariable("env") String env) throws FlywayException, NotConfigurationFoundException {
		migrationLogic.repair(env);
		return "repair done";
	}
}