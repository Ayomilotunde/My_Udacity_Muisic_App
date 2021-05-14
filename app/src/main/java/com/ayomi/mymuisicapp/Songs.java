package com.ayomi.mymuisicapp;

public class Songs {
    private String mSongTitle;
    private String mArtistName;
    // Resource ID of album artwork
    private int mArtworkResourceID;
    // song duration in minutes
    private double mDuration;

    public Songs(String mSongTitle, String mArtistName, int mArtworkResourceID, double mDuration) {
        this.mSongTitle = mSongTitle;
        this.mArtistName = mArtistName;
        this.mArtworkResourceID = mArtworkResourceID;
        this.mDuration = mDuration;
    }

    public String getmSongTitle() {
        return mSongTitle;
    }

    public String getmArtistName() {
        return mArtistName;
    }

    public int getmArtworkResourceID() {
        return mArtworkResourceID;
    }

    public double getmDuration() {
        return mDuration;
    }

}
