package com.example.helloworld;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;

public class ImageViewTest extends Activity {

	//定义一个访问图片的数组
	private int[] images = new int[]{
			R.drawable.lijiang,
			R.drawable.qiao,
			R.drawable.shuangta,
			R.drawable.shui,
			R.drawable.xiangbi
	}; 
	//定义默认显示的图片
	private int currentImg = 2;
	//定义图片的初始透明度
	private int alpha = 255;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_view_test);
		
		final Button plus = (Button) findViewById(R.id.plus);
		final Button minus = (Button) findViewById(R.id.minus);
		final ImageView image1 = (ImageView) findViewById(R.id.image1);
		final ImageView image2 = (ImageView) findViewById(R.id.image2);
		Button next = (Button) findViewById(R.id.next);
		
		//定义查看下一张图片的监听器
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 控制imageView显示下一张图片
				image1.setImageResource(images[++currentImg % images.length]);
			}
		});
		
		// 定义改变图片透明度的方法
		OnClickListener listener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (v == plus) {
					alpha += 20;
				}
				if (v == minus) {
					alpha -= 20;
				}
				if (alpha >= 255) {
					alpha = 255;
				}
				if (alpha <= 0) {
					alpha = 0;
				}
				
				image1.setAlpha(alpha);
			}
		};
		
		// 为两个按钮添加透明度
		plus.setOnClickListener(listener);
		minus.setOnClickListener(listener);
		
		image1.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				BitmapDrawable bitmapDrawable = (BitmapDrawable) image1.getDrawable();
				// 获取第一个图片框中的位图
				Bitmap bitmap = bitmapDrawable.getBitmap();
				// bitmap图片实际大小与第一个ImageView的缩放比例
				double scale = bitmap.getWidth() / image1.getWidth();
				// 获取需要显示的图片的开始点
				int x = (int) (event.getX() * scale);
				int y = (int) (event.getY() * scale);
				if (x + 120 > bitmap.getWidth()) {
					x = bitmap.getWidth() - 120;
				}
				if (y + 120 > bitmap.getHeight()) {
					y = bitmap.getHeight() - 120;
				}
				// 显示图片的指定区域
				image2.setImageBitmap(Bitmap.createBitmap(bitmap, x, y, 120, 120));
				image2.setAlpha(alpha);
				return false;
			}
		});
	}
}
