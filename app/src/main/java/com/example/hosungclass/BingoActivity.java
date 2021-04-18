package com.example.hosungclass;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;


public class BingoActivity extends Activity implements GameOverListener {

    private BingoView mBingoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bingo);

        mBingoView = (BingoView)findViewById(R.id.gameview);
        mBingoView.setOnGameOverListener(this);
    }

    @Override
    public void GameOver() {
        finish();
    }
}

