package com.example.helloworld.adapterView;

import com.example.helloworld.R;
import com.example.helloworld.R.id;
import com.example.helloworld.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ArrayAdapterTest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_array_adapter_test);
		ListView list1 = (ListView) findViewById(R.id.list1);
		ListView list2 = (ListView) findViewById(R.id.list2);
		
		String[] arr1 = new String[]{"ËïÎò¿Õ", "Öí°Ë½ä", "Å£Ä§Íõ"};
		String[] arr2 = new String[]{"Java", "Ajax", "Android", "Xml"};
		
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.array_item, arr1);
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.checked_item, arr2);
		
		list1.setAdapter(adapter1);
		list2.setAdapter(adapter2);
	}
}
