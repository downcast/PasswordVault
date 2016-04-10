package com.appdomain.passwordvault.LocalModel;

import java.util.ArrayList;

/**
 * Created by Marcus on 4/3/2016.
 */
public class Department {

	private String mID;
	private String mName;
	private ArrayList<User> mUsers;
	private ArrayList<Server> mServers;

	public Department(String name, ArrayList<User> users, ArrayList<Server> servers){
		this.mName = name;
		this.mUsers = users;
		this.mServers = servers;
	}

	//region setters
	public void setID(String mID) { this.mID = mID; }
	public void setName(String mName) { this.mName = mName; }
	//endregion

	//region getters
	public String getID() { return mID; }
	public String getName() { return mName; }
	//endregion
}
