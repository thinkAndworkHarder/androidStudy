package com.example.helloworld.activity.startclose;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.helloworld.R;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_startclose_second);
		
		Button previous = (Button) findViewById(R.id.previous);
		Button close = (Button) findViewById(R.id.close);
		previous.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SecondActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
		close.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SecondActivity.this, MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}
}
