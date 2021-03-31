package com.example.hosung;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

public class SpeedNumberView extends View {
	private Paint mPaint1;
	private Paint mPaint2;

	public SpeedNumberView(Context context, AttributeSet attrs) {
		super(context);
		mPaint1=new Paint();
		mPaint1.setColor(Color.argb(255, 0, 0, 0));

	}

	@Override
	protected void onDraw(Canvas canvas) {
		for(int i=0; i<5;i++) {
			canvas.drawLine(100*i+10, 10, 100*i+10, 410, mPaint1);
		}
		for(int i=0; i<5;i++) {
			canvas.drawLine(10, 100*i+10, 410, 100*i+10, mPaint1);
		}
		super.onDraw(canvas);
	}
}
