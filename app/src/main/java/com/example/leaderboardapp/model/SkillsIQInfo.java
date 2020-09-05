package com.example.leaderboardapp.model;

import com.google.gson.annotations.SerializedName;

public class SkillsIQInfo {

    @SerializedName("name")
    public String name;
    @SerializedName("score")
    public String score;
    @SerializedName("country")
    public String country;
    @SerializedName("badgeUrl")
    public String imageUri;

    public SkillsIQInfo(String name, String score, String country, String imageUri) {
        this.name = name;
        this.score = score;
        this.country = country;
        this.imageUri = imageUri;
    }

    public String getScore(){
        return score + " skill IQ Score, " + country + ".";
    }
}
