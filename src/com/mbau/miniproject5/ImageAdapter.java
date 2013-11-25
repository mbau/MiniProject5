package com.mbau.miniproject5;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

public class ImageAdapter extends ParseQueryAdapter<Image> {

	public ImageAdapter(Context context) {
		super(context, new ParseQueryAdapter.QueryFactory<Image>() {
			public ParseQuery<Image> create() {
				ParseQuery query = new ParseQuery("Image");
				return query;
			}
		});
	}

	@Override
	public View getItemView(Image image, View v, ViewGroup parent) {

		if (v == null) {
			v = View.inflate(getContext(), R.layout.item_list, null);
		}

		super.getItemView(image, v, parent);

		ParseImageView picImage = (ParseImageView) v.findViewById(R.id.icon);
		ParseFile photoFile = image.getParseFile("photo");
		if (photoFile != null) {
			picImage.setParseFile(photoFile);
			picImage.loadInBackground(new GetDataCallback() {
				@Override
				public void done(byte[] data, ParseException e) {
				}
			});
		}

		TextView titleTextView = (TextView) v.findViewById(R.id.text1);
		titleTextView.setText(image.getTitle());
		TextView userTextView = (TextView) v.findViewById(R.id.user);
		userTextView.setText(image.getUser());
		return v;
	}

}
