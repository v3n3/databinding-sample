package com.v3n3.databinding.sample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.v3n3.databinding.sample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements MainScene {
	ActivityMainBinding binding;
	MainViewModel viewModel;
	MainPresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		viewModel = new MainViewModel();
		presenter = new MainPresenter(this);
		binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
		binding.setModel(viewModel);
		binding.setPresenter(presenter);
		setSupportActionBar(binding.toolbar);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void notifySendingToServer() {
		binding.usernameLayout.setError("");
		binding.passwordLayout.setError("");
		Snackbar.make(binding.getRoot(), R.string.sending_request, Snackbar.LENGTH_SHORT).show();
	}

	@Override
	public void notifyErrorInData() {
		if (!presenter.isValidField(viewModel.getUsername())) {
			binding.usernameLayout.setError(getString(R.string.error_username));
		}
		if (!presenter.isValidField(viewModel.getPassword())) {
			binding.passwordLayout.setError(getString(R.string.error_password));
		}
	}
}
