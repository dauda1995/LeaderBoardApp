package com.example.leaderboardapp.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.leaderboardapp.model.LeaderInfo;
import com.example.leaderboardapp.model.RetroModel;
import com.example.leaderboardapp.model.SkillsIQInfo;
import com.example.leaderboardapp.repo.Repository;
import com.example.leaderboardapp.repo.RepositoryImpl;

import java.util.List;

public class PageViewModel extends AndroidViewModel {

    private Repository mRepository;

    public PageViewModel(@NonNull Application application) {
        super(application);
        mRepository = RepositoryImpl.create(application);
    }

    public void fetchDataLearning(){
        mRepository.fetchDataLearning();
    }

    public void fetchDataSkills(){
        mRepository.fetchDataSkills();
    }

    public void submitDetails(RetroModel model){
        mRepository.submitDetails(model);
    }

    public LiveData<List<LeaderInfo>> getLearningTop20(){
        return mRepository.getHoursApi();
    }

    public LiveData<List<SkillsIQInfo>> getSkillsTop20(){ return mRepository.getSkillsApi();}

    public LiveData<Boolean> getSubmitResponse(){
        return mRepository.getSubmitResponse();
    }


}