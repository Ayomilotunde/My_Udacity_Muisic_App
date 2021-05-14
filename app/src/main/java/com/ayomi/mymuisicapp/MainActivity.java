package com.ayomi.mymuisicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private boolean isPlaying = false;
    @BindView(R.id.songs_list)
    ListView listView;
    @BindView(R.id.artist_txt)
    TextView nowPlayingArtist;
    @BindView(R.id.song_txt)
    TextView nowPlayingSong;
    @BindView(R.id.play_btn)
    ImageView playBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPlaying){
                    playBtn.setImageResource(R.drawable.ic_baseline_pause_24);
                    isPlaying = true;
                }
                else{
                    playBtn.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                    isPlaying = false;
                }
            }
        });

        final ArrayList<Songs> songsList = new ArrayList<>();



        // add some music data to the list
        songsList.add(new Songs("Most High", "John crew", R.drawable.music, 4.47));
        songsList.add(new Songs("Ga Shi Nan", "Steven", R.drawable.music, 4.18));
        songsList.add(new Songs("Spiritual Law", "Tony Moses", R.drawable.music, 2.53));
        songsList.add(new Songs("Don't Stop",  "Olamide", R.drawable.music, 6.46));
        songsList.add(new Songs("Ejika", "Denike", R.drawable.music, 5.27));


        SongsAdapter adapter = new SongsAdapter(this, songsList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Songs song = songsList.get(position);
                Intent i = new Intent(getApplicationContext(), PlayingActivity.class);
                i.putExtra("title", song.getmSongTitle());
                i.putExtra("artist", song.getmArtistName());
                i.putExtra("albumArt", song.getmArtworkResourceID());
                i.putExtra("duration", song.getmDuration());
                nowPlayingSong.setText(song.getmSongTitle());
                nowPlayingArtist.setText(song.getmArtistName());
                startActivity(i);
            }
        });

    }
}