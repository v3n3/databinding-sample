package com.v3n3.databinding.sample;

/**
 * Created by julienFueled on 10/17/16.
 */

public class MainPresenter {
	private final MainScene scene;

	public MainPresenter(MainScene scene) {
		this.scene = scene;
	}

	public void makeServerCall(MainViewModel model) {
		if (isValid(model)) {
			scene.notifySendingToServer();
			//make the server call
		} else {
			scene.notifyErrorInData();
		}
	}

	private boolean isValid(MainViewModel model) {
		return isValidField(model.getUsername()) && isValidField(model.getPassword());
	}

	public boolean isValidField(String username) {
		return username != null && !username.isEmpty();
	}
}
