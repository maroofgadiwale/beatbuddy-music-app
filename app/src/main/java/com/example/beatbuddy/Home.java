package com.example.beatbuddy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Home extends Fragment {



    View v;
    ListView list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_home,container,false);
        list=v.findViewById(R.id.list);
        ArrayList<Singers>singerList=new ArrayList<Singers>();
        singerList.add(new Singers("Dua","Dua Lipa","88.7M followers"));
        singerList.add(new Singers("Sonu","Sonu Nigam","44.4M followers"));
        singerList.add(new Singers("Guru","Guru Randhawa","34.1M followers"));
        singerList.add(new Singers("Tulsi","Tulsi Kumar","35.5M followers"));
        singerList.add(new Singers("Armaan","Armaan Malik","56.4M followers"));
        singerList.add(new Singers("Arijit","Arijit Singh","90M followers"));
        singerList.add(new Singers("Shreya","Shreya Ghoshal","30M followers"));
        SingerAdapter singerAdapter=new SingerAdapter(getActivity().getApplicationContext(),singerList);
        list.setAdapter(singerAdapter);
        return v;
    }
}