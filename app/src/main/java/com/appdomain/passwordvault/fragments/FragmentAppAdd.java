package com.appdomain.passwordvault.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.appdomain.passwordvault.LocalModel.App;
import com.appdomain.passwordvault.LocalModel.ApplicationData;
import com.appdomain.passwordvault.MainActivity;
import com.appdomain.passwordvault.R;

/**
 * Created by Marcus on 4/3/2016.
 */
public class FragmentAppAdd extends Fragment implements View.OnClickListener{

	private EditText mName;
	private EditText mPass;
	private EditText mUser;
	private Spinner mServer;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_app_add, container, false);

		mName = (EditText) root.findViewById(R.id.fragment_app_add_name_edit);
		mPass = (EditText) root.findViewById(R.id.fragment_app_add_password_edit);
		mUser = (EditText) root.findViewById(R.id.fragment_app_add_username_edit);

		Button btn = (Button) root.findViewById(R.id.fragment_app_add_btn);
		btn.setOnClickListener(this);
		return root;

	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.fragment_app_add_btn:

				String name = mName.getText().toString();
				String pass = mPass.getText().toString();
				String user = mUser.getText().toString();

				ApplicationData.getInstance().addApp(new App(name, user, pass));
				MainActivity.nextFragment(this, new FragmentServerAdd(), null, false, false);
				break;
		}
	}
}
