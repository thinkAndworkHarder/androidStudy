package com.example.helloworld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.StackView;

public class StackViewTest extends Activity {

	private int[] imageIds = new int[]{
		R.drawable.bomb5, R.drawable.bomb6, R.drawable.bomb7,
		R.drawable.bomb8, R.drawable.bomb9, R.drawable.bomb10,
		R.drawable.bomb11, R.drawable.bomb12, R.drawable.bomb13,
		R.drawable.bomb14, R.drawable.bomb15, R.drawable.bomb16
	};
	
	private StackView stackView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stack_view_test);
		
		stackView = (StackView) findViewById(R.id.stackView);
		List<Map<String, Object>> listItems = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < imageIds.length; i++) {
			Map<String, Object> listItem = new HashMap<String, Object>();
			listItem.put("image", imageIds[i]);
			listItems.add(listItem);
		}
		SimpleAdapter simpleAdapter = new SimpleAdapter(StackViewTest.this, 
				listItems, R.layout.cell, new String[]{"image"}, 
				new int[]{R.id.image1});
		stackView.setAdapter(simpleAdapter);
	}
	
	public void prev(View view) {
		stackView.showPrevious();
	}
	
	public void next(View view) {
		stackView.showNext();
	}
}
