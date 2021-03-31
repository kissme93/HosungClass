package com.example.hosungclass;

import java.util.Random;

import com.example.hosungclass.R;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

public class MoleView extends View {
	private Paint 		mPaint;
	private Context 	mContext;
	private Random 		mRandom;
	private int			mWidth, mHeight;
	private int 		mPieceWidth, mPieceHeight;
	private int 		mMoleIndex;
	private MediaPlayer	mMediaPlayer = null;
	private Handler 	mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			mMoleIndex = mRandom.nextInt(12);
			invalidate();
			mHandler.sendMessageDelayed(mHandler.obtainMessage(), 700);			
			super.handleMessage(msg);
		}
		
	};
	
	public MoleView(Context context) {
		super(context);
		mRandom= new Random();
		mContext = context;
		mPaint=new Paint();
		mPaint.setColor(Color.argb(255, 0, 0, 0));
		DisplayMetrics metrics = new DisplayMetrics();
		WindowManager wm=(WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
		wm.getDefaultDisplay().getMetrics(metrics);
		mWidth = metrics.widthPixels;
		mHeight = metrics.heightPixels;
		mPieceWidth=mWidth/3;
		mPieceHeight=mHeight/5;
		mMoleIndex = mRandom.nextInt(12);
		mHandler.sendMessageDelayed(mHandler.obtainMessage(), 700);
		
	}

	@Override
	protected void onDraw(Canvas canvas) {
		for (int i=0; i<4; i++) {
			for (int j=0; j<3; j++) {
				Drawable drawable;
				if (mMoleIndex == i*3+j) {
					drawable = mContext.getResources().getDrawable(R.drawable.mole);
				} else {
					drawable = mContext.getResources().getDrawable(R.drawable.drain);
				}
				drawable.setBounds(mPieceWidth*j, mPieceHeight*i, mPieceWidth*(j+1),mPieceHeight*(i+1));
				drawable.draw(canvas);			

			}
		}
		super.onDraw(canvas);
	}
	

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			float x = event.getX();
			float y = event.getY();
			int X = (int) (x / mPieceWidth);
			int Y = (int) (y / mPieceWidth);
			if (Y * 3 + X == mMoleIndex) {
				if (mMediaPlayer != null) {
					mMediaPlayer.release();
					mMediaPlayer=null;
				}
				try{
					mMediaPlayer=MediaPlayer.create(mContext, R.raw.p1);
					mMediaPlayer.start();
				} catch (Exception e) {
					
				}
				
			
				//mMoleIndex = mRandom.nextInt(12);
				//invalidate();

			} else {
				Log.d("hosung", "x=" + X + "y=" + Y);
				if (mMediaPlayer != null) {
					mMediaPlayer.release();
					mMediaPlayer=null;
				}
				try{
					mMediaPlayer=MediaPlayer.create(mContext, R.raw.in);
					mMediaPlayer.start();
				} catch (Exception e) {
					
				} 

			}
		}

		return super.onTouchEvent(event);
	}

}
