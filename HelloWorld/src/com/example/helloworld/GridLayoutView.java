package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.GridLayout;

public class GridLayoutView extends Activity {

	// ����16����ť���ı�
	private final String[] chars = new String[] {
			"7", "8", "9", "��",
			"4", "5", "6", "��",
			"1", "2", "3", "-",
			".", "0", "=", "+"
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grid_layout_view);
		
		GridLayout gridLayout = (GridLayout) findViewById(R.id.gridlayoutView);
		for (int i = 0; i < chars.length; i++) {
			Button bn = new Button(this);
			bn.setText(chars[i]);
			bn.setTextSize(40);
			
			// ָ��������ڵ���
			GridLayout.Spec rowSpec = GridLayout.spec(i / 4 + 2);
			// ָ��������ڵ���
			GridLayout.Spec columnSpec = GridLayout.spec(i % 4);
			GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec, columnSpec);
			// ָ�������ռ��������
			params.setGravity(Gravity.FILL_HORIZONTAL);
			
			gridLayout.addView(bn, params);
		}
	}
}
