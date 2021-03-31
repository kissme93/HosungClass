package com.example.hosungclass;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.Menu;
import android.view.View;

public class DrawingExamActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new DrawingExamView(getBaseContext()));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	class DrawingExamView extends View {		
		private Paint mPaint1;
		private Paint mPaint2;
		private Paint mPaint3;
		private Paint mPaint4;
		
		public DrawingExamView(Context context) {
			super(context);
			mPaint1=new Paint();
			mPaint1.setColor(Color.argb(255, 0, 255, 0));
			mPaint2=new Paint();
			mPaint2.setColor(Color.argb (255, 255, 0, 0));
			mPaint3=new Paint();
			mPaint3.setStyle(Paint.Style.STROKE);
			mPaint3.setStrokeWidth(3);
			mPaint3.setTextSize(50);
			mPaint3.setColor(Color.argb(255, 0, 0, 0));
			mPaint4=new Paint();
			mPaint4.setColor(Color.argb(255, 255, 255, 0));
	
		}

		@Override
		protected void onDraw(Canvas canvas) {
			canvas.drawRect(new Rect(100, 100, 200, 200), mPaint1);
			canvas.drawCircle(100, 100, 50, mPaint2);
			canvas.drawText("Hello", 100, 100, mPaint3);
			canvas.drawLine(100, 100, 200, 200, mPaint4);
			canvas.drawOval(new RectF(100, 100, 200, 300), mPaint4);
			super.onDraw(canvas);
		}			
	}
}
