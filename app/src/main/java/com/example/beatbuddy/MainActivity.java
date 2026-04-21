package com.example.beatbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText emailid,password;
    UserHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        emailid=findViewById(R.id.emailid);
        password=findViewById(R.id.password);
        helper=new UserHelper(this);
    }
    public void login(View view) {
        String e=emailid.getText().toString().trim();
        String p=password.getText().toString().trim();
        if(e.length()!=0 || p.length()!=0)
        {
            boolean ans=helper.getCredentials(e,p);
            if(ans)
            {
                Intent i = new Intent(this, Activity2.class);
                i.putExtra("uemail",e);
                i.putExtra("upasswd",p);
                startActivity(i);
            }
            else
            {
                Toast.makeText(this, "Issue...", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Field is empty", Toast.LENGTH_SHORT).show();
        }
    }

    public void signUp(View view) {
        String e=emailid.getText().toString().trim();
        String p=password.getText().toString().trim();
        boolean ans=helper.insertUser(e,p);
        if(ans)
        {
            Toast.makeText(this, "Account Created!", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, Activity2.class);
            i.putExtra("uemail",e);
            i.putExtra("upasswd",p);
            startActivity(i);
        }

    }
}