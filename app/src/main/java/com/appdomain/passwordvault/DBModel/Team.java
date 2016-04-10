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
	public void setDepartments(String departments) { Departments = departments; }
	public void setServers(String servers) { Servers = servers; }
	public void setUsers(String users) { Users = users; }
	//endregion

	//region getters
	public String getName() { return Name; }
	public String getDepartments() { return Departments; }
	public String getServers() { return Servers; }
	public String getUsers() { return Users; }
	//endregion
}
