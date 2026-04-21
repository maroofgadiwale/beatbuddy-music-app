package com.example.beatbuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FavouriteAdapter extends ArrayAdapter<Favourites> {

    Context context;
    ArrayList<Favourites> favList;
    public FavouriteAdapter(@NonNull Context context, ArrayList<Favourites>favList) {
        super(context, R.layout.favsongs,favList);
        this.context=context;
        this.favList=favList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.favsongs,parent,false);
        ImageView songPic;
        TextView songName;
        songPic=(ImageView)v.findViewById(R.id.songPic);
        songName=(TextView)v.findViewById(R.id.songName);
        songName.setText(favList.get(position).getSongName());
        //Adding images:
        if(favList.get(position).getSongPic().equals("satranga"))
        {
            songPic.setImageResource(R.drawable.animal);
        }
        else if(favList.get(position).getSongPic().equals("safari"))
        {
            songPic.setImageResource(R.drawable.safari);
        }
        else if(favList.get(position).getSongPic().equals("vikram"))
        {
            songPic.setImageResource(R.drawable.vikram);
        }
        else if(favList.get(position).getSongPic().equals("suit"))
        {
            songPic.setImageResource(R.drawable.guru);
        }
        else if(favList.get(position).getSongPic().equals("maahi"))
        {
            songPic.setImageResource(R.drawable.dunki);
        }
        else
        {
            songPic.setImageResource(R.drawable.animal);
        }
        return v;
    }
}
