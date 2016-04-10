package com.appdomain.passwordvault.LocalModel;

import android.util.Log;

import com.firebase.client.DataSnapshot;

import java.util.ArrayList;
import java.util.HashMap;

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
	private ArrayList<Credential> mCredentials;

	private HashMap<String, com.appdomain.passwordvault.DBModel.User> mDBUserMap;
	private HashMap<String, com.appdomain.passwordvault.DBModel.Department> mDBDepartmentMap;
	private HashMap<String, com.appdomain.passwordvault.DBModel.Server> mDBServerMap;
	private HashMap<String, com.appdomain.passwordvault.DBModel.Team> mDBTeamMap;
	private HashMap<String, com.appdomain.passwordvault.DBModel.App> mDBAppMap;
	private HashMap<String, com.appdomain.passwordvault.DBModel.Credential> mDBCredentialMap;

	private ApplicationData() {
		mUsers = new ArrayList<>();
		mDepts = new ArrayList<>();
		mServers = new ArrayList<>();
		mTeams = new ArrayList<>();
		mApps = new ArrayList<>();

		mDBUserMap = new HashMap<>();
		mDBDepartmentMap = new HashMap<>();
		mDBServerMap = new HashMap<>();
		mDBTeamMap = new HashMap<>();
		mDBAppMap = new HashMap<>();
		mDBCredentialMap = new HashMap<>();
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
	public void addCredential(Credential obj){ this.mCredentials.add(obj); }

	public User getUser(int i) { return this.mUsers.get(i); }
	public Server getServer(int i) { return this.mServers.get(i); }
	public Department getDepartment(int i) { return this.mDepts.get(i); }
	public Team getTeam(int i) { return this.mTeams.get(i); }
	public App getApp(int i) { return this.mApps.get(i); }
	public Credential getCredential(int i) { return this.mCredentials.get(i); }

	public ArrayList<User> getAllUsers() { return this.mUsers; }
	public ArrayList<Server> getAllServers() { return this.mServers; }
	public ArrayList<Department> getAllDepartments() { return this.mDepts; }
	public ArrayList<Team> getAllTeams() { return this.mTeams; }
	public ArrayList<App> getAllApps() { return this.mApps; }
	public ArrayList<Credential> getAllCredential() { return this.mCredentials; }

	public void loadDBData(DataSnapshot dataSnapshot){

		// Get Data
		for (DataSnapshot ds : dataSnapshot.getChildren()) {    // Goes gown to the ID level
			for (DataSnapshot ddss : ds.getChildren()) {        // Goes to the object level
				try {
					mDBAppMap.put(ddss.getKey(),ddss.getValue(com.appdomain.passwordvault.DBModel.App.class));
					Log.d("Firebase", "Getting App data for the first time");
				} catch (Exception e) {
					try {
						mDBCredentialMap.put(ddss.getKey(),ddss.getValue(com.appdomain.passwordvault.DBModel.Credential.class));
						Log.d("Firebase", "Getting credential data for the first time");
					} catch (Exception e1) {
						try {
							mDBDepartmentMap.put(ddss.getKey(),ddss.getValue(com.appdomain.passwordvault.DBModel.Department.class));
							Log.d("Firebase", "Getting department data for the first time");
						} catch (Exception e2) {
							try {
								mDBServerMap.put(ddss.getKey(),ddss.getValue(com.appdomain.passwordvault.DBModel.Server.class));
								Log.d("Firebase", "Getting server data for the first time");
							} catch (Exception e3) {
								try {
									mDBTeamMap.put(ddss.getKey(),ddss.getValue(com.appdomain.passwordvault.DBModel.Team.class));
									Log.d("Firebase", "Getting team data for the first time");
								} catch (Exception e4) {
									try {
										mDBUserMap.put(ddss.getKey(),ddss.getValue(com.appdomain.passwordvault.DBModel.User.class));
										Log.d("Firebase", "Getting user data for the first time");
									} catch (Exception e5) {
										e5.printStackTrace();
									}
								}
							}
						}
					}
				}

			}
		}

		// Parse data
		for (HashMap.Entry<String, com.appdomain.passwordvault.DBModel.App> entry : mDBAppMap.entrySet()){
			//mApps.add(new App().resolveDBApp(entry.getKey(), entry.getValue()));
		}
		for (HashMap.Entry<String, com.appdomain.passwordvault.DBModel.Credential> entry : mDBCredentialMap.entrySet()){
			//mCredentials.add(new Credential().resolveDBCredential(entry.getKey(), entry.getValue()));
		}
		for (HashMap.Entry<String, com.appdomain.passwordvault.DBModel.Department> entry : mDBDepartmentMap.entrySet()){
			//mDepts.add(new Department().resolveDBDepartment(entry.getKey(), entry.getValue()));
		}
		for (HashMap.Entry<String, com.appdomain.passwordvault.DBModel.Server> entry : mDBServerMap.entrySet()){
			//mServers.add(new Server().resolveDBServer(entry.getKey(), entry.getValue()));
		}
		for (HashMap.Entry<String, com.appdomain.passwordvault.DBModel.Team> entry : mDBTeamMap.entrySet()){
			//mTeams.add(new Team().resolveDBTeam(entry.getKey(), entry.getValue()));
		}
		for (HashMap.Entry<String, com.appdomain.passwordvault.DBModel.User> entry : mDBUserMap.entrySet()){
			//mUsers.add(new User().resolveDBUser(entry.getKey(), entry.getValue()));
		}

	}
}
