package com.appdomain.passwordvault.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.appdomain.passwordvault.R;

/**
 * Created by Marcus on 4/4/2016.
 */
public class FragmentProfile extends Fragment implements View.OnClickListener{

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

		TextView title = (TextView) root.findViewById(R.id.fragment_user_add_title);
		mFname = (EditText) root.findViewById(R.id.fragment_user_add_firstname_edit);
		mLname = (EditText) root.findViewById(R.id.fragment_user_add_lastname_edit);
		mPass = (EditText) root.findViewById(R.id.fragment_user_add_password_edit);
		mUser = (EditText) root.findViewById(R.id.fragment_user_add_username_edit);

		Button btn = (Button) root.findViewById(R.id.fragment_user_add_btn);

		title.setText("Profile");
		btn.setText("Update info");
		btn.setOnClickListener(this);
		return root;
	}

	@Override
	public void onClick(View view) {

		switch (view.getId()){
			case R.id.fragment_user_add_btn:
				// Update info
				break;
		}
	}
}
