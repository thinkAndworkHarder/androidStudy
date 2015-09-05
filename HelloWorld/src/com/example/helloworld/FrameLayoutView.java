package com.example.helloworld;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class FrameLayoutView extends Activity {

	private int currentColor = 0;
	private final int[] colors = new int[]{
			R.color.color1,
			R.color.color2,
			R.color.color3,
			R.color.color4,
			R.color.color5,
			R.color.color6
	}; 
	private final int[] names = new int[]{
			R.id.textview1,
			R.id.textview2,
			R.id.textview3,
			R.id.textview4,
			R.id.textview5,
			R.id.textview6
	};
	private TextView[] views = new TextView[names.length];
	Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// ������Ϣ���Ա�������
			if (msg.what == 0x123) {
				for (int i = 0; i < names.length; i++) {
					views[i].setBackgroundResource(colors[(colors[i] + currentColor) % names.length]);
				}
				currentColor++;
			}
			super.handleMessage(msg);
		}
		
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.framelayout_view);
		for (int i = 0; i < names.length; i++) {
			views[i] = (TextView) findViewById(names[i]);
		}
		
		//����һ���߳������Եظı�currentColor��ֵ
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				//����һ������Ϣ֪ͨϵͳ�ı�6��TextView����ı���ɫ
				handler.sendEmptyMessage(0x123);
			}
		}, 0, 200);
	}
	
}
