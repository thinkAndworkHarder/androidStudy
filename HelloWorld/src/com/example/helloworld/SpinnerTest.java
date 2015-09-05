package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SpinnerTest extends Activity {

	private Spinner spinner;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spinner_test);
		
		spinner = (Spinner) findViewById(R.id.spinner);
		String[] names = new String[]{"张三","李四","王五"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(SpinnerTest.this, android.R.layout.simple_list_item_multiple_choice, names);
		spinner.setAdapter(adapter);
	}
}
