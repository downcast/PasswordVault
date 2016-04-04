package com.appdomain.passwordvault.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.appdomain.passwordvault.Fragments.FragmentDepartment;
import com.appdomain.passwordvault.Fragments.FragmentServer;
import com.appdomain.passwordvault.Fragments.FragmentTeam;
import com.appdomain.passwordvault.Fragments.FragmentUser;

/**
 * Created by Marcus on 3/7/2016.
 */
public class AdapterPanelAdmin extends FragmentStatePagerAdapter {

	public AdapterPanelAdmin(FragmentManager fm) {
		super(fm);
	}

	@Override
	public int getCount() {
		return 4;
	}

	@Override
	public Fragment getItem(int position) {

		switch (position){
			case 0:
				return new FragmentUser();
			case 1:
				return new FragmentServer();
			case 2:
				return new FragmentDepartment();
			case 3:
				return new FragmentTeam();
			default:
				return new FragmentUser();
		}
	}

	@Override
	public CharSequence getPageTitle(int position) {
		switch (position) {
			case 0:
				return "USERS";
			case 1:
				return "SERVERS";
			case 2:
				return "DEPARTMENTS";
			case 3:
				return "TEAMS";
			default:
				return "USERS";
		}
	}
}
