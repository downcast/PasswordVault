package com.appdomain.passwordvault.DBModel;

/**
 * Created by Marcus on 4/10/2016.
 */
public class Department {

	private String Name;
	private String Users;
	private String Servers;

	public Department() {}

	public Department(String name, String users, String servers){
		this.Name = name;
		this.Users = users;
		this.Servers = servers;
	}

	//region setters
	public void setName(String mName) { this.Name = mName; }
	public void setServers(String servers) { Servers = servers; }
	public void setUsers(String users) { Users = users; }
	//endregion

	//region getters
	public String getName() { return Name; }
	public String getServers() { return Servers; }
	public String getUsers() { return Users; }
	//endregion
}
