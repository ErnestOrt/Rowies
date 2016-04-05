package org.ernest.pocs.flywaydb.entities;

public class Database {
	
	private int sorting;
	private String imgCode;
	private String code;
	private String name;
	private String stringConnection;
	private String user;
	private String pass;
	

	public String getImgCode() {
		return imgCode;
	}
	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getStringConnection() {
		return stringConnection;
	}
	public void setStringConnection(String stringConnection) {
		this.stringConnection = stringConnection;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getSorting() {
		return sorting;
	}
	public void setSorting(int sorting) {
		this.sorting = sorting;
	}
}
