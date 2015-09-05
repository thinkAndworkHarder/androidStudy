package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.GridLayout;

public class GridLayoutView extends Activity {

	// 定义16个按钮的文本
	private final String[] chars = new String[] {
			"7", "8", "9", "÷",
			"4", "5", "6", "×",
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
			
			// 指定组件所在的行
			GridLayout.Spec rowSpec = GridLayout.spec(i / 4 + 2);
			// 指定组件所在的列
			GridLayout.Spec columnSpec = GridLayout.spec(i % 4);
			GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec, columnSpec);
			// 指定该组件占满父容器
			params.setGravity(Gravity.FILL_HORIZONTAL);
			
			gridLayout.addView(bn, params);
		}
	}
}
