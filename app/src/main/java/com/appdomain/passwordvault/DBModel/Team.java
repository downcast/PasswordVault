package com.appdomain.passwordvault.DBModel;

/**
 * Created by Marcus on 4/10/2016.
 */
public class Team {
	private String Name;
	private String Users;
	private String Servers;
	private String Departments;

	public Team() {}

	public Team(String name, String users, String servers, String department){
		this.Name = name;
		this.Users = users;
		this.Servers = servers;
		this.Departments = department;
	}

	//region setters
	public void setName(String mName) { this.Name = mName; }
	public void setDepartment(String departments) { Departments = departments; }
	public void setServer(String servers) { Servers = servers; }
	public void setUser(String users) { Users = users; }
	//endregion

	//region getters
	public String getName() { return Name; }
	public String getDepartment() { return Departments; }
	public String getServer() { return Servers; }
	public String getUser() { return Users; }
	//endregion
}
