package com.appdomain.passwordvault.Model;

import java.util.ArrayList;

/**
 * Created by Marcus on 4/3/2016.
 */
public class App {

	private String mName;
	private String mNameUser;
	private String mPassword;
	private Server mServer;

	public App(String name, String userName, String password, Server server){
		this.mName = name;
		this.mNameUser = userName;
		this.mPassword = password;
		this.mServer = server;
	}

	//region setters
	public void setName(String mName) { this.mName = mName; }
	public void setNameUser(String mNameUser) { this.mNameUser = mNameUser; }
	public void setPassword(String mPassword) { this.mPassword = mPassword; }
	public void setServer(Server mServer) { this.mServer = mServer; }
	//endregion

	//region getters
	public String getName() { return mName; }
	public String getNameUser() { return mNameUser; }
	public String getPassword() { return mPassword; }
	public Server getServer() { return mServer; }
	//endregion
}
