package com.mobAppDev.assignment.histolearn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoAdapter extends ArrayAdapter<VideoDetails> {

    public VideoAdapter(Context context, List<VideoDetails> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        //Position of video obtained
        VideoDetails videoDetails = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.youtube_player_view,parent,false);
        }


        //obtains imageView and textView then image, title and description is set after retrieving them
        ImageView videoThumbnail = (ImageView) convertView.findViewById(R.id.thumbnail);
        TextView title = (TextView) convertView.findViewById(R.id.myTitle);
        TextView description = (TextView) convertView.findViewById(R.id.myDescription);

        String url = videoDetails.getVideoUrl();
        String imageUrl = "https://img.youtube.com/vi/" + url + "/hqdefault.jpg";
        Picasso.with(getContext()).load(imageUrl).into(videoThumbnail);

        title.setText(videoDetails.getVideoTitle());

        description.setText(videoDetails.getVideoDescription());

        return convertView;
    }
}
