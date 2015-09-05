package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;

public class ChronometerView extends Activity {

	private Chronometer chronometer;
	private Button start;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chronometer_view);
		
		chronometer = (Chronometer) findViewById(R.id.chronometer);
		start = (Button) findViewById(R.id.startChronometer);
		
		start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				chronometer.setBase(SystemClock.elapsedRealtime());
				chronometer.start();
				start.setEnabled(false);
			}
		});
		
		chronometer.setOnChronometerTickListener(new OnChronometerTickListener() {
			
			@Override
			public void onChronometerTick(Chronometer ch) {
				if (SystemClock.elapsedRealtime() - ch.getBase() > 20 * 1000) {
					ch.stop();
					start.setEnabled(true);
				}
				
			}
		});
	}
}
