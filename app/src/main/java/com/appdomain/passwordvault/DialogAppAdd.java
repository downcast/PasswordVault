package com.appdomain.passwordvault;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.appdomain.passwordvault.DBModel.Credential;
import com.appdomain.passwordvault.LocalModel.App;
import com.appdomain.passwordvault.LocalModel.ApplicationData;

/**
 * Created by Marcus on 4/11/2016.
 */
public class DialogAppAdd extends DialogFragment implements View.OnClickListener{

	private EditText mName;
	private EditText mPass;
	private EditText mUser;

	private OnDialogDismissListener mListener;

	public DialogAppAdd() { /* Empty constructor required for DialogFragment */ }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_app_add, container);

		mName = (EditText) root.findViewById(R.id.fragment_app_add_name_edit);
		mPass = (EditText) root.findViewById(R.id.fragment_app_add_password_edit);
		mUser = (EditText) root.findViewById(R.id.fragment_app_add_username_edit);
		//mServer = (Spinner) root.findViewById(R.id.fragment_app_add_server_spinner);

		Button btn = (Button) root.findViewById(R.id.fragment_app_add_btn);
		btn.setOnClickListener(this);

		getDialog().setTitle("Add App to Server");
		return root;
	}

	public void setOnDismissListener(OnDialogDismissListener listener) {
		mListener = listener;
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.fragment_app_add_btn:

				String name = mName.getText().toString();
				String pass = mPass.getText().toString();
				String user = mUser.getText().toString();

				String id = MainActivity.addDBData("Credential", new Credential("No", pass, user));
				String appID = MainActivity.addDBData("App", new com.appdomain.passwordvault.DBModel.App(name, id, "TBD"));

				App app = new App(id, appID, name, "TBD");
				ApplicationData.getInstance().addApp(app);
				mListener.onDismiss(app);
				dismiss();
				break;
		}
	}

}
