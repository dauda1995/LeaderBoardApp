package com.example.leaderboardapp.network;

import com.example.leaderboardapp.model.LeaderInfo;
import com.example.leaderboardapp.model.RetroModel;
import com.example.leaderboardapp.model.SkillsIQInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by praka on 12/24/2017.
 */

public interface GetDataService {

    @GET("/api/hours")
    Call<List<LeaderInfo>> getLearningLeaders();

    @GET("/api/skilliq")
    Call<List<SkillsIQInfo>> skillIQLeaders();

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    Call<RetroModel> submitPost(@Body RetroModel model);
}
