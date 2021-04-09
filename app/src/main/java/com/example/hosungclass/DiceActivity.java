package com.example.hosungclass;

import java.util.ArrayList;
import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DiceActivity extends Activity {	
	private Button mButton01;
	private TextView mTextView01;
	private Random mRandom;
	private ImageView mImageView01;
	private ImageView mImageView02;
	private int mDiceNum1;
	private int mDiceNum2;
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dice);
		mRandom=new Random();
		mButton01=(Button)findViewById(R.id.button1);
		mTextView01=(TextView)findViewById(R.id.textView1);
		mImageView01=(ImageView)findViewById(R.id.imageView1);
		mImageView02=(ImageView)findViewById(R.id.imageView2);
		mButton01.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				mDiceNum1=mRandom.nextInt(6)+1;
				mDiceNum2=mRandom.nextInt(6)+1;
				setDiceImage(mDiceNum1, mImageView01);
				setDiceImage(mDiceNum2, mImageView02);
				
				String strText = "첫번째 주사위는 "+mDiceNum1+"입니다.\n두번째 주사위는 "+mDiceNum2+"입니다.\n"+(mDiceNum1+mDiceNum2)+"칸 가세요.";
				if (mDiceNum1==mDiceNum2) {
					mTextView01.setText(strText+"더블입니다.");
				}else{
					mTextView01.setText(strText);
				}
			}
		});				
	}
	public void setDiceImage(int diceNum, ImageView imageView) {
		switch(diceNum) {
		case 1: 
			imageView.setImageResource(R.drawable.dice_1);
			break;
		case 2: 
			imageView.setImageResource(R.drawable.dice_2);
			break;
		case 3: 
			imageView.setImageResource(R.drawable.dice_3);
			break;
		case 4: 
			imageView.setImageResource(R.drawable.dice_4);
			break;
		case 5: 
			imageView.setImageResource(R.drawable.dice_5);
			break;
		case 6: 
			imageView.setImageResource(R.drawable.dice_6);
			break;
		}
	}
}
