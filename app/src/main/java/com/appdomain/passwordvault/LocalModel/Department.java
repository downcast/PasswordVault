package com.appdomain.passwordvault.LocalModel;

/**
 * Created by Marcus on 4/3/2016.
 */
public class Department {

	private String mID;
	private String mName;
	private String mUsers;
	private String mServers;

	public Department(){}

	public Department(String name, String users, String servers, String id){
		this.mName = name;
		this.mUsers = users;
		this.mServers = servers;
		this.mID = id;
	}

	//region setters
	public void setID(String mID) { this.mID = mID; }
	public void setName(String mName) { this.mName = mName; }
	public void setUsers(String mUsers) {
		this.mUsers = mUsers;
	}
	public void setServers(String mServers) {
		this.mServers = mServers;
	}
	//endregion

	//region getters
	public String getID() { return mID; }
	public String getName() { return mName; }
	public String getUsers() {
		return mUsers;
	}
	public String getServers() {
		return mServers;
	}
	//endregion

	public Department resolveDBDepartment(String id, com.appdomain.passwordvault.DBModel.Department department){
		this.mID = id;
		this.mName = department.getName();
		this.mUsers = department.getUsers();
		this.mServers = department.getServers();
		return this;
	}
}

