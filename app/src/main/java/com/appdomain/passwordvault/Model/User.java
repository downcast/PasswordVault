package com.appdomain.passwordvault.Model;

import java.util.ArrayList;

/**
 * Created by Marcus on 4/3/2016.
 */
public class User {
	private String mNameFirst;
	private String mNameLast;
	private String mNameUser;
	private String mPassword;
	private ArrayList<Department> mDepartment;
	private ArrayList<Team> mTeam;

	public User(String firstName, String lastName, String userName, String password){
		mNameFirst = firstName;
		mNameLast = lastName;
		mNameUser = userName;
		mPassword = password;
	}

	//region Setters
	public void setNameFirst(String nameFirst) { this.mNameFirst = nameFirst; }

	public void setNameLast(String nameLast) { this.mNameLast = nameLast; }

	public void setNameUser(String nameUser) { this.mNameUser = nameUser; }

	public void setPassword(String password) { this.mPassword = password; }

	public void setTeam(ArrayList<Team> mTeam) { this.mTeam = mTeam; }
	//endregion

	//region Getters
	public String getNameFirst() { return mNameFirst; }

	public String getNameLast() { return mNameLast; }

	public String getNameUser() { return mNameUser; }

	public String getPassword() { return mPassword; }

	public ArrayList<Department> getAllDepartments() { return mDepartment; }

	public ArrayList<Team> getAllTeams() { return mTeam; }
	//endregion
}
