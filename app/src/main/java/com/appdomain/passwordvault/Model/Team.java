package com.appdomain.passwordvault.Model;

import java.util.ArrayList;

/**
 * Created by Marcus on 4/3/2016.
 */
public class Team {
	private String mName;
	private ArrayList<User> mUsers;
	private ArrayList<Server> mServers;
	private ArrayList<Department> mDepartments;

	public Team(String name, ArrayList<User> users, ArrayList<Server> servers, ArrayList<Department> department){
		this.mName = name;
		this.mUsers = users;
		this.mServers = servers;
		this.mDepartments = department;
	}

	//region setters
	public void setName(String mName) { this.mName = mName; }
	//endregion

	//region getters
	public String getName() { return mName; }
	//endregion
}
