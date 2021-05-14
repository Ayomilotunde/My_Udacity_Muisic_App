package com.ayomi.mymuisicapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongsAdapter extends ArrayAdapter<Songs> {
    public SongsAdapter(Activity context, ArrayList<Songs> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.songs_listview, parent, false);
        }

        Songs currentSong = getItem(position);

        TextView songTitle = (TextView) listItemView.findViewById(R.id.song_txt);
        songTitle.setText(currentSong.getmSongTitle());

        TextView artistName = (TextView) listItemView.findViewById(R.id.artist_txt);
        artistName.setText(currentSong.getmArtistName());


        ImageView artworkImg = (ImageView) listItemView.findViewById(R.id.artwork_img);
        artworkImg.setImageResource(currentSong.getmArtworkResourceID());

        TextView durationTxt = (TextView) listItemView.findViewById(R.id.duration_txt);

        String durationStr = String.valueOf(currentSong.getmDuration());
        String[] timeParts = durationStr.split("\\.");
        durationTxt.setText(String.format("0%s:%s", timeParts[0], timeParts[1]));

        return listItemView;
    }
}
