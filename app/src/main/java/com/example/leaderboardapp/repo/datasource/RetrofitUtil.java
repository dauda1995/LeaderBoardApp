package com.example.leaderboardapp.repo.datasource;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.leaderboardapp.model.LeaderInfo;
import com.example.leaderboardapp.model.RetroModel;
import com.example.leaderboardapp.model.SkillsIQInfo;
import com.example.leaderboardapp.network.GetDataService;
import com.example.leaderboardapp.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitUtil {

    private final MutableLiveData<List<LeaderInfo>> learning = new MutableLiveData<>();
    private final MutableLiveData<List<SkillsIQInfo>> skillsIQ = new MutableLiveData<>();
    private final MutableLiveData<Boolean> submitResponse = new MutableLiveData<>();

    private static final String TAG = "RetrofitUtil";
    private GetDataService mService;


    public RetrofitUtil(Context context) {
    }

    public void fetchDataLearning() {
       mService = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<LeaderInfo>> call = mService.getLearningLeaders();
        call.enqueue(new Callback<List<LeaderInfo>>() {
            @Override
            public void onResponse(Call<List<LeaderInfo>> call, Response<List<LeaderInfo>> response) {
                learning.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<LeaderInfo>> call, Throwable t) {

            }
        });


    }

    public void fetchDataSkills(){
        mService = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<SkillsIQInfo>> call2 = mService.skillIQLeaders();
        call2.enqueue(new Callback<List<SkillsIQInfo>>() {
            @Override
            public void onResponse(Call<List<SkillsIQInfo>> call, Response<List<SkillsIQInfo>> response) {
                skillsIQ.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<SkillsIQInfo>> call, Throwable t) {

            }
        });
    }

    public void submitDetails(RetroModel model){
       // submitResponse.setValue(false);
        mService = RetrofitClientInstance.getRetSubmitInstance().create(GetDataService.class);
        Call<Void> call = mService.submitPost(
                model.email,
                model.firstname,
                model.secondname,
                model.githublink
                );
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()) {
                    submitResponse.setValue(true);
                    Log.d(TAG, "onResponse: the data has been fetched "  + response.code());
                }else{
                    Log.d(TAG, "onResponse: something went wrong " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                submitResponse.setValue(false);
            }
        });
    }

    public LiveData<List<SkillsIQInfo>> getSkillStream() {
        return skillsIQ;
    }
    public MutableLiveData<List<LeaderInfo>> getLearningDataStream() {
        return learning;
    }
    public MutableLiveData<Boolean> getSubmitResponse(){
        return submitResponse;
    }
}
