package org.ernest.pocs.flywaydb.entities;

import java.util.ArrayList;
import java.util.List;

public class InstanceInformation {

	private String imgCode;
	private String code;
	private String name;
	private ExecutionInfo current;
	private List<ExecutionInfo> executionsPendingList;
	
	public InstanceInformation(){
		executionsPendingList = new ArrayList<ExecutionInfo>();
	}
	
	public ExecutionInfo getCurrent() {
		return current;
	}
	public void setCurrent(ExecutionInfo current) {
		this.current = current;
	}
	public List<ExecutionInfo> getExecutionsPendingList() {
		return executionsPendingList;
	}
	public void setExecutionsPendingList(List<ExecutionInfo> executionsPendingList) {
		this.executionsPendingList = executionsPendingList;
	}
	public String getImgCode() {
		return imgCode;
	}
	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
