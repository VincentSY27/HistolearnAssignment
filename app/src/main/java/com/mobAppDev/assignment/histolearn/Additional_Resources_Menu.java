package com.mobAppDev.assignment.histolearn;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Additional_Resources_Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional__resources__menu);

        VideoAdapter adapter = new VideoAdapter(this, VideoDetails.getYoutubeVideos());

        ListView listView = (ListView) findViewById(R.id.myListview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(playVideo);

    }

    //lets you play youtube videos where onClick opens a new intent for the video.
    AdapterView.OnItemClickListener playVideo = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            ArrayList<VideoDetails> videoDetails = VideoDetails.getYoutubeVideos();
            String title = videoDetails.get(position).getVideoTitle();
            String url = videoDetails.get(position).getVideoUrl();
            Toast.makeText(Additional_Resources_Menu.this, title, Toast.LENGTH_SHORT).show();

            //parse yt url using uri
            Intent vIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + url));
            Intent v2Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com/watch?v=" + url));

            try {
                startActivity(vIntent);
            } catch (ActivityNotFoundException e){
                startActivity(v2Intent);
            }
        }
    };

    //redirects back to home screen
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

}
