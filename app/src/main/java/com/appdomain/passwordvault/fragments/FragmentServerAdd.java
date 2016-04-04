package com.appdomain.passwordvault.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.appdomain.passwordvault.Adapters.AdapterListView;
import com.appdomain.passwordvault.MainActivity;
import com.appdomain.passwordvault.Model.App;
import com.appdomain.passwordvault.Model.ApplicationData;
import com.appdomain.passwordvault.Model.Department;
import com.appdomain.passwordvault.Model.Server;
import com.appdomain.passwordvault.Model.Team;
import com.appdomain.passwordvault.R;

import java.util.ArrayList;

/**
 * Created by Marcus on 4/3/2016.
 */
public class FragmentServerAdd extends Fragment  implements View.OnClickListener{

	private EditText mName;
	private EditText mPass;
	private EditText mUser;
	private ArrayList<Department> mDepart;
	private ArrayList<Team> mTeam;
	private ArrayList<App> mApp;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_server_add, container, false);

		mName = (EditText) root.findViewById(R.id.fragment_server_add_name_edit);
		mPass = (EditText) root.findViewById(R.id.fragment_server_add_password_edit);
		mUser = (EditText) root.findViewById(R.id.fragment_server_add_username_edit);
		ListView list = (ListView) root.findViewById(R.id.fragment_server_add_app_list);

		list.setAdapter(new AdapterListView(getActivity(), this));
		Button createBtn = (Button) root.findViewById(R.id.fragment_server_add_btn_create);
		Button addBtn = (Button) root.findViewById(R.id.fragment_server_add_btn_add);
		createBtn.setOnClickListener(this);
		addBtn.setOnClickListener(this);
		return root;
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.fragment_server_add_btn_create:

				String name = mName.getText().toString();
				String pass = mPass.getText().toString();
				String user = mUser.getText().toString();

				ApplicationData.getInstance().addServer(new Server(name, user, pass));
				MainActivity.nextFragment(this, new FragmentPanelAdmin(), null, false, false);
				break;
			case R.id.fragment_server_add_btn_add:
				MainActivity.nextFragment(this, new FragmentAppAdd(), null, false, false);
				break;
		}
	}
}

