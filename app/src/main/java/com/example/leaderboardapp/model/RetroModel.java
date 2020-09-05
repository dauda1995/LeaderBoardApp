package com.example.leaderboardapp.model;

import com.google.gson.annotations.SerializedName;

public class RetroModel {

    @SerializedName("entry.1877115667")
    public String firstname;
    @SerializedName("entry.2006916086")
    public String secondname;
    @SerializedName(" entry.1824927963")
    public String email;
    @SerializedName("entry.284483984")
    public String githublink;

    public RetroModel(String firstname, String secondname, String email, String githublink) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.email = email;
        this.githublink = githublink;
    }
}
