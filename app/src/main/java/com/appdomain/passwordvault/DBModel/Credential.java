package com.appdomain.passwordvault.DBModel;

/**
 * Created by Marcus on 4/10/2016.
 */
public class Credential {

	private String Username;
	private String Password;
	private String Admin;

	public Credential(){}

	public Credential(String admin, String password, String username) {
		Admin = admin;
		Password = password;
		Username = username;
	}

	//region Setters
	public void setAdmin(String admin) { Admin = admin; }
	public void setPassword(String password) { Password = password; }
	public void setUsername(String username) { Username = username; }
	//endregion

	//region Getters
	public String getAdmin() { return Admin; }
	public String getPassword() { return Password; }
	public String getUsername() { return Username; }
	//endregion
}
