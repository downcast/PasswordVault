package com.appdomain.passwordvault.DBModel;

/**
 * Created by Marcus on 4/9/2016.
 */
public class User {

	private String FirstName;
	private String LastName;
	private String Credential;
	private String Department;
	private String Team;

	public User(){}

	public User(String firstName, String lastName, String credential, String department, String team){
		FirstName = firstName;
		LastName = lastName;
		Credential = credential;
		Department = department;
		Team = team;
	}

	//region Setters
	public void setNameFirst(String nameFirst) { this.FirstName = nameFirst; }

	public void setNameLast(String nameLast) { this.LastName = nameLast; }

	public void setCredential(String credential) { this.Credential = credential; }

	public void setTeam(String Team) { this.Team = Team; }

	public void setDepartment(String department) { this.Department = department; }
	//endregion

	//region Getters
	public String getNameFirst() { return FirstName; }

	public String getNameLast() { return LastName; }

	public String getCredential() { return Credential; }

	public String getDepartment() { return Department; }

	public String getTeam() { return Team; }
	//endregion
}
