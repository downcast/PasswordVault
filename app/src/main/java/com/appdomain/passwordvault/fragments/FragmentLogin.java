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

/**
 * Created by Marcus on 4/4/2016.
 */
public class FragmentLogin extends Fragment implements View.OnClickListener{

	private EditText mUsername;
	private EditText mPassword;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_login, container, false);

		mUsername = (EditText) root.findViewById(R.id.fragment_login_username_edit);
		mPassword = (EditText) root.findViewById(R.id.fragment_login_password_edit);
		Button btn = (Button) root.findViewById(R.id.fragment_login_btn);

		btn.setOnClickListener(this);
		return root;
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.fragment_login_btn:

				if (mUsername.getText().toString().equals(ApplicationData.getInstance().getUser(0).getNameUser()))
					MainActivity.nextFragment(this, new FragmentPanelAdmin(), null, false, false);
				else
					MainActivity.nextFragment(this, new FragmentPanelAdminNon(), null, false, false);
				break;
		}
	}
}
