package com.example.beatbuddy;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Useraccount extends Fragment {

    View v;
    UserHelper helper;
    Button logout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_useraccount, container, false);
        // Adding contents to TextView
        TextView email = v.findViewById(R.id.uemail);
        TextView password = v.findViewById(R.id.password);
        logout=v.findViewById(R.id.logout);
        helper=new UserHelper(getActivity().getApplicationContext());

        //Getting the intent data:
        String uemail=getActivity().getIntent().getStringExtra("uemail");
        String upasswd=getActivity().getIntent().getStringExtra("upasswd");
        email.setText(uemail);
        password.setText(upasswd);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity().getApplicationContext(),MainActivity.class);
                startActivity(i);
                getActivity().finish();
            }
        });
        return v;
    }
}
