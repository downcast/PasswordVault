package com.appdomain.passwordvault.LocalModel;

/**
 * Created by Marcus on 4/3/2016.
 */
public class Server {

	private String mID;
	private String mName;
	private String mCredential;
	private String mDepartment;
	private String mTeam;
	private String mApp;

	public Server(){}

	public Server(String mApp, String mCredential, String mDepartment, String mID, String mName, String mTeam) {
		this.mApp = mApp;
		this.mCredential = mCredential;
		this.mDepartment = mDepartment;
		this.mID = mID;
		this.mName = mName;
		this.mTeam = mTeam;
	}

	//region Setters
	public void setID(String mID) { this.mID = mID; }
	public void setName(String name) { this.mName = name; }
	public void setCredential(String credential) { this.mCredential = credential; }
	public void setDepartment(String Department) { this.mDepartment = Department; }
	public void setTeam(String mTeam) { this.mTeam = mTeam; }
	public void setApp(String mApp) {
		this.mApp = mApp;
	}
	//endregion

	//region Getters
	public String getID() { return mID; }
	public String getName() { return mName; }
	public String getCredential() { return mCredential; }
	public String getDepartment() { return mDepartment; }
	public String getTeam() { return mTeam; }
	public String getApp() {
		return mApp;
	}

	//endregion
	public Server resolveDBServer(String id, com.appdomain.passwordvault.DBModel.Server server){
		this.mID = id;
		this.mName = server.getName();
		this.mCredential = server.getCredential();
		this.mDepartment = server.getDepartment();
		this.mTeam = server.getTeam();
		this.mApp = server.getApp();
		return this;
	}
}

