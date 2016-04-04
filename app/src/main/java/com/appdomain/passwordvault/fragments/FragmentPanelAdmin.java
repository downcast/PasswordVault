package com.appdomain.passwordvault.Fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appdomain.passwordvault.Adapters.AdapterPanelAdmin;
import com.appdomain.passwordvault.R;

/**
 * Created by Marcus on 4/3/2016.
 */
public class FragmentPanelAdmin extends Fragment {

	private AdapterPanelAdmin mAdapterPanelAdmin;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		if (mAdapterPanelAdmin == null) {
			mAdapterPanelAdmin = new AdapterPanelAdmin(getChildFragmentManager());
		}

		// Set up the ViewPager with the sections adapter.
		ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.fragment_panel_admin_pager);
		viewPager.setAdapter(mAdapterPanelAdmin);

		TabLayout tabLayout = (TabLayout) getActivity().findViewById(R.id.activity_tabs);
		tabLayout.setVisibility(View.VISIBLE);
		tabLayout.setupWithViewPager(viewPager);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_panel_admin, container, false);
	}

}
