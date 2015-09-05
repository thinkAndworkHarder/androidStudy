package com.example.helloworld;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DrawView extends View {

	private float currentX = 40;
	private float currentY = 50;
	private Paint paint = new Paint();
	
	public DrawView(Context context) {
		super(context);
	}
	
	public DrawView(Context context, AttributeSet attributeSet) {
		super(context, attributeSet);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		//设置画笔的颜色
		paint.setColor(Color.RED);
		
		//绘制一个小球
		canvas.drawCircle(currentX, currentY, 15, paint);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		currentX = event.getX();
		currentY = event.getY();
		
		//通知当前组件重绘自己
//		invalidate();
		
		//返回true表示该方法已经处理该事件
		return true;
		
	}
	
	
}
