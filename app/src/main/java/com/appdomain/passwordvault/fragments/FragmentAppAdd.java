package com.appdomain.passwordvault.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import com.appdomain.passwordvault.DBModel.Credential;
import com.appdomain.passwordvault.LocalModel.App;
import com.appdomain.passwordvault.LocalModel.ApplicationData;
import com.appdomain.passwordvault.LocalModel.Server;
import com.appdomain.passwordvault.MainActivity;
import com.appdomain.passwordvault.R;

/**
 * Created by Marcus on 4/3/2016.
 */
public class FragmentAppAdd extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener{

	private EditText mName;
	private EditText mPass;
	private EditText mUser;
	private Spinner mServer;

	private String selectedServerName = "-None-";

	private Server currentServer = new Server(selectedServerName, selectedServerName, selectedServerName, selectedServerName, selectedServerName, selectedServerName);

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_app_add, container, false);

		/*mName = (EditText) root.findViewById(R.id.fragment_app_add_name_edit);
		mPass = (EditText) root.findViewById(R.id.fragment_app_add_password_edit);
		mUser = (EditText) root.findViewById(R.id.fragment_app_add_username_edit);
		//mServer = (Spinner) root.findViewById(R.id.fragment_app_add_server_spinner);

		Button btn = (Button) root.findViewById(R.id.fragment_app_add_btn);
		btn.setOnClickListener(this);

		ArrayList<Server> server = ApplicationData.getInstance().getAllServers();

		ArrayList<String> servContent = new ArrayList<>();
		servContent.add("-None-");
		for (Server t : server){ servContent.add(t.getName()); }

		mServer.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_dropdown_item_1line, servContent));
		mServer.setOnItemSelectedListener(this);
		*/
		return root;
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.fragment_app_add_btn:

				String name = mName.getText().toString();
				String pass = mPass.getText().toString();
				String user = mUser.getText().toString();

				String id = MainActivity.addDBData("Credential", new Credential("No", pass, user));
				String appID = MainActivity.addDBData("App", new com.appdomain.passwordvault.DBModel.App(name, id, "TBD"));
				ApplicationData.getInstance().addApp(new App(id, appID, name, "TBD"));

				FragmentServerAdd.addedApps.add(new App(id, appID, name, "TBD"));
				MainActivity.nextFragment(this, new FragmentServerAdd(), null, false, false);
				break;
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
		/*switch (adapterView.getId()){
			case R.id.fragment_app_add_server_spinner:
				selectedServerName = (String) mServer.getSelectedItem();

				ArrayList<Server> server = ApplicationData.getInstance().getAllServers();
				for (Server d : server){
					if (d.getName().equals(selectedServerName)){
						currentServer = d;
						return;
					}
				}
				currentServer = new Server(selectedServerName, selectedServerName, selectedServerName, selectedServerName, selectedServerName, selectedServerName);
				break;
		}*/
	}

	@Override
	public void onNothingSelected(AdapterView<?> adapterView) {

	}
}
