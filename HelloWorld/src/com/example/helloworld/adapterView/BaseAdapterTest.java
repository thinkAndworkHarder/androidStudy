package com.example.helloworld.adapterView;

import com.example.helloworld.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class BaseAdapterTest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_adapter_test);
		
		ListView mylist = (ListView) findViewById(R.id.mylist);
		BaseAdapter adapter = new BaseAdapter() {
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// ����һ��LinearLayout��������������������
				LinearLayout layout = new LinearLayout(BaseAdapterTest.this);
				layout.setOrientation(0);
				ImageView imageView = new ImageView(BaseAdapterTest.this);
				imageView.setImageResource(R.drawable.ic_launcher);
				TextView textView = new TextView(BaseAdapterTest.this);
				textView.setText("��"+ (position + 1 ) +"���б���");
				textView.setTextSize(20);
				textView.setTextColor(Color.RED);
				layout.addView(imageView);
				layout.addView(textView);
				
				// ����LinearLayoutʵ��
				return layout;
			}
			
			@Override
			public long getItemId(int position) {
				return position;
			}
			
			@Override
			public Object getItem(int position) {
				return null;
			}
			
			@Override
			public int getCount() {
				return 40;
			}
		};
		
		mylist.setAdapter(adapter);
	}
}
