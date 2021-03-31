package com.example.hosungclass;

import java.util.Random;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

public class PuzzleActivity extends Activity {
	private static final int PICTURE_TYPE_NUMBER=0;
	private static final int PICTURE_TYPE_SOOJI=1;

	int mWidth=450;
	int mHeight = 600;
	int mPieceWidth;
	int mPieceHeight;	
	private int mPictureType;
	private GameView mGameView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mPieceWidth=mWidth/3;
		mPieceHeight=mHeight/4;			
		SharedPreferences prefs = getPreferences(0); 
		mPictureType = prefs.getInt("picture_type", 0); 
		mGameView = new GameView(getBaseContext());
		setContentView(mGameView);		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.puzzle, menu);
		return true;
	}
				
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		 switch (item.getItemId()) {
	        case R.id.picture_type:				
	        	if(mPictureType == PICTURE_TYPE_NUMBER) {
	        		mPictureType = PICTURE_TYPE_SOOJI;
	        	} else if(mPictureType == PICTURE_TYPE_SOOJI) {
	        		mPictureType = PICTURE_TYPE_NUMBER;
	        	}
	        	mGameView.invalidate();
				SharedPreferences.Editor editor = getPreferences(0).edit();
		        editor.putInt("picture_type", mPictureType);
		        editor.commit();				
	        	break;
	    }
		return super.onOptionsItemSelected(item);
	}


	class Piece {
		Bitmap mPieceBitmap;
		int mNum;
		public Piece(int num, Bitmap bitmap) {
			mNum = num;
			mPieceBitmap=Bitmap.createBitmap(mWidth/3,mHeight/4,Bitmap.Config.ARGB_8888);
			Canvas canvas = new Canvas(mPieceBitmap);
			int X,Y;
			X = num % 3;
			Y = num / 3;
			if (num != 11) {
				canvas.drawBitmap(bitmap, new Rect(X*mPieceWidth, Y*mPieceHeight, (X+1)*mPieceWidth, (Y+1)*mPieceHeight),
						new Rect(0, 0, mPieceWidth, mPieceHeight), new Paint());
			}
		}
	}
	
	class GameView extends View {
		private Bitmap mBitmap;
		private Piece[] mPiece;
		private Paint mPaint1;
		private Paint mPaint2;
		private Random mRandom;
		public GameView(Context context) {
			super(context);
			mBitmap=Bitmap.createBitmap(mWidth, mHeight, Bitmap.Config.ARGB_8888);
			Canvas canvas=new Canvas(mBitmap);
			Drawable drawable=context.getResources().getDrawable(R.drawable.puzzle);
			drawable.setBounds(0,0,mWidth, mHeight);
			drawable.draw(canvas);
			
			mPaint1=new Paint();
			mPaint2=new Paint();
			mPaint1.setColor(Color.argb(255, 0, 0, 0));
			mPaint2.setColor(Color.argb(255, 0, 0, 0));
			mPaint1.setTextSize(40);			
			mPaint2.setStyle(Style.STROKE);
			mPaint2.setStrokeWidth(3);
			mPiece=new Piece[12];
			for(int i=0; i<mPiece.length; i++) {
				mPiece[i]=new Piece(i, mBitmap);
			}
			mRandom=new Random();
			for(int i=0; i<100; i++) {
				int random1=mRandom.nextInt(mPiece.length);
				int random2=mRandom.nextInt(mPiece.length);
				Piece temp;
				temp=mPiece[random1];
				mPiece[random1]=mPiece[random2];
				mPiece[random2]=temp;
			}
		}

		@Override
		public boolean onTouchEvent(MotionEvent event) {
			if (event.getAction()==MotionEvent.ACTION_DOWN) {
				float x=event.getX();
				float y=event.getY();
				int X=(int)(x/mPieceWidth);
				int Y=(int)(y/mPieceHeight);
				Log.d("Hosung","X="+X+"Y="+Y);		
				
				int BX =0,BY=0;
				for(int i=0; i<mPiece.length;i++) {
					if (mPiece[i].mNum==mPiece.length-1) {
						BX=i%3;
						BY=i/3;
						break;
					}
				}
				if( (X==BX && Math.abs(Y-BY) ==1) || (Y==BY && Math.abs(X-BX) == 1) ) {
					Piece temp;
					int index;
					int blinkIndex;
					index=3*Y+X;
					blinkIndex=3*BY+BX;
					temp=mPiece[index];
					mPiece[index]=mPiece[blinkIndex];
					mPiece[blinkIndex]=temp;
					invalidate();
				}
			}			
			return super.onTouchEvent(event);
		}

		@Override
		protected void onDraw(Canvas canvas) {
			for(int i=0; i<mPiece.length; i++) {
				int X,Y;				
				X=i%3;
				Y=i/3;
				if (mPiece[i].mNum==mPiece.length-1) {
					
				}else{	
					if (mPictureType==PICTURE_TYPE_NUMBER) {
						canvas.drawText(""+(mPiece[i].mNum+1), X*mPieceWidth +50 , Y*mPieceHeight +80, mPaint1);			
						canvas.drawRect(new Rect(X*mPieceWidth,Y*mPieceHeight,(X+1)*mPieceWidth, (Y+1)*mPieceHeight), mPaint2);
					}else if(mPictureType==PICTURE_TYPE_SOOJI) {
						canvas.drawBitmap(mPiece[i].mPieceBitmap, X*mPieceWidth, Y*mPieceHeight,null);
					}	
				}
			}
			super.onDraw(canvas);
		}		
	}
}
