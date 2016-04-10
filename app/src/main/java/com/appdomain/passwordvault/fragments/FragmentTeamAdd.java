package com.appdomain.passwordvault.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.appdomain.passwordvault.LocalModel.ApplicationData;
import com.appdomain.passwordvault.LocalModel.Team;
import com.appdomain.passwordvault.MainActivity;
import com.appdomain.passwordvault.R;

/**
 * Created by Marcus on 4/4/2016.
 */
public class FragmentTeamAdd extends Fragment implements View.OnClickListener{

	private EditText mName;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_team_add, container, false);

		mName = (EditText) root.findViewById(R.id.fragment_team_add_name_edit);

		Button btn = (Button) root.findViewById(R.id.fragment_team_add_btn);
		btn.setOnClickListener(this);
		return root;
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.fragment_team_add_btn:

				String name = mName.getText().toString();

				ApplicationData.getInstance().addTeam(new Team(name, null, null, null));
				MainActivity.nextFragment(this, new FragmentPanelAdmin(), null, false, false);
				break;
		}
	}
}
