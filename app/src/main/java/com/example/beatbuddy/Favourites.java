package com.example.beatbuddy;

public class Favourites {
    private String songPic;
    private String songName;

    public Favourites(String songPic, String songName) {
        this.songPic = songPic;
        this.songName = songName;
    }

    public String getSongPic() {
        return songPic;
    }

    public String getSongName() {
        return songName;
    }
}
