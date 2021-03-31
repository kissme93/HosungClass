package com.example.hosungclass;

import java.util.Random;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class CardGameActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new DrawingView(getBaseContext()));
	}

	class Card {
		int mNumber;
		boolean mOpend;
		public Card(int number) {
			this();
			mNumber = number;			
		}
		
		public Card() {
			mOpend=false;
			mNumber=0;
		}
	}	
	
	class DrawingView extends View {
		private Paint mPaint1;
		private Context mContext;
		private Card[] mCard;
		private int mOpenCount;
		private boolean mFliping;
		private int mCardIndex;
		private int mCardIndex2;
		private Random mRandom;
	    private MediaPlayer 	mMediaPlayer = null;

		private int [] mPicArray = {R.drawable.pic01,
				R.drawable.pic02,
				R.drawable.pic03,
				R.drawable.pic04,
				R.drawable.pic05,
				R.drawable.pic06,
				R.drawable.pic07,
				R.drawable.pic08
		};
				
		public DrawingView(Context context) {
			super(context);
			mContext = context;
			mPaint1 = new Paint();
			mPaint1.setColor(Color.argb(255, 0, 255, 0));		
			mCard = new Card[16];
			
			for(int i=0; i < mCard.length; i++) {
				mCard[i]=new Card(i%8);				
			}
			mRandom=new Random();
			for(int i=0;i<100;i++) {
				int random1 =mRandom.nextInt(15);
				int random2 =mRandom.nextInt(15);
				Card temp;
				temp = mCard[random1];
				mCard[random1]=mCard[random2];
				mCard[random2]=temp;
			}
			mOpenCount=0;
			mCardIndex=-1;
			mFliping=false;
		}
						
		@Override
		protected void onDraw(Canvas canvas) {
			Drawable drawable = mContext.getResources().getDrawable(R.drawable.pic17);
			for (int i=0; i<4; i++) {
				for (int j=0; j<4; j++) {
					if (mCard[i*4+j].mOpend == true) {
						Drawable drawable2=mContext.getResources().getDrawable(mPicArray[mCard[i*4+j].mNumber]);
						drawable2.setBounds(10+j*100, 10+i*100, 100+j*100,100+i*100 );
						drawable2.draw(canvas);						
					} else {
						drawable.setBounds(10+j*100, 10+i*100, 100+j*100,100+i*100 );
						drawable.draw(canvas);
					}
				}				
			}
			super.onDraw(canvas);
		}

		@Override
		public boolean onTouchEvent(MotionEvent event) {
			if (event.getAction()==MotionEvent.ACTION_DOWN) {
				if(mFliping) {
					return false;
				}
				float x=event.getX();
				float y=event.getY();
				int X= (int)(x/110);			
				int Y= (int)(y/110);
				Log.d("KimHosung", "X="+X+", Y="+Y);
				int index=Y*4+X;
				mCard[index].mOpend=!mCard[index].mOpend;
				if(mCard[index].mOpend==true){
					mOpenCount ++;
				} else {
					mOpenCount --;
				}				
				if(mOpenCount%2 ==1) {
					//one card
					mCardIndex=index;
				}else{
					//correct
					if (mCard[mCardIndex].mNumber==mCard[index].mNumber) {
						Toast.makeText(mContext, "Corect", Toast.LENGTH_SHORT).show();
				        if (mMediaPlayer != null) {
				        	mMediaPlayer.release();
				        	mMediaPlayer = null;
				        }			
				        try {
				        	mMediaPlayer = MediaPlayer.create(mContext, R.raw.correct);
				        	mMediaPlayer.start();
				        } catch (Exception e) {
				            Log.e("hosung", "error: " + e.getMessage(), e);
				        }	
						
					}else{
						Toast.makeText(mContext, "not correct.", Toast.LENGTH_SHORT).show();
						mCardIndex2=index;
						mFliping=true;
						(new Handler()).postDelayed(new Runnable() {
							public void run() {
							mCard[mCardIndex].mOpend=false;
							mCard[mCardIndex2].mOpend=false; 			
							invalidate();
							mFliping=false;
							}
						}, 2000);
				        if (mMediaPlayer != null) {
				        	mMediaPlayer.release();
				        	mMediaPlayer = null;
				        }			
				        try {
				        	mMediaPlayer = MediaPlayer.create(mContext, R.raw.incorrect);
				        	mMediaPlayer.start();
				        } catch (Exception e) {
				            Log.e("hosung", "error: " + e.getMessage(), e);
				        }	

					}
				}
 				invalidate();
			}
			return super.onTouchEvent(event);
		}		
	}
}