package alhdo.xyz.ifiedt.UI.activities;

import alhdo.xyz.ifiedt.R;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 5 seconds
                    sleep(2*1000);

                    Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(intent);


                    // After 5 seconds redirect to another intent


                    //Remove activity
                    finish();

                } catch (Exception e) {

                }
            }
        };

        // start thread
        background.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

