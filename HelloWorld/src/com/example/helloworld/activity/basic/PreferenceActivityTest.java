package com.example.helloworld.activity.basic;

import java.util.List;
import com.example.helloworld.R;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.widget.Button;
import android.widget.Toast;

/**
 * ѧϰ��ôӦ��PreferenceActivityʵ�����ò����Ľ���
 * ͨ�������Ӧ��ѧ��:
 * 1��PreferenceActivity��ôʵ��
 * 2����Android3.0��ʼ��Android���齫PreferenceActivity��PreferenceFragment���ʹ�á�
 * ����PreferenceActivityֻ�������ѡ�����á��б��Ĳ����ļ���PreferenceFragment�Ÿ������ѡ�����õĲ����ļ���
 * @author bingbingjian
 * @creation 2015��8��23��
 */
public class PreferenceActivityTest extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// �÷�������Ϊ�ý�������һ�����ⰴť
		if (hasHeaders()) {
			Button button = new Button(this);
			button.setText("���ò���");
			// ���ð�ť��ӵ��ý�����
			setListFooter(button);
		}
	}

	// ��д�÷�����������ؽ��沼���ļ�
	@Override
	public void onBuildHeaders(List<Header> target) {
		// ����ѡ�������б�Ĳ����ļ�
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
			// ��ȡ�����Fragment�Ĳ���
			String website = getArguments().getString("website");
			Toast.makeText(getActivity(), "��վ�����ǣ�"+website, Toast.LENGTH_LONG).show();
		}
	}
}
