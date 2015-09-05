package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;

public class CustomView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom_view);
	}

}
