package com.example.pangestutitan.pangestu_1202154211_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText Uname;
    private EditText Pass;
    String uname, pass;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Uname = (EditText) findViewById(R.id.et_login);
        Pass = (EditText) findViewById(R.id.et_pass);
        Login = (Button) findViewById(R.id.button_login);
    }


    public void onLogin(View view) {
        uname = Uname.getText().toString();
        pass = Pass.getText().toString();
        if (uname.equals("EAD") && pass.equals("MOBILE")) { //set username "EAD" dan password "MOBILE"
            Intent intent = new Intent(Login.this, MainActivity.class); //dari LoginActivity.java menuju MainActivity.java
            Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show(); //menampilkan toast login berhasil
            startActivity(intent);
        } else {
            Toast.makeText(this, "Login Gagal", Toast.LENGTH_SHORT).show(); //menampilkan toast login gagal
        }
    }
}
