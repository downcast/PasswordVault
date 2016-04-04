package com.appdomain.passwordvault.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.appdomain.passwordvault.Fragments.FragmentProfile;
import com.appdomain.passwordvault.Fragments.FragmentServer;
import com.appdomain.passwordvault.Fragments.FragmentUser;

/**
 * Created by Marcus on 4/4/2016.
 */
public class AdapterPanelAdminNon extends FragmentStatePagerAdapter {

	public AdapterPanelAdminNon(FragmentManager fm) {
		super(fm);
	}

	@Override
	public int getCount() {
		return 2;
	}

	@Override
	public Fragment getItem(int position) {

		switch (position) {
			case 0:
				return new FragmentProfile();
			case 1:
				return new FragmentServer();
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
			default:
				return "USERS";
		}
	}
}