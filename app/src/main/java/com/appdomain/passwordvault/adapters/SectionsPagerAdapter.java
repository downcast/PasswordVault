package com.appdomain.passwordvault.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.appdomain.passwordvault.fragments.DepartmentFragment;
import com.appdomain.passwordvault.fragments.ServerFragment;
import com.appdomain.passwordvault.fragments.TeamFragment;
import com.appdomain.passwordvault.fragments.UserFragment;

/**
 * Created by Marcus on 3/7/2016.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

	public SectionsPagerAdapter(FragmentManager fm) {
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
				return new UserFragment();
			case 1:
				return new ServerFragment();
			case 2:
				return new DepartmentFragment();
			case 3:
				return new TeamFragment();
			default:
				return new UserFragment();
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
