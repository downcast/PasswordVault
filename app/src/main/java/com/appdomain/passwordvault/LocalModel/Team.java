package com.appdomain.passwordvault.LocalModel;

/**
 * Created by Marcus on 4/3/2016.
 */
public class Team {

	private String mID;
	private String mName;
	private String mUsers;
	private String mServers;
	private String mDepartments;

	public Team(){}

	public Team(String name, String users, String servers, String department){
		this.mName = name;
		this.mUsers = users;
		this.mServers = servers;
		this.mDepartments = department;
	}

	//region setters
	public void setID(String mID) { this.mID = mID; }
	public void setName(String mName) { this.mName = mName; }
	public void setUsers(String mUsers) { this.mUsers = mUsers; }
	public void setServers(String mServers) { this.mServers = mServers; }
	public void setDepartments(String mDepartments) {
		this.mDepartments = mDepartments;
	}
	//endregion

	//region getters
	public String getID() { return mID; }
	public String getName() { return mName; }
	public String getUsers() { return mUsers; }
	public String getServers() { return mServers; }
	public String getDepartments() { return mDepartments; }
	//endregion

	public Team resolveDBTeam(String id, com.appdomain.passwordvault.DBModel.Team team){
		this.mID = id;
		this.mName = team.getName();
		this.mUsers = team.getUser();
		this.mServers = team.getServer();
		this.mDepartments = team.getDepartment();
		return this;
	}
}

