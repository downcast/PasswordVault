package com.appdomain.passwordvault.DBModel;

/**
 * Created by Marcus on 4/9/2016.
 */
public class User {

	private String NameFirst;
	private String NameLast;
	private String Credential;
	private String Department;
	private String Team;

	public User(){}

	public User(String NameFirst, String NameLast, String credential, String department, String team){
		this.NameFirst = NameFirst;
		this.NameLast = NameLast;
		Credential = credential;
		Department = department;
		Team = team;
	}

	//region Setters
	public void setNameFirst(String nameFirst) { this.NameFirst = nameFirst; }

	public void setNameLast(String nameLast) { this.NameLast = nameLast; }

	public void setCredential(String credential) { this.Credential = credential; }

	public void setTeam(String Team) { this.Team = Team; }

	public void setDepartment(String department) { this.Department = department; }
	//endregion

	//region Getters
	public String getNameFirst() { return NameFirst; }

	public String getNameLast() { return NameLast; }

	public String getCredential() { return Credential; }

	public String getDepartment() { return Department; }

	public String getTeam() { return Team; }
	//endregion
}
