package com.example.leaderboardapp.model;

import com.google.gson.annotations.SerializedName;

public class LeaderInfo {

    @SerializedName("name")
    public String name;
    @SerializedName("hours")
    public String score;
    @SerializedName("country")
    public String country;
    @SerializedName("badgeUrl")
    public String imageUri;

    public LeaderInfo(String name, String score, String country, String imageUri) {
        this.name = name;
        this.score = score;
        this.country = country;
        this.imageUri = imageUri;
    }

    public String getScore(){
        return score + " learning hours, " + country + ".";
    }
}
