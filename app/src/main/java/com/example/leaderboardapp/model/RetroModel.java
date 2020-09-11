package com.example.leaderboardapp.model;

import com.google.gson.annotations.SerializedName;

public class RetroModel {


    public String firstname;

    public String secondname;

    public String email;

    public String githublink;

    public RetroModel(String firstname, String secondname, String email, String githublink) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.email = email;
        this.githublink = githublink;
    }
}
