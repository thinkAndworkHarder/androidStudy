package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MixView extends Activity {

	int[] images = new int[]{R.drawable.ajax, R.drawable.classic,
			R.drawable.ee, R.drawable.java, R.drawable.xml};
	
	int currentIndex = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		LinearLayout layout = (LinearLayout) findViewById(R.id.root);
		final ImageView image = new ImageView(this);
		layout.addView(image);
		
		image.setImageResource(images[0]);
		image.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				currentIndex++;
				image.setImageResource(images[(currentIndex)%images.length]);
			}
		});
	}

}
