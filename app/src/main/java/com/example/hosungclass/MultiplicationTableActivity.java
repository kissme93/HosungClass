package com.example.hosungclass;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;

public class MultiplicationTableActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new DrawingView(getBaseContext()));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	class DrawingView extends View {
		private Paint mPaint1;
		private Paint mPaint2;
		private int mNumber=2;
		
		public DrawingView(Context context) {
			super(context);
			mPaint1=new Paint();
			mPaint1.setColor(Color.argb(255, 0, 0, 0));
			mPaint1.setTextSize(30);
			mPaint1.setStrokeWidth(1);
			mPaint2=new Paint();
			mPaint2.setColor(Color.argb(255, 0, 255, 0));
		}

		@Override
		protected void onDraw(Canvas canvas) {
			
			canvas.drawRect(new Rect((mNumber-2)*50+50, 20, (mNumber-2)*50+50+50, 100), mPaint2);
			canvas.drawLine(50, 20, 450, 20, mPaint1);
			canvas.drawLine(50, 100, 450, 100, mPaint1);
			for (int i=0;i<9;i++) {
				canvas.drawLine(i*50+50, 20, i*50+50, 100,mPaint1 );
				if ( i < 8 ) {
					canvas.drawText(""+(2+i), i*50+60, 80, mPaint1);
				}
			}
			
			for (int i=0;i<9;i++) {
				canvas.drawText(""+mNumber+"*"+(i+1)+"="+mNumber*(i+1), 100, i*50+200, mPaint1);				
			}
			
			super.onDraw(canvas);
		}

		@Override
		public boolean onTouchEvent(MotionEvent event) {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				float x = event.getX();
				float y = event.getY();
				if ( 20 <= y && y <= 100 && 50 <= x && x <= 450 ) {					
					mNumber = (int)(( x - 50) / 50) +2;
					invalidate();
				}
			}			
			return super.onTouchEvent(event);
		}		
	}
}
