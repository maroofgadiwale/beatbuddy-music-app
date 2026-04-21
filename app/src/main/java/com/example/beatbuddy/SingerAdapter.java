package com.example.beatbuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SingerAdapter extends ArrayAdapter<Singers>
{
    Context context;
    ArrayList<Singers> singerlist;
    public SingerAdapter(@NonNull Context context,ArrayList<Singers>singers) {
        super(context,R.layout.artists,singers);
        this.context=context;
        this.singerlist=singers;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.artists,parent,false);
        LinearLayout artlinear=(LinearLayout)view.findViewById(R.id.artlinear);
        //Adding animation:
        Animation animation= AnimationUtils.loadAnimation(context.getApplicationContext(),R.anim.bounce);
        artlinear.startAnimation(animation);
        //Linking other components also...
        ImageView singer;
        TextView singerName,followers;
        singer=(ImageView)view.findViewById(R.id.singer);
        singerName=(TextView) view.findViewById(R.id.singerName);
        followers=(TextView) view.findViewById(R.id.followers);
        //Actual Logic:
        singerName.setText(singerlist.get(position).getSingerName());
        followers.setText(singerlist.get(position).getFollower());
        //Setting image
        if(singerlist.get(position).getSinger().equals("Shubhneet"))
        {
            singer.setImageResource(R.drawable.shubh);
        }
        if(singerlist.get(position).getSinger().equals("Shreya"))
        {
            singer.setImageResource(R.drawable.shreya);
        }
        if(singerlist.get(position).getSinger().equals("Dua"))
        {
            singer.setImageResource(R.drawable.dua);
        }
        if(singerlist.get(position).getSinger().equals("Guru"))
        {
            singer.setImageResource(R.drawable.guru);
        }
        if(singerlist.get(position).getSinger().equals("Arijit"))
        {
            singer.setImageResource(R.drawable.arijit);
        }
        if(singerlist.get(position).getSinger().equals("Sonu"))
        {
            singer.setImageResource(R.drawable.sonu);
        }
        if(singerlist.get(position).getSinger().equals("Armaan"))
        {
            singer.setImageResource(R.drawable.armaan);
        }
        if(singerlist.get(position).getSinger().equals("Tulsi"))
        {
            singer.setImageResource(R.drawable.tulsi);
        }

        return view;
    }
}
