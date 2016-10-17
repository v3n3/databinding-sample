package com.v3n3.databinding.sample;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by julienFueled on 10/17/16.
 */

public class MainViewModel extends BaseObservable {
	private String username;
	private String password;

	@Bindable
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		notifyPropertyChanged(BR.password);
	}

	@Bindable
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
		notifyPropertyChanged(BR.username);
	}


}
