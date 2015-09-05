package com.example.helloworld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

public class GridViewTest extends Activity {

	private ImageView image;
	
	private int[] imageIds = new int[]{
		R.drawable.bomb5, R.drawable.bomb6, R.drawable.bomb7,
		R.drawable.bomb8, R.drawable.bomb9, R.drawable.bomb10,
		R.drawable.bomb11, R.drawable.bomb12, R.drawable.bomb13,
		R.drawable.bomb14, R.drawable.bomb15, R.drawable.bomb16
	}; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid_view_test);
		
		// 创建一个List对象，List对象的元素是Map
		List<Map<String, Object>> listItems = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < imageIds.length; i++) {
			Map<String, Object> listItem = new HashMap<String, Object>();
			listItem.put("image", imageIds[i]);
			listItems.add(listItem);
		}
		
		// 获取显示图片的ImageView
		image = (ImageView) findViewById(R.id.imageView);
		// 创建一个SimpleAdapter
		SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.cell, new String[]{"image"}, new int[]{R.id.image1});
		GridView gridView = (GridView) findViewById(R.id.grid01);
		gridView.setAdapter(adapter);
		gridView.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// 显示当前被选中的图片
				image.setImageResource(imageIds[position]);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
		
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// 显示当前被单击的图片
				image.setImageResource(imageIds[position]);
			}
		});
	}
}
