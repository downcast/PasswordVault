package com.appdomain.passwordvault.LocalModel;

/**
 * Created by Marcus on 4/3/2016.
 */
public class App {

	private String mID;
	private String mName;
	private String mCredential;
	private String mServer;

	public App(){}

	public App(String name, String credential, String server){
		this.mName = name;
		this.mCredential = credential;
		this.mServer = server;
	}

	//region setters
	public void setID(String mID) { this.mID = mID; }
	public void setName(String mName) { this.mName = mName; }
	public void setNameUser(String mCredential) { this.mCredential = mCredential; }
	public void setServer(String mServer) { this.mServer = mServer; }
	//endregion

	//region getters
	public String getID() { return mID; }
	public String getName() { return mName; }
	public String getNameUser() { return mCredential; }
	public String getServer() { return mServer; }
	//endregion

	public App resolveDBApp(String id, com.appdomain.passwordvault.DBModel.App app) {
		this.mID = id;
		this.mName = app.getName();
		this.mServer = app.getServer();
		this.mCredential = app.getCredential();
		return this;
	}
}
