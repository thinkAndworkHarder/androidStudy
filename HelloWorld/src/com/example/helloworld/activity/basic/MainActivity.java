package com.example.helloworld.activity.basic;

import com.example.helloworld.ExpandableListViewTest;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
/**
 * 入口Activity
 * 学习Activity基本知识，包括：编写Activity、配置Activity
 * 通过这个Activity应该了解：
 * 1、继承LauncherActivity时通常应该重写Intent intentForPosition(int position)方法
 * 2、ArrayAdapter的用法
 * @author bingbingjian 2015年8月23日
 *
 */
public class MainActivity extends LauncherActivity {

	// 定义两个Activity的名称
	String[] names = {"设置程序参数", "查看星际兵种"};
	// 定义两个Activity对应的实现类
	Class<?>[] clazzs = {PreferenceActivityTest.class, ExpandableListViewTest.class};
	
	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
				android.R.layout.simple_list_item_1, names);
		// 设置该窗口显示的列表所需的Adapter
		setListAdapter(adapter);
	}

	// 根据列表项返回指定Activity对应的Intent
	@Override
	protected Intent intentForPosition(int position) {
		return new Intent(MainActivity.this, clazzs[position]);
	}

}
