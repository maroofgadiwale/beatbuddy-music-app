package com.example.beatbuddy;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Favsongs extends Fragment {


    View v;
    ListView favsongList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_favsongs,container,false);
        favsongList=v.findViewById(R.id.favsongList);
        //Adding required songs...
        ArrayList<Favourites> favorite=new ArrayList<Favourites>();
        favorite.add(new Favourites("satranga","Satranga ( Animal )"));
        favorite.add(new Favourites("safari","Safari ❤️"));
        favorite.add(new Favourites("vikram","Rolex BGM"));
        favorite.add(new Favourites("maahi","O Maahi"));
        favorite.add(new Favourites("suit","Suit Suit"));
        favorite.add(new Favourites("animal","Pehle Bhi Main"));
        FavouriteAdapter favAdapter=new FavouriteAdapter(getActivity().getApplicationContext(),favorite);
        favsongList.setAdapter(favAdapter);

        //Adding Listener:
        favsongList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        return v;

    }

}