package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class AdapterViewFlipperTest extends Activity {

	private int[] imageIds = new int[]{
			R.drawable.shuangzi, R.drawable.shuangyu, R.drawable.chunv,
			R.drawable.tiancheng, R.drawable.tianxie, R.drawable.sheshou,
			R.drawable.juxie, R.drawable.shuiping, R.drawable.shizi,
			R.drawable.baiyang, R.drawable.jinniu, R.drawable.mojie
	};
	
	private AdapterViewFlipper flipper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adapter_view_flipper_test);
		
		flipper = (AdapterViewFlipper) findViewById(R.id.flipper);
		BaseAdapter adapter = new BaseAdapter() {
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				ImageView imageView = new ImageView(AdapterViewFlipperTest.this);
				imageView.setImageResource(imageIds[position]);
				imageView.setScaleType(ScaleType.FIT_XY);
				imageView.setLayoutParams(new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
				return imageView;
			}
			
			@Override
			public long getItemId(int position) {
				return position;
			}
			
			@Override
			public Object getItem(int position) {
				return imageIds[position];
			}
			
			@Override
			public int getCount() {
				return imageIds.length;
			}
		};
		
		flipper.setAdapter(adapter);
	}
	
	public void prev(View sources) {
		// 显示上一个组件
		flipper.showPrevious();
		// 停止自动播放
		flipper.stopFlipping();
	}
	
	public void next(View sources) {
		flipper.showNext();
		flipper.stopFlipping();
	}
	
	public void auto(View sources) {
		flipper.startFlipping();
	}
}
