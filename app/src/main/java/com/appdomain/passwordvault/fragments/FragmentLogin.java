package com.appdomain.passwordvault.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.appdomain.passwordvault.LocalModel.ApplicationData;
import com.appdomain.passwordvault.MainActivity;
import com.appdomain.passwordvault.R;

import java.util.ArrayList;

/**
 * Created by Marcus on 4/4/2016.
 */
public class FragmentLogin extends Fragment implements View.OnClickListener{

	private EditText mUsername;
	private EditText mPassword;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		mUsername = (EditText) getActivity().findViewById(R.id.fragment_login_username_edit);
		mPassword = (EditText) getActivity().findViewById(R.id.fragment_login_password_edit);
		Button btn = (Button) getActivity().findViewById(R.id.fragment_login_btn);

		btn.setOnClickListener(this);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_login, container, false);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.fragment_login_btn:

				String username = mUsername.getText().toString();
				String password = mPassword.getText().toString();

				ArrayList<com.appdomain.passwordvault.LocalModel.Credential> creds = ApplicationData.getInstance().getAllCredential();

				for (com.appdomain.passwordvault.LocalModel.Credential c : creds){
					if (username.equals(c.getUsername()) && password.equals(c.getPassword())){
						if (c.getAdmin().equals("Yes")){

							ArrayList<com.appdomain.passwordvault.LocalModel.User> user = ApplicationData.getInstance().getAllUsers();

							for (com.appdomain.passwordvault.LocalModel.User u : user){
								if (u.getCredential().equals(c.getID())){
									ApplicationData.getInstance().setCurrentUser(u);
									break;
								}
							}

							MainActivity.nextFragment(this, new FragmentPanelAdmin(), null, false, false);
							break;
						} else {
							MainActivity.nextFragment(this, new FragmentPanelAdminNon(), null, false, false);
							break;
						}
					}
				}
				break;
		}
	}
}
