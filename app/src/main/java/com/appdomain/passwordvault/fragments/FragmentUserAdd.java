package com.appdomain.passwordvault.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.appdomain.passwordvault.LocalModel.ApplicationData;
import com.appdomain.passwordvault.LocalModel.User;
import com.appdomain.passwordvault.MainActivity;
import com.appdomain.passwordvault.R;

/**
 * Created by Marcus on 4/3/2016.
 */
public class FragmentUserAdd extends Fragment implements View.OnClickListener{

	private EditText mFname;
	private EditText mLname;
	private EditText mPass;
	private EditText mUser;

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

		Button btn = (Button) root.findViewById(R.id.fragment_user_add_btn);
		btn.setOnClickListener(this);
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

				ApplicationData.getInstance().addUser(new User(fName, lName, user));
				MainActivity.nextFragment(this, new FragmentPanelAdmin(), null, false, false);
				break;
		}
	}
}
