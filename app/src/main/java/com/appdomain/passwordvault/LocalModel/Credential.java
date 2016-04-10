package com.appdomain.passwordvault.LocalModel;

/**
 * Created by Marcus on 4/10/2016.
 */
public class Credential {

	private String mID;
	private String mUsername;
	private String mPassword;
	private String mAdmin;

	public Credential(){}

	public Credential(String admin, String password, String username) {
		mAdmin = admin;
		mPassword = password;
		mUsername = username;
	}

	//region Setters
	public void setID(String id) { mID = id; }
	public void setAdmin(String admin) { mAdmin = admin; }
	public void setPassword(String password) { mPassword = password; }
	public void setUsername(String username) { mUsername = username; }
	//endregion

	//region Getters
	public String getmID() {
		return mID;
	}
	public String getAdmin() { return mAdmin; }
	public String getPassword() { return mPassword; }
	public String getUsername() { return mUsername; }
	//endregion

	public Credential resolveDBCredential(String id, com.appdomain.passwordvault.DBModel.Credential credential) {
		this.mID = id;
		this.mAdmin = credential.getAdmin();
		this.mPassword = credential.getPassword();
		this.mUsername = credential.getUsername();

		return this;
	}
}
