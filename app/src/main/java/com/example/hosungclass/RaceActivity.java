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

public class RaceActivity extends Activity {	
	private Button mButton01;
	private RaceView mRaceView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.race);
		mButton01=(Button)findViewById(R.id.button1);
		mRaceView = (RaceView)findViewById(R.id.race);
		mButton01.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				mRaceView.setWorking(!mRaceView.getWorking());
			}
		});			
	}
}
