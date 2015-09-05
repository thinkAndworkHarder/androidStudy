package com.example.helloworld.activity.basic;

import com.example.helloworld.ExpandableListViewTest;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
/**
 * ���Activity
 * ѧϰActivity����֪ʶ����������дActivity������Activity
 * ͨ�����ActivityӦ���˽⣺
 * 1���̳�LauncherActivityʱͨ��Ӧ����дIntent intentForPosition(int position)����
 * 2��ArrayAdapter���÷�
 * @author bingbingjian 2015��8��23��
 *
 */
public class MainActivity extends LauncherActivity {

	// ��������Activity������
	String[] names = {"���ó������", "�鿴�Ǽʱ���"};
	// ��������Activity��Ӧ��ʵ����
	Class<?>[] clazzs = {PreferenceActivityTest.class, ExpandableListViewTest.class};
	
	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
				android.R.layout.simple_list_item_1, names);
		// ���øô�����ʾ���б������Adapter
		setListAdapter(adapter);
	}

	// �����б����ָ��Activity��Ӧ��Intent
	@Override
	protected Intent intentForPosition(int position) {
		return new Intent(MainActivity.this, clazzs[position]);
	}

}
