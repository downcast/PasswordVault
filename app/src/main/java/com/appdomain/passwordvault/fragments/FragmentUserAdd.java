package com.appdomain.passwordvault.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.appdomain.passwordvault.DBModel.Credential;
import com.appdomain.passwordvault.LocalModel.ApplicationData;
import com.appdomain.passwordvault.LocalModel.Department;
import com.appdomain.passwordvault.LocalModel.Team;
import com.appdomain.passwordvault.LocalModel.User;
import com.appdomain.passwordvault.MainActivity;
import com.appdomain.passwordvault.R;

import java.util.ArrayList;

/**
 * Created by Marcus on 4/3/2016.
 */
public class FragmentUserAdd extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener{

	private EditText mFname;
	private EditText mLname;
	private EditText mPass;
	private EditText mUser;
	private Spinner mDepart;
	private Spinner mTeam;

	private String selectedDeptName = "-None-";
	private String selectedTeamName = "-None-";

	private Department currentDept = new Department(selectedDeptName, selectedDeptName, selectedDeptName, selectedDeptName);
	private Team currentTeam = new Team(selectedTeamName, selectedTeamName, selectedTeamName, selectedTeamName, selectedDeptName);

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_user_add, container, false);

		mFname = (EditText) root.findViewById(R.id.fragment_user_add_firstname_edit);
		mLname = (EditText) root.findViewById(R.id.fragment_user_add_lastname_edit);
		mPass = (EditText) root.findViewById(R.id.fragment_user_add_password_edit);
		mUser = (EditText) root.findViewById(R.id.fragment_user_add_username_edit);
		mDepart = (Spinner) root.findViewById(R.id.fragment_user_add_department_spinner);
		mTeam = (Spinner) root.findViewById(R.id.fragment_user_add_team_spinner);

		Button btn = (Button) root.findViewById(R.id.fragment_user_add_btn);
		btn.setOnClickListener(this);

		ArrayList<Department> departments = ApplicationData.getInstance().getAllDepartments();
		ArrayList<Team> teams = ApplicationData.getInstance().getAllTeams();

		ArrayList<String> deptContent = new ArrayList<>();
		ArrayList<String> teamContent = new ArrayList<>();

		deptContent.add("-None-");
		teamContent.add("-None-");

		for (Department d : departments){ deptContent.add(d.getName()); }
		for (Team t : teams){ teamContent.add(t.getName()); }

		mDepart.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_dropdown_item_1line, deptContent));
		mTeam.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_dropdown_item_1line, teamContent));

		mDepart.setOnItemSelectedListener(this);
		mTeam.setOnItemSelectedListener(this);
		return root;
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.fragment_user_add_btn:

				String fName = mFname.getText().toString();
				String lName = mLname.getText().toString();
				String pass = mPass.getText().toString();
				String user = mUser.getText().toString();

				String id = MainActivity.addDBData("Credential", new Credential("No", pass, user));
				MainActivity.addDBData("User", new com.appdomain.passwordvault.DBModel.User(fName, lName, id, currentDept.getID(), currentTeam.getID()));
				ApplicationData.getInstance().addUser(new User(fName, lName, id, currentDept.getID(), currentTeam.getID()));
				MainActivity.nextFragment(this, new FragmentPanelAdmin(), null, false, false);
				break;
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
		switch (adapterView.getId()){
			case R.id.fragment_user_add_department_spinner:
				selectedDeptName = (String) mDepart.getSelectedItem();

				ArrayList<Department> dept = ApplicationData.getInstance().getAllDepartments();
				for (Department d : dept){
					if (d.getName().equals(selectedDeptName)){
						currentDept = d;
						return;
					}
				}
				currentDept = new Department(selectedDeptName, selectedDeptName, selectedDeptName, selectedDeptName);
				break;
			case R.id.fragment_user_add_team_spinner:
				selectedTeamName = (String) mTeam.getSelectedItem();

				ArrayList<Team> team = ApplicationData.getInstance().getAllTeams();
				for (Team t : team){
					if (t.getName().equals(selectedTeamName)){
						currentTeam = t;
						return;
					}
				}
				currentTeam = new Team(selectedTeamName, selectedTeamName, selectedTeamName, selectedTeamName, selectedTeamName);
				break;
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> adapterView) {

	}
}
