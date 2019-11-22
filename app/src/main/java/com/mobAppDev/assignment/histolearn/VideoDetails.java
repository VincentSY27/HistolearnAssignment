package com.mobAppDev.assignment.histolearn;

import java.util.ArrayList;

// Video variables and getters
public class VideoDetails {
    private int videoId;
    private String videoTitle;
    private String videoUrl;
    private String videoDescription;

    public VideoDetails(int id, String title, String url, String description) {
        this.videoId = id;
        this.videoTitle = title;
        this.videoUrl = url;
        this.videoDescription = description;
    }

    public int getVideoId() {
        return this.videoId;
    }

    public String getVideoTitle() {
        return this.videoTitle;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getVideoDescription() {
        return this.videoDescription;
    }

    //array list containing the video and details
    private static ArrayList<VideoDetails> youtubeVideos = new ArrayList<VideoDetails>() {{
        add(new VideoDetails(1, "History of the Ottonman Empire", "1oean5l__Cc", "Documentary about the Ottoman Empire"));
        add(new VideoDetails(2, "The Romanovs", "PLnYFdAhFLk", "Documentary exploring the Russian Romanov Dynasty"));
        add(new VideoDetails(3, "Rise of the Rothschilds", "6sM3KOYPL_A", "Documentary on the rise of the Rothschilds, the world's richest family."));
        add(new VideoDetails(4, "Rasputin - The Devil in the Flesh", "sZZ73pk5oDE", "Documentary on Rasputin"));
        add(new VideoDetails(5, "Alexander the Great", "K7lb6KWBanI", "Documentary on Alexander the Great"));
        add(new VideoDetails(6, "The Mongols", "bzatw32j-i4", "Documentary on the Mongols."));
        add(new VideoDetails(7, "Colonisation of America", "fRrYG4IE0C4", "2hr documentary on the colonisation of America."));
    }};

    public static ArrayList<VideoDetails> getYoutubeVideos() {
        return youtubeVideos;
    }


    public static VideoDetails getVideoById(int id) {
        for (VideoDetails video : youtubeVideos) {
            if(video.getVideoId() == id) {
                return video;
            }
        }
        return null;
    }
}

