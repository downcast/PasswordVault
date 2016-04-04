package com.appdomain.passwordvault.Fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.appdomain.passwordvault.Adapters.AdapterListView;
import com.appdomain.passwordvault.MainActivity;
import com.appdomain.passwordvault.R;

/**
 * Created by Marcus on 3/7/2016.
 */
public class FragmentTeam extends Fragment implements View.OnClickListener{

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_section, container, false);

		TextView heading1 = (TextView) root.findViewById(R.id.fragment_section_heading_item1);
		TextView heading2 = (TextView) root.findViewById(R.id.fragment_section_heading_item2);
		ListView list = (ListView) root.findViewById(R.id.fragment_section_listview);
		FloatingActionButton fab = (FloatingActionButton) root.findViewById(R.id.fragment_section_fab);

		list.setAdapter(new AdapterListView(getActivity(), this));
		heading1.setText(R.string.header_teams_heading1);
		heading2.setText(R.string.header_teams_heading2);
		fab.setOnClickListener(this);
		return root;
	}

	@Override
	public void onClick(View view) {

		TabLayout tabLayout = (TabLayout) getActivity().findViewById(R.id.activity_tabs);
		tabLayout.setVisibility(View.GONE);

		switch (view.getId()){
			case R.id.fragment_section_fab:
				MainActivity.nextFragment(this, new FragmentTeamAdd(), null, false, false);
				break;
		}
	}
}
