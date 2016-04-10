package com.appdomain.passwordvault.LocalModel;

/**
 * Created by Marcus on 4/3/2016.
 */
public class User {

	private String mID;
	private String mNameFirst;
	private String mNameLast;
	private String mCredential;
	private String mDepartment;
	private String mTeam;

	public User() {
	}

	public User(String firstName, String lastName, String Credential) {
		mNameFirst = firstName;
		mNameLast = lastName;
		mCredential = Credential;
	}

	//region Setters
	public void setID(String mID) {
		this.mID = mID;
	}
	public void setNameFirst(String nameFirst) {
		this.mNameFirst = nameFirst;
	}
	public void setNameLast(String nameLast) {
		this.mNameLast = nameLast;
	}
	public void setCredential(String Credential) {
		this.mCredential = Credential;
	}
	public void setDepartment(String Department) {
		this.mDepartment = Department;
	}
	public void setTeam(String mTeam) {
		this.mTeam = mTeam;
	}
	//endregion

	//region Getters
	public String getID() {
		return mID;
	}
	public String getNameFirst() {
		return mNameFirst;
	}
	public String getNameLast() {
		return mNameLast;
	}
	public String getCredential() {
		return mCredential;
	}
	public String getAllDepartments() {
		return mDepartment;
	}
	public String getAllTeams() {
		return mTeam;
	}
	//endregion

	/**
	 * Converts a dbModel user to a localModel user
	 */
	public User resolveDBUser(String id, com.appdomain.passwordvault.DBModel.User user) {
		this.mID = id;
		this.mNameFirst = user.getNameFirst();
		this.mNameLast = user.getNameLast();
		this.mCredential = user.getCredential();
		this.mDepartment = user.getDepartment();
		this.mTeam = user.getTeam();
		return this;
	}

}
