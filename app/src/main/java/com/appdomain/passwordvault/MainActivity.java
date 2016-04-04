package com.appdomain.passwordvault;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.appdomain.passwordvault.Adapters.AdapterFragment;
import com.appdomain.passwordvault.Fragments.FragmentAdminPanel;

public class MainActivity extends AppCompatActivity {

	public static FragmentManager sFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

	    sFragmentManager = getSupportFragmentManager();

        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_toolbar);
        setSupportActionBar(toolbar);

	    TabLayout tabLayout = (TabLayout) findViewById(R.id.activity_tabs);
	    tabLayout.setVisibility(View.GONE);

	    if (savedInstanceState == null){
		    tabLayout.setVisibility(View.VISIBLE);
		    nextFragment(null, new FragmentAdminPanel(), null, false, false);
	    }

    }

	/** Commits replacement transactions with fragments.
	 *
	 * @param fromFrag Fragment that should be replaced. Pass null transition should be sliding left to right instead of up and down
	 * @param toFrag Instance of the fragment that should be called next.
	 * @param bun Data that should be set to the fragment or null if none.
	 * @param add True if fragment should be added to the backstack.
	 * @param clear True if system should clear backstack then add fragment
	 */
	public static void nextFragment(Fragment fromFrag, Fragment toFrag, Bundle bun, boolean add, boolean clear){

		if (bun != null){
			toFrag.setArguments(bun);
		}
		if (clear){
			// Clears the back stack, leaving the first fragment added to be displayed
			//mContainer.removeAllViews();
			sFragmentManager.popBackStack(sFragmentManager.getBackStackEntryAt(0).getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
		}
		if (add){
			sFragmentManager.beginTransaction()
					.replace(R.id.activity_container, toFrag)
					.addToBackStack(null)
					.commit();
		} else {
			sFragmentManager.beginTransaction()
					.replace(R.id.activity_container, toFrag)
					.commit();
		}
	}

	@Override
	public void onBackPressed() {
		if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
			getSupportFragmentManager().popBackStack();
		} else {
			super.onBackPressed();
		}
	}
}
