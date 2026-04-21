package com.example.beatbuddy;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {


    ImageView heart;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        heart=findViewById(R.id.heart);
        replaceFragment(new Home());
        //Adding ActionBar:
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.custom_actionbar);
        TextView title=actionBar.getCustomView().findViewById(R.id.title);
        title.setText("Singers");
    }

    public void replaceFragment(Fragment f)
    {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frame,f);
        ft.commit();

    }
    //Home fragment:
    public void homeActivity(View view) {
        //Adding ActionBar:
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.custom_actionbar);
        TextView title=actionBar.getCustomView().findViewById(R.id.title);
        title.setText("Singers");
        replaceFragment(new Home());
        heart.setImageResource(R.drawable.favourite);
    }
    //Music fragment:
    public void musicPlay(View view) {
        //Adding ActionBar:
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.custom_actionbar);
        TextView title=actionBar.getCustomView().findViewById(R.id.title);
        title.setText("Songs");
        replaceFragment(new SongPlayer());
        heart.setImageResource(R.drawable.favourite);
    }
    //Favorites:
    public void favouriteAct(View view) {
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.custom_actionbar);
        TextView title=actionBar.getCustomView().findViewById(R.id.title);
        title.setText("Trending Favorites");
        replaceFragment(new Favsongs());
        heart.setImageResource(R.drawable.heart);
    }
    //User account:
    public void user(View view) {
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.custom_actionbar);
        TextView title=actionBar.getCustomView().findViewById(R.id.title);
        title.setText("Your Account");
        heart.setImageResource(R.drawable.favourite);
        replaceFragment(new Useraccount());

    }
}