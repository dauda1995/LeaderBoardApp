package com.example.leaderboardapp.repo;

import androidx.lifecycle.LiveData;

import com.example.leaderboardapp.model.LeaderInfo;
import com.example.leaderboardapp.model.RetroModel;
import com.example.leaderboardapp.model.SkillsIQInfo;

import java.util.List;

public interface Repository {

    void fetchDataLearning();
    void fetchDataSkills();
    void submitDetails(RetroModel model);
    LiveData<List<LeaderInfo>> getHoursApi();
    LiveData<List<SkillsIQInfo>> getSkillsApi();
    LiveData<Boolean> getSubmitResponse();
}
