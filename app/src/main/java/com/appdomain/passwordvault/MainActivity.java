package com.appdomain.passwordvault;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.appdomain.passwordvault.Fragments.FragmentLogin;
import com.appdomain.passwordvault.Listeners.onDataReceived;
import com.appdomain.passwordvault.LocalModel.ApplicationData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity implements ValueEventListener{

	public static FragmentManager sFragmentManager;
	public static Firebase sFirebaseRef;
	private onDataReceived mUserListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

	    Firebase.setAndroidContext(this);
	    sFirebaseRef = new Firebase("https://swepasswordvault.firebaseio.com/User");
	    sFirebaseRef.addValueEventListener(this);

	    sFragmentManager = getSupportFragmentManager();

        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_toolbar);
        setSupportActionBar(toolbar);

	    TabLayout tabLayout = (TabLayout) findViewById(R.id.activity_tabs);
	    tabLayout.setVisibility(View.GONE);

	    if (savedInstanceState == null) {
		    nextFragment(null, new FragmentLogin(), null, false, false);
	    }

    }

	//region statics
	/**
	 * Commits replacement transactions with fragments.
	 *
	 * @param fromFrag Fragment that should be replaced. Pass null transition should be sliding left to right instead of up and down
	 * @param toFrag   Instance of the fragment that should be called next.
	 * @param bun      Data that should be set to the fragment or null if none.
	 * @param add      True if fragment should be added to the backstack.
	 * @param clear    True if system should clear backstack then add fragment
	 */
	public static void nextFragment(Fragment fromFrag, Fragment toFrag, Bundle bun, boolean add, boolean clear) {

		if (bun != null) {
			toFrag.setArguments(bun);
		}
		if (clear) {
			// Clears the back stack, leaving the first fragment added to be displayed
			//mContainer.removeAllViews();
			sFragmentManager.popBackStack(sFragmentManager.getBackStackEntryAt(0).getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
		}
		if (add) {
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

	/**
	 * Adds a specified POJO (Plain Old Java Object) to the Firebase at the given path
	 * @param relativePath the specific node you want data added to. ex (User)
	 * @param obj the Java object that follows the POJO format
	 * @return Key that can be used to later update or delete the added obj later
	 */
	public static String addDBData(String relativePath, Object obj){
		// Change the node we point to then insert a new node with a Firebase generated key
		Firebase ref = sFirebaseRef.child(relativePath).push();
		// Set the data to the new node
		ref.setValue(obj);

		// return key of data so it can be located later
		return ref.getKey();
	}

	/**
	 * Updates an existing obj
	 * @param relativePath the path of the exising obj ex (User/[id])
	 * @param obj Data that will replace the existing
	 */
	public static void updateData(String relativePath, Object obj){
		sFirebaseRef.child(relativePath).setValue(obj);
	}
	//endregion

	//region event listeners
	@Override
	public void onDataChange(DataSnapshot dataSnapshot) {
		ApplicationData.getInstance().loadDBData(dataSnapshot);
	}

	@Override
	public void onCancelled(FirebaseError firebaseError) {

	}
	//endregion

	//region Setters
	public void setUserListener(onDataReceived listener) { mUserListener = listener; }
	//endregion

	@Override
	public void onBackPressed() {
		if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
			getSupportFragmentManager().popBackStack();
		} else {
			super.onBackPressed();
		}
	}
}
