package com.example.hosungclass;

import java.util.Random;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class RaceView extends View {	
	private Random	mRandom;
	private Paint	mPaint;
	private Context mContext;
	private int		mCount;
	private int 	mHeight;
	private int 	mWidth;
	private boolean mWorking;
	private int[] 	mDistance;
	private int[]	mMM = {
		R.drawable.mm1,
		R.drawable.mm2,
		R.drawable.mm3,
		R.drawable.mm4,
		R.drawable.mm5,
		R.drawable.mm6			
	};	
	
	private Handler 	mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (mWorking) {
				mCount++;
				for(int i=0;i<3;i++) {
					mDistance[i] = mDistance[i] + mRandom.nextInt(10);
					if(mDistance[i] > mWidth/5*4) {
						mWorking = false;
						Toast.makeText(mContext, (i+1)+"번째 마우스가 우승했습니다.", Toast.LENGTH_LONG).show();
					}
				}
				invalidate();
			}
			mHandler.sendMessageDelayed(mHandler.obtainMessage(), 200);			
			super.handleMessage(msg);
		}
		
	};

	public RaceView(Context context, AttributeSet attrs) {
		super(context, attrs);		
		init(context);
	}
	
	public void init(Context context) {
		mContext = context;
		mRandom=new Random();
		mCount = 0;
		mPaint = new Paint();
		mPaint.setColor(Color.rgb(255, 0, 0));
		mPaint.setStyle(Paint.Style.FILL);
		mPaint.setStrokeWidth(1);
		mPaint.setTextSize(30);
		mHandler.sendMessageDelayed(mHandler.obtainMessage(), 200);
		mDistance = new int[3];
		mDistance[0] = 0;
		mDistance[1] = 0;
		mDistance[2] = 0;	
		DisplayMetrics metrics = new DisplayMetrics();
		WindowManager wm=(WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
		wm.getDefaultDisplay().getMetrics(metrics);
		mHeight = metrics.heightPixels;
		mWidth = metrics.widthPixels;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		//canvas.drawRect(new Rect(0,0,10,10), mPaint);
		//canvas.drawText(""+mCount, 80, 80, mPaint);
		for (int i=0; i<3; i++) {
			int X, Y;
			X = mDistance[i];
			Y = 80*i+5;
			Drawable drawable = mContext.getResources().getDrawable(mMM[(mCount+i)%6]);
			drawable.setBounds(X, Y, X+drawable.getMinimumWidth(), Y+drawable.getMinimumHeight());
			drawable.draw(canvas);
		}
		
		canvas.drawLine(mWidth/5*4, 0, mWidth/5*4, mHeight, mPaint);
		super.onDraw(canvas);
	}	    
	
	public void setWorking(boolean working) {
		mWorking = working;
	}
	
	public boolean getWorking() {
		return mWorking;
	}
}
