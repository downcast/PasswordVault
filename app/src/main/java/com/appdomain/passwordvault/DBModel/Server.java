package com.appdomain.passwordvault.DBModel;

/**
 * Created by Marcus on 4/10/2016.
 */
public class Server {

	private String Name;
	private String Credential;
	private String Department;
	private String Team;
	private String App;

	public Server() {}

	public Server(String app, String credential, String department, String name, String team) {
		App = app;
		Credential = credential;
		Department = department;
		Name = name;
		Team = team;
	}

	//region Setters
	public void setName(String name) { this.Name = name; }
	public void setCredential(String credential) { this.Credential = credential; }
	public void setApp(String app) { App = app; }
	public void setDepartment(String department) { Department = department; }
	public void setTeam(String mTeam) { this.Team = mTeam; }
	//endregion

	//region Getters
	public String getName() { return Name; }
	public String getCredential() { return Credential; }
	public String getApp() { return App; }
	public String getDepartment() { return Department; }
	public String getTeam() { return Team; }
	//endregion
}
