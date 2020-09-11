package com.example.leaderboardapp.network;

import com.example.leaderboardapp.model.LeaderInfo;
import com.example.leaderboardapp.model.RetroModel;
import com.example.leaderboardapp.model.SkillsIQInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by praka on 12/24/2017.
 */

public interface GetDataService {

    @GET("/api/hours")
    Call<List<LeaderInfo>> getLearningLeaders();

    @GET("/api/skilliq")
    Call<List<SkillsIQInfo>> skillIQLeaders();

    @FormUrlEncoded
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    Call <Void> submitPost(
            @Field("entry.1824927963")String email,
            @Field("entry.1877115667")String firstname,
            @Field("entry.2006916086")String lastname,
            @Field("entry.284483984")String link
    );
}
