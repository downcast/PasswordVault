package com.appdomain.passwordvault.LocalModel;

import java.util.ArrayList;

/**
 * Created by Marcus on 4/3/2016.
 */
public class Server {

	private String mID;
	private String mName;
	private String mNameUser;
	private String mPassword;
	private ArrayList<Department> mDepartment;
	private ArrayList<Team> mTeam;
	private ArrayList<App> mApp;

	public Server(String name, String userName, String password){
		mName = name;
		mNameUser = userName;
		mPassword = password;
	}

	//region Setters
	public void setID(String mID) { this.mID = mID; }
	public void setName(String name) { this.mName = name; }
	public void setNameUser(String nameUser) { this.mNameUser = nameUser; }
	public void setPassword(String password) { this.mPassword = password; }
	public void setTeam(ArrayList<Team> mTeam) { this.mTeam = mTeam; }
	//endregion

	//region Getters
	public String getID() { return mID; }
	public String getName() { return mName; }
	public String getNameUser() { return mNameUser; }
	public String getPassword() { return mPassword; }
	public ArrayList<Department> getAllDepartments() { return mDepartment; }
	public ArrayList<Team> getAllTeams() { return mTeam; }
	//endregion
}
