package com.mbau.miniproject5;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.ParseQueryAdapter;
import com.parse.ParseUser;

public class ImageListActivity extends ListActivity {

	private ImageAdapter imageAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getListView().setClickable(true);

		// Subclass of ParseQueryAdapter
		imageAdapter = new ImageAdapter(this);
		setListAdapter(imageAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_image_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

		case R.id.action_refresh: {
			updateImageList();
			break;
		}

		case R.id.action_logout: {
			logOut();
			break;
		}

		case R.id.action_new: {
			newImage();
			break;
		}
		}
		return super.onOptionsItemSelected(item);
	}

	private void updateImageList() {
		imageAdapter.loadObjects();
		setListAdapter(imageAdapter);
	}

	private void logOut() {
		ParseUser.logOut();
		finish();
	}

	private void newImage() {
		Intent i = new Intent(this, NewImageActivity.class);
		startActivityForResult(i, 0);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == Activity.RESULT_OK) {
			updateImageList();
		}
	}
	
	

}
