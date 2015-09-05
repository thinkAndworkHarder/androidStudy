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
		
		//���û��ʵ���ɫ
		paint.setColor(Color.RED);
		
		//����һ��С��
		canvas.drawCircle(currentX, currentY, 15, paint);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		currentX = event.getX();
		currentY = event.getY();
		
		//֪ͨ��ǰ����ػ��Լ�
//		invalidate();
		
		//����true��ʾ�÷����Ѿ�������¼�
		return true;
		
	}
	
	
}
