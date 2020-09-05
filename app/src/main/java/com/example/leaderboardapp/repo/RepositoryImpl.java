package com.example.leaderboardapp.repo;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.leaderboardapp.model.LeaderInfo;
import com.example.leaderboardapp.model.RetroModel;
import com.example.leaderboardapp.model.SkillsIQInfo;
import com.example.leaderboardapp.repo.datasource.RetrofitUtil;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RepositoryImpl implements Repository {

    private ExecutorService mExecutor = Executors.newFixedThreadPool(5);
    private RetrofitUtil mRetrofitUtil;

    public RepositoryImpl(RetrofitUtil retrofitUtil) {
        mRetrofitUtil = retrofitUtil;
    }

    public static Repository create(Context mAppContext){
        final RetrofitUtil retrofitUtil = new RetrofitUtil(mAppContext);
        return new RepositoryImpl(retrofitUtil);
    }

    @Override
    public void fetchDataLearning() {
        mRetrofitUtil.fetchDataLearning();
    }

    @Override
    public void fetchDataSkills() {
        mRetrofitUtil.fetchDataSkills();
    }

    @Override
    public void submitDetails(RetroModel model) {
        mRetrofitUtil.submitDetails(model);
    }


    @Override
    public LiveData<List<LeaderInfo>> getHoursApi() {
        return mRetrofitUtil.getLearningDataStream();
    }

    @Override
    public LiveData<List<SkillsIQInfo>> getSkillsApi() {
        return mRetrofitUtil.getSkillStream();
    }

    @Override
    public LiveData<Boolean> getSubmitResponse() {
        return mRetrofitUtil.getSubmitResponse();
    }
}
