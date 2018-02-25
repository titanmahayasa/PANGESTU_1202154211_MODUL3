package com.example.pangestutitan.pangestu_1202154211_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class DetailActivity extends AppCompatActivity {
    private ImageView level;
    private TextView levelIndicator;
    private int minLevel = 0;
    private int currentLevel = 0;
    private int maxLevel = 6;
    private String txtIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //memanggil judul, indikator air, dan dummyteks lorem ipsum
        Intent intent = getIntent();
        TextView title = (TextView) findViewById(R.id.titleDetail);
        levelIndicator = (TextView) findViewById(R.id.airIndicator);
        String iTitle = intent.getStringExtra("title");

        title.setText(iTitle);

        level = (ImageView) findViewById(R.id.airLevel);

        Log.d("level ", "level: "+txtIndicator);


        //memanggil logo air mineral

        ImageView waterImage = (ImageView)findViewById(R.id.waterImageDetail);
        waterImage.setImageResource(getIntent().getIntExtra("image_resource",0));

    }
    //menambahkan air dalam icon botol
    public void addLevel(View view) {
        //jika di klik + akan naik 1 tingkat
        currentLevel+=1;

        //statement pengecekan agar air dalam icon tidak melebihi max level
        if (currentLevel<=maxLevel){
            level.setImageLevel(currentLevel+=1);
            levelIndicator.setText(currentLevel+"L");

            //menampilkan pesan toast kalau air sudah penuh
            if (currentLevel==maxLevel){
                Toast.makeText(this, "Air sudah penuh", Toast.LENGTH_SHORT).show();
            }
            Log.d("current level", "Current Level: "+currentLevel);

            //menjaga agar air tidak melebihi maksimum air didalamnya
        }else{
            currentLevel=maxLevel;
            txtIndicator=currentLevel+"L";
        }
    }
    //mengurangi air dalam icon botol
    public void decreaseLevel(View view) {
        //jika di klik - akan turun 1 tingkat
        currentLevel-=1;
        //if statement untuk pengecekan apakah level kurang dari minimum level
        if (currentLevel>=minLevel){
            level.setImageLevel(currentLevel-=1);
            levelIndicator.setText(currentLevel+"L");

            //menampilkan pesan toast kalau air sedikit
            if  (currentLevel==minLevel){
                Toast.makeText(this, "Air sedikit", Toast.LENGTH_SHORT).show();
            }
            //menjaga agar air tidak kurang dari minimum air didalamnya
        }else{
            currentLevel=minLevel;
            txtIndicator=currentLevel+"L";;
        }
    }

}
