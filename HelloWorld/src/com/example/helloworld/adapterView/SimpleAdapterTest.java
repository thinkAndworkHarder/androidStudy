package com.example.helloworld.adapterView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.example.helloworld.R;
import com.example.helloworld.R.drawable;
import com.example.helloworld.R.id;
import com.example.helloworld.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class SimpleAdapterTest extends Activity {

	private String[] names = new String[]{"��ͷ", "Ū��", "������", "���"};
	private String[] descs = new String[]{"�ɰ���С��", "�ó����ֵ�Ů��", "�ó���ѧ��Ů��", "��������ʫ��"};
	private int[] images = new int[]{
		R.drawable.tiger,
		R.drawable.nongyu,
		R.drawable.qingzhao,
		R.drawable.libai
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_adapter_test);
		
		List<Map<String, Object>> listItems = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < names.length; i++) {
			Map<String, Object> listItem = new HashMap<String, Object>();
			listItem.put("header", images[i]);
			listItem.put("personName", names[i]);
			listItem.put("desc", descs[i]);
			listItems.add(listItem);
		}
		
		// ����һ��SimpleAdapter
		SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.simple_item, new String[]{"personName", "header", "desc"}, new int[]{R.id.name, R.id.header, R.id.desc});
		ListView list = (ListView) findViewById(R.id.mylist);
		list.setAdapter(adapter);
	}
}
