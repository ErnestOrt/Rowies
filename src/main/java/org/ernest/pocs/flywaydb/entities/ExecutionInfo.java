package org.ernest.pocs.flywaydb.entities;

public class ExecutionInfo {

	private String version;
	private String description;
	private String date;
	
	public ExecutionInfo() {}
	
	public ExecutionInfo(String version, String description){
		this.version = version;
		this.description = description;
	}
	
	public ExecutionInfo(String version, String description, String date) {
		this.version = version;
		this.description = description;
		this.date = date;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}