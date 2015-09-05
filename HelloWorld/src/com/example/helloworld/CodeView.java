package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CodeView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		LinearLayout layout = new LinearLayout(this);
		super.setContentView(layout);
		
		layout.setOrientation(LinearLayout.VERTICAL);
		
		final TextView textView = new TextView(this);
		Button btn = new Button(this);
		btn.setText(R.string.button_name);
		btn.setLayoutParams(new ViewGroup.LayoutParams(
				ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		
		layout.addView(textView);
		layout.addView(btn);
		
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				textView.setText("点击之后文字改变了");
			}
		});
	}
}
