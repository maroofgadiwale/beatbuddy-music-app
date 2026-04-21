package com.example.beatbuddy;

public class Singers
{
    private String singer,singerName,follower;

    public Singers(String singer, String singerName, String follower) {
        this.singer = singer;
        this.singerName = singerName;
        this.follower = follower;
    }

    public String getSinger() {
        return singer;
    }

    public String getSingerName() {
        return singerName;
    }

    public String getFollower() {
        return follower;
    }
}
