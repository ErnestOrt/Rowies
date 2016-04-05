package org.ernest.pocs.flywaydb.entities;

import java.util.ArrayList;
import java.util.List;

public class DatabasesConfiguration {

	private List<Database> databases;
	
	public DatabasesConfiguration(){
		databases = new ArrayList<Database>();
	}

	public List<Database> getDatabases() {
		return databases;
	}

	public void setDatabases(List<Database> databases) {
		this.databases = databases;
	}
}