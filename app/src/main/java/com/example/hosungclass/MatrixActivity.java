package com.example.hosungclass;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;

public class MatrixActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new DrawingView(getBaseContext()));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	class DrawingView extends View {		
		private int[][] mMatrix;
		private Paint mPaint1;
		public DrawingView(Context context) {
			super(context);
			mPaint1=new Paint();
			mPaint1.setStyle(Paint.Style.FILL);
			mPaint1.setStrokeWidth(1);
			mPaint1.setTextSize(30);
			mPaint1.setColor(Color.argb(255, 0, 0, 0));
			mMatrix = new int[4][4];
			for (int i=0;i<4;i++){
				for (int j=0;j<4;j++){
					mMatrix[i][j]=4*i+j+1;					
					Log.d("Hosung", "i="+i+", j="+j+", x="+(4*i+j+1));
				}
			}
		}

		@Override
		protected void onDraw(Canvas canvas) {
			for(int i=0;i<4;i++) {
				for (int j=0;j<4;j++){
					canvas.drawText(""+mMatrix[i][j], 50+100*j+30, 50+100*i+70, mPaint1);					
				}
			}			
			// Vertical Line
			for(int i=0;i<5;i++) {
				canvas.drawLine(50+100*i, 50, 50+100*i, 50+400, mPaint1);
			}			
			// Horizontal Line
			for(int i=0;i<5;i++) {
				canvas.drawLine(50, 50+100*i, 50+400, 50+100*i, mPaint1);
			}
			super.onDraw(canvas);
		}

		@Override
		public boolean onTouchEvent(MotionEvent event) {
			// TODO Auto-generated method stub
			if ( event.getAction() == MotionEvent.ACTION_DOWN) {
				float x = event.getX();
				float y = event.getY();				
				int j = (int)(( x - 50 ) / 100); 
				int i = (int)(( y - 50 ) / 100);
				Log.d("Hosung", "x="+x+", y="+y+"====>, j="+j+", i="+i);				
			}
			return super.onTouchEvent(event);
		}		
	}
}
