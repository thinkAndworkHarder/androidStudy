package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class AutoCompleteTextViewTest extends Activity {

	private String[] books = new String[]{
			"���Java����",
			"���Android����",
			"���XML����",
			"���Ajax����"
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_auto_complete_text_view_test);
		
		AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.auto);
		MultiAutoCompleteTextView mactv = (MultiAutoCompleteTextView) findViewById(R.id.mauto);
		
		ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, books);
		actv.setAdapter(aa);
		mactv.setAdapter(aa);
		
		// ΪMultiAutoCompleteTextView���÷ָ���
		mactv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
	}
}
