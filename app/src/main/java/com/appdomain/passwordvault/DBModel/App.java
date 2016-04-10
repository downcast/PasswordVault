package com.appdomain.passwordvault.DBModel;

/**
 * Created by Marcus on 4/10/2016.
 */
public class App {

	private String Name;
	private String Credential;
	private String Server;

	public App() {}

	public App(String name, String credential, String server){
		this.Name = name;
		this.Credential = credential;
		this.Server = server;
	}

	//region setters
	public void setName(String mName) { this.Name = mName; }
	public void setServer(String mServer) { this.Server = mServer; }
	public void setCredential(String credential) { Credential = credential; }
	//endregion

	//region getters
	public String getName() { return Name; }
	public String getServer() { return Server; }
	public String getCredential() { return Credential; }
	//endregion
}
