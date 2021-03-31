package com.example.hosungclass;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

public class PaintView extends View {
	private Paint 	mPaint1;
	private Point 	mOldPt;
	private Bitmap 	mBitmap;
	private Canvas 	mCanvas;

	public PaintView(Context context) {
		super(context);
		mPaint1=new Paint();
		mPaint1.setColor(Color.argb(255, 0, 0, 0));
		mPaint1.setStrokeWidth(5);
		mOldPt=new Point(0,0);
		DisplayMetrics metrics = new DisplayMetrics();
		WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
		wm.getDefaultDisplay().getMetrics(metrics);
		mBitmap = Bitmap.createBitmap(metrics.widthPixels, metrics.heightPixels, Bitmap.Config.ARGB_8888);
		mCanvas = new Canvas(mBitmap);
		setClickable(true);
	}


	@Override
	protected void onDraw(Canvas canvas) {
		//metrics.widthPixels, canvas.drawLine(mDownPt.x, mDownPt.y, mMovePt.x, mMovePt.y, mPaint1);
		canvas.drawBitmap(mBitmap, 0, 0,null);
		super.onDraw(canvas);
	}


	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction()==MotionEvent.ACTION_DOWN) {
			float x = event.getX();
			float y = event.getY();
			Log.d("Hosung", "Down X="+x+", Y="+y);
			mOldPt.set((int)x, (int)y);
		} else if(event.getAction()==MotionEvent.ACTION_MOVE) {
			float x = event.getX();
			float y = event.getY();
			
			mCanvas.drawLine(mOldPt.x, mOldPt.y, x, y, mPaint1);
			Log.d("Hosung", "Move Old X="+mOldPt.x+", Old Y="+mOldPt.y+" X="+(int)x+", Y="+(int)y);
			mOldPt.set((int)x, (int)y);
		}
		invalidate();
		return super.onTouchEvent(event);
	}

}
