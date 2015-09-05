package com.example.helloworld.activity.basic;

import java.util.List;
import com.example.helloworld.R;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.widget.Button;
import android.widget.Toast;

/**
 * 学习怎么应用PreferenceActivity实现设置参数的界面
 * 通过这个类应该学会:
 * 1、PreferenceActivity怎么实现
 * 2、从Android3.0开始，Android建议将PreferenceActivity与PreferenceFragment结合使用。
 * 其中PreferenceActivity只负责加载选项设置“列表”的布局文件，PreferenceFragment才负责加载选项设置的布局文件。
 * @author bingbingjian
 * @creation 2015年8月23日
 */
public class PreferenceActivityTest extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 该方法用于为该界面设置一个标题按钮
		if (hasHeaders()) {
			Button button = new Button(this);
			button.setText("设置操作");
			// 将该按钮添加到该界面上
			setListFooter(button);
		}
	}

	// 重写该方法，负责加载界面布局文件
	@Override
	public void onBuildHeaders(List<Header> target) {
		// 加载选项设置列表的布局文件
		loadHeadersFromResource(R.xml.preference_headers, target);
	}
	
	public static class Prefs1Fragment extends PreferenceFragment {
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			addPreferencesFromResource(R.xml.preferences);
		}
	}
	public static class Prefs2Fragment extends PreferenceFragment {
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			addPreferencesFromResource(R.xml.display_prefs);
			// 获取传入该Fragment的参数
			String website = getArguments().getString("website");
			Toast.makeText(getActivity(), "网站域名是："+website, Toast.LENGTH_LONG).show();
		}
	}
}
