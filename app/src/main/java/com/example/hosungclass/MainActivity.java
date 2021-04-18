package com.example.hosungclass;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {	
	//private ListView mListView01;	
	private String []mStringList= {
			"시계",
			"StopWatch",
			"Timer",
			"Lotto",
			"숫자맞추기",
			"주사위",
			"경주", 
			"두더지게임",
			"카드게임",
			"숫자야구",
			"오늘의 메뉴",		
			"그림 예제",
			"퍼즐",
			"그림판", 
			"도형", 
			"구구단",
			"Matrix",
			"숫자 빨리 터치하기",
			"빙고",
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		//mListView01=(ListView)findViewById(R.id.listView1);
		ArrayList<String>alList=new ArrayList<String>();
		for(int i=0;i<mStringList.length;i++){
			alList.add(mStringList[i]);
		}
		//mListView01.setAdapter(new ArrayAdapter<String>(getBaseContext(), R.layout.list_item, alList));
		//mListView01.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, alList));
		setListAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, alList));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		int nIndex = 0;
		String strItem=(String) l.getItemAtPosition(position);
		Toast.makeText(getBaseContext(), strItem, Toast.LENGTH_LONG).show();
		if (strItem.equals(mStringList[nIndex++])) {
			Intent intent = new Intent(MainActivity.this, ClockActivity.class);
			startActivity(intent);
		} else if (strItem.equals(mStringList[nIndex++])) {
			Intent intent = new Intent(MainActivity.this, StopWatchActivity.class);
			startActivity(intent);
		} else if (strItem.equals(mStringList[nIndex++])) {
			Intent intent = new Intent(MainActivity.this, TimerActivity.class);
			startActivity(intent);
		} else if (strItem.equals(mStringList[nIndex++])) {
			Intent intent = new Intent(MainActivity.this, LottoActivity.class);
			startActivity(intent);
		} else if (strItem.equals(mStringList[nIndex++])) {
			Intent intent = new Intent(MainActivity.this, NumberGameActivity.class);
			startActivity(intent);
		} else if (strItem.equals(mStringList[nIndex++])) {
			Intent intent = new Intent(MainActivity.this, DiceActivity.class);
			startActivity(intent);		
		} else if (strItem.equals(mStringList[nIndex++])) {
			Intent intent = new Intent(MainActivity.this, RaceActivity.class);
			startActivity(intent);
		} else if (strItem.equals(mStringList[nIndex++])) {
			Intent intent = new Intent(MainActivity.this, MoleActivity.class);
			startActivity(intent);		
		} else if (strItem.equals(mStringList[nIndex++])) {
			Intent intent = new Intent(MainActivity.this, CardGameMenuActivity.class);
			startActivity(intent);		
		} else if (strItem.equals(mStringList[nIndex++])) {
			Intent intent = new Intent(MainActivity.this, NumberBaseBallActivity.class);
			startActivity(intent);		
		} else if (strItem.equals(mStringList[nIndex++])) {
			Intent intent = new Intent(MainActivity.this, CookActivity.class);
			startActivity(intent);
		} else if (strItem.equals(mStringList[nIndex++])) {
			Intent intent = new Intent(MainActivity.this, DrawingExamActivity.class);
			startActivity(intent);				
		} else if (strItem.equals(mStringList[nIndex++])) {
			Intent intent = new Intent(MainActivity.this, PuzzleActivity.class);
			startActivity(intent);				
		} else if (strItem.equals(mStringList[nIndex++])) {
			Intent intent = new Intent(MainActivity.this, PaintActivity.class);
			startActivity(intent);				
		} else if (strItem.equals(mStringList[nIndex++])) {
			Intent intent = new Intent(MainActivity.this, ShapeActivity.class);
			startActivity(intent);				
		} else if (strItem.equals(mStringList[nIndex++])) {
			Intent intent = new Intent(MainActivity.this, MultiplicationTableActivity.class);
			startActivity(intent);				
		} else if (strItem.equals(mStringList[nIndex++])) {
			Intent intent = new Intent(MainActivity.this, MatrixActivity.class);
			startActivity(intent);
		} else if (strItem.equals(mStringList[nIndex++])) {
			Intent intent = new Intent(MainActivity.this, SpeedNumberActivity.class);
			startActivity(intent);
		} else if (strItem.equals(mStringList[nIndex++])) {
			Intent intent = new Intent(MainActivity.this, BingoActivity.class);
			startActivity(intent);
		}
		
		super.onListItemClick(l, v, position, id);
	}
}
