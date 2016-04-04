package com.appdomain.passwordvault.Model;

import java.util.ArrayList;

/**
 * Created by Marcus on 4/3/2016.
 */
public class ApplicationData {

	private static ApplicationData sInstance = null;

	private ArrayList<User> mUsers;
	private ArrayList<Department> mDepts;
	private ArrayList<Server> mServers;
	private ArrayList<Team> mTeams;
	private ArrayList<App> mApps;

	private ApplicationData() {
		mUsers = new ArrayList<>();
		mDepts = new ArrayList<>();
		mServers = new ArrayList<>();
		mTeams = new ArrayList<>();
		mApps = new ArrayList<>();
	}

	public static ApplicationData getInstance() {
		if (sInstance == null) {
			sInstance = new ApplicationData();
			return sInstance;
		} else {
			return sInstance;
		}
	}


	public void addUser(User obj){ this.mUsers.add(obj); }
	public void addServer(Server obj){ this.mServers.add(obj); }
	public void addDepartment(Department obj){ this.mDepts.add(obj); }
	public void addTeam(Team obj){ this.mTeams.add(obj); }
	public void addApp(App obj){ this.mApps.add(obj); }

	public User getUser(int i) { return this.mUsers.get(i); }
	public Server getServer(int i) { return this.mServers.get(i); }
	public Department getDepartment(int i) { return this.mDepts.get(i); }
	public Team getTeam(int i) { return this.mTeams.get(i); }
	public App getApp(int i) { return this.mApps.get(i); }

	public ArrayList<User> getAllUsers() { return this.mUsers; }
	public ArrayList<Server> getAllServers() { return this.mServers; }
	public ArrayList<Department> getAllDepartments() { return this.mDepts; }
	public ArrayList<Team> getAllTeams() { return this.mTeams; }
	public ArrayList<App> getAllApps() { return this.mApps; }
}
