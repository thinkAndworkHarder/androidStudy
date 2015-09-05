package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class CheckButtonView extends Activity {

	TextView show;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.check_button_view);
		RadioGroup rg = (RadioGroup) findViewById(R.id.rg);
		show = (TextView) findViewById(R.id.show);
		rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				String tip = checkedId==R.id.male?"�����Ա�������":"�����Ա���Ů��";
				show.setText(tip);
			}
		});
	}
}
