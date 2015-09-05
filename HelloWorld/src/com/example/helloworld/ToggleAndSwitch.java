package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

public class ToggleAndSwitch extends Activity {

	private ToggleButton toggle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.toggle_and_switch);
		
		toggle = (ToggleButton) findViewById(R.id.toggle);
		final LinearLayout layout = (LinearLayout) findViewById(R.id.test);
		toggle.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					layout.setOrientation(0);
				} else {
					layout.setOrientation(1);
				}
			}
		});
	}
}
