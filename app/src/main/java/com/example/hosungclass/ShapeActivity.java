
package com.example.hosungclass;

import java.util.Random;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

public class ShapeActivity extends Activity {	
	private int mWidth;
	private int mHeight;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) getBaseContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);		
		mWidth = metrics.widthPixels;
		mHeight = metrics.heightPixels;
		setContentView(new DrawingView(getBaseContext()));
	}
	class DrawingView extends View {
		private Paint mPaint;
		private Random mRandom;
		private Bitmap mBitmap;
	    private Canvas mCanvas;
		private Handler mHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				mPaint.setColor(Color.argb(255, mRandom.nextInt(255)+1, mRandom.nextInt(255)+1, mRandom.nextInt(255)+1));
				mCanvas.drawRect(new Rect(mRandom.nextInt(mWidth),mRandom.nextInt(mHeight),mRandom.nextInt(mWidth), mRandom.nextInt(mHeight)), mPaint);
				mHandler.sendMessageDelayed(mHandler.obtainMessage(), 10);
				invalidate();
				super.handleMessage(msg);
			}			
		};		
		public DrawingView(Context context) {
			super(context);
			mRandom=new Random();
			mPaint=new Paint();		
	        mBitmap = Bitmap.createBitmap(mWidth, mHeight, Bitmap.Config.ARGB_8888);
	        mCanvas = new Canvas(mBitmap);    
	        mHandler.sendMessageDelayed(mHandler.obtainMessage(), 10);			
		}		
		@Override
		protected void onDraw(Canvas canvas) {
			canvas.drawBitmap(mBitmap, 0, 0, null);
			super.onDraw(canvas);
		}
	}
}
