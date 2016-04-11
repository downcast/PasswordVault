package com.appdomain.passwordvault.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.appdomain.passwordvault.Fragments.FragmentDepartment;
import com.appdomain.passwordvault.Fragments.FragmentServer;
import com.appdomain.passwordvault.Fragments.FragmentServerAdd;
import com.appdomain.passwordvault.Fragments.FragmentTeam;
import com.appdomain.passwordvault.Fragments.FragmentUser;
import com.appdomain.passwordvault.LocalModel.ApplicationData;
import com.appdomain.passwordvault.R;

/** Since all of the fragments share a common view with a title and listview, they will all share an adapter to that listview
 * Created by Marcus on 4/3/2016.
 */
public class AdapterListView extends BaseAdapter{

	private Context mContext;
	private Fragment mfrag;

	public AdapterListView(Context context, Fragment visibleFrag){
		mContext = context;
		mfrag = visibleFrag;
	}

	@Override
	public int getCount() {

		if (mfrag instanceof FragmentUser){
			return ApplicationData.getInstance().getAllUsers().size();
		} else if (mfrag instanceof FragmentServer){
			return ApplicationData.getInstance().getAllServers().size();
		} else if (mfrag instanceof FragmentServerAdd){
			return FragmentServerAdd.addedApps.size();
		} else if (mfrag instanceof FragmentDepartment){
			return ApplicationData.getInstance().getAllDepartments().size();
		} else if (mfrag instanceof FragmentTeam){
			return ApplicationData.getInstance().getAllTeams().size();
		}
		return 0;
	}

	@Override
	public Object getItem(int i) {

		if (mfrag instanceof FragmentUser){
			return ApplicationData.getInstance().getUser(i);
		} else if (mfrag instanceof FragmentServer){
			return ApplicationData.getInstance().getServer(i);
		} else if (mfrag instanceof FragmentServerAdd){
			return ApplicationData.getInstance().getApp(i);
		} else if (mfrag instanceof FragmentDepartment){
			return ApplicationData.getInstance().getDepartment(i);
		} else if (mfrag instanceof FragmentTeam){
			return ApplicationData.getInstance().getTeam(i);
		}
		return null;
	}

	@Override
	public long getItemId(int i) {
		return 0;
	}

	@Override
	public View getView(int i, View view, ViewGroup viewGroup) {
		View row = ((LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
				.inflate(R.layout.single_row_two_items, viewGroup, false);

		TextView largeItem = (TextView) row.findViewById(R.id.single_row_two_item_large);
		TextView smallItem = (TextView) row.findViewById(R.id.single_row_two_item_small);

		if (mfrag instanceof FragmentUser){
			largeItem.setText(ApplicationData.getInstance().getUser(i).getNameFirst());
			smallItem.setText(ApplicationData.getInstance().getUser(i).getNameLast());

		} else if (mfrag instanceof FragmentServer){
			largeItem.setText(ApplicationData.getInstance().getServer(i).getName());
			smallItem.setText(ApplicationData.getInstance().getServer(i).getDepartment());

		} else if (mfrag instanceof FragmentServerAdd){
			largeItem.setText(FragmentServerAdd.addedApps.get(i).getName());
			smallItem.setText("");

		} else if (mfrag instanceof FragmentDepartment){
			largeItem.setText(ApplicationData.getInstance().getDepartment(i).getName());
			//smallItem.setText(ApplicationData.getInstance().getApp(i).getServer().getName());

		} else if (mfrag instanceof FragmentTeam){
			largeItem.setText(ApplicationData.getInstance().getTeam(i).getName());
			//smallItem.setText(ApplicationData.getInstance().getApp(i).getServer().getName());
		}

		return row;
	}
}
