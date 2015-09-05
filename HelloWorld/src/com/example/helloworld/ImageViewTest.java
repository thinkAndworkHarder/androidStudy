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

	//����һ������ͼƬ������
	private int[] images = new int[]{
			R.drawable.lijiang,
			R.drawable.qiao,
			R.drawable.shuangta,
			R.drawable.shui,
			R.drawable.xiangbi
	}; 
	//����Ĭ����ʾ��ͼƬ
	private int currentImg = 2;
	//����ͼƬ�ĳ�ʼ͸����
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
		
		//����鿴��һ��ͼƬ�ļ�����
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// ����imageView��ʾ��һ��ͼƬ
				image1.setImageResource(images[++currentImg % images.length]);
			}
		});
		
		// ����ı�ͼƬ͸���ȵķ���
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
		
		// Ϊ������ť���͸����
		plus.setOnClickListener(listener);
		minus.setOnClickListener(listener);
		
		image1.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				BitmapDrawable bitmapDrawable = (BitmapDrawable) image1.getDrawable();
				// ��ȡ��һ��ͼƬ���е�λͼ
				Bitmap bitmap = bitmapDrawable.getBitmap();
				// bitmapͼƬʵ�ʴ�С���һ��ImageView�����ű���
				double scale = bitmap.getWidth() / image1.getWidth();
				// ��ȡ��Ҫ��ʾ��ͼƬ�Ŀ�ʼ��
				int x = (int) (event.getX() * scale);
				int y = (int) (event.getY() * scale);
				if (x + 120 > bitmap.getWidth()) {
					x = bitmap.getWidth() - 120;
				}
				if (y + 120 > bitmap.getHeight()) {
					y = bitmap.getHeight() - 120;
				}
				// ��ʾͼƬ��ָ������
				image2.setImageBitmap(Bitmap.createBitmap(bitmap, x, y, 120, 120));
				image2.setAlpha(alpha);
				return false;
			}
		});
	}
}
