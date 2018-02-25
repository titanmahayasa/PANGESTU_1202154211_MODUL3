package com.example.pangestutitan.pangestu_1202154211_modul3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Toast.makeText(this, "PANGESTU_1202154211_MODUL3", Toast.LENGTH_SHORT).show(); //menampilkan pesan toast "RAZAIQBAL_1202152163_MODUL3"
        Thread thread = new Thread(){
            public void run() {
                try {
                    sleep(4000); //splashscreen akan muncul selama 4 detik
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(SplashScreen.this, Login.class)); //setelah splash screen, lalu menuju ke login activity
                    finish();
                }
            }
        };
        thread.start();
    }
}
