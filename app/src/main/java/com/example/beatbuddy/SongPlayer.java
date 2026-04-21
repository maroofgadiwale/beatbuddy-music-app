package com.example.beatbuddy;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class SongPlayer extends Fragment {

    View v;
    //Adding all components:
    int[] songs={R.raw.nolie,R.raw.satranga,R.raw.suit,R.raw.maahi,R.raw.rolex,R.raw.safari,R.raw.pehlemain};
    int[] images={R.drawable.dua,R.drawable.animal,R.drawable.guru,R.drawable.dunki,R.drawable.vikram,R.drawable.safari,R.drawable.animal};
    String[] songLabels={"No Lie","Satranga","Suit Suit","O Maahi","Lokiverse BGM","Safari","Pehle Bhi Main"};
    TextView songInfo;
    ImageView songBanner,player,prev,next;
    SeekBar seek;
    MediaPlayer mp;
    TextView start,end;
    Handler handler=new Handler();
    int flag=0,currentSongIndex=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_song_player,container,false);
        //Linking all components...
        songInfo=(TextView)v.findViewById(R.id.songInfo);
        songBanner=(ImageView)v.findViewById(R.id.songBanner);
        seek=(SeekBar)v.findViewById(R.id.seek);
        start=(TextView)v.findViewById(R.id.starter);
        end=(TextView)v.findViewById(R.id.ender);
        //Linking required images:
        player=(ImageView)v.findViewById(R.id.player);
        next=(ImageView)v.findViewById(R.id.next);
        prev=(ImageView)v.findViewById(R.id.prev);
        //Actual Operation:
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser && mp != null) {
                    mp.seekTo(progress); // Move the playback to the new position
                    updateSeekBar(); // Update the seekbar and text views accordingly
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == 0) {
                    if (mp == null) {
                        mp = MediaPlayer.create(getActivity().getApplicationContext(), songs[currentSongIndex]);
                        seek.setMax(mp.getDuration());
                        updateSeekBar(); // Start updating the seekbar and text views
                    }
                    player.setImageResource(R.drawable.play);
                    mp.start();
                    flag = 1;
                } else {
                    mp.pause();
                    player.setImageResource(R.drawable.pause);
                    flag = 0;
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentSongIndex < songs.length - 1) {
                    currentSongIndex++; // Move to the next song
                    playCurrentSong();
                } else {
                    // If the current song is the last song, restart from the beginning
                    currentSongIndex = 0;
                    playCurrentSong();
                }
                player.setImageResource(R.drawable.play);
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentSongIndex > 0) {
                    currentSongIndex--; // Move to the previous song
                    playCurrentSong();
                } else {
                    // If the current song is the first song, move to the last song in the array
                    currentSongIndex = songs.length - 1;
                    playCurrentSong();
                }
                player.setImageResource(R.drawable.play);
            }
        });

        return v;
    }

    private void playCurrentSong() {
        if (mp != null) {
            mp.release(); // Release the previous MediaPlayer instance
        }
        mp = MediaPlayer.create(getActivity().getApplicationContext(), songs[currentSongIndex]);
        songBanner.setImageResource(images[currentSongIndex]);
        songInfo.setText(songLabels[currentSongIndex]);
        seek.setMax(mp.getDuration());
        updateSeekBar(); // Start updating the seekbar and text views
        mp.start();
        flag = 1;
    }

    private void updateSeekBar() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mp != null) {
                    int currentPosition = mp.getCurrentPosition();
                    seek.setProgress(currentPosition);

                    start.setText(String.format("%d:%02d",TimeUnit.MILLISECONDS.toMinutes(currentPosition),TimeUnit.MILLISECONDS.toSeconds(currentPosition) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(currentPosition))));
                    end.setText(String.format("%d:%02d", TimeUnit.MILLISECONDS.toMinutes(mp.getDuration()), TimeUnit.MILLISECONDS.toSeconds(mp.getDuration()) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(mp.getDuration()))));

                    handler.postDelayed(this, 1000); // Update every second
                }
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mp != null) {
            if (mp.isPlaying()) {
                mp.stop();
            }
            mp.release();
            mp = null;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mp != null) {
            mp.release();
        }
    }
}