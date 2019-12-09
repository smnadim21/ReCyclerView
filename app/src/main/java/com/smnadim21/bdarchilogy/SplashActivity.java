package com.smnadim21.bdarchilogy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.smnadim21.bdarchilogy.advert.SP;

import static com.smnadim21.bdarchilogy.advert.AdsLib.checkSubStatus;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkSubStatus(SP.getSubCode());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,ItemListActivity.class));
            }
        },2000);






    }
}
