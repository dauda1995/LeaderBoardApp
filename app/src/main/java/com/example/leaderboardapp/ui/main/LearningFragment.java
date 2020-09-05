package com.example.leaderboardapp.ui.main;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leaderboardapp.R;
import com.example.leaderboardapp.adapter.LeaderAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class LearningFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private LeaderAdapter mAdapter;
    private RecyclerView recyclerView;
    Dialog mDialog;

    View mView;

    public static LearningFragment newInstance(int index) {
        LearningFragment fragment = new LearningFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        pageViewModel.fetchDataLearning();

        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
//        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        mView = root;
        initialize();

        pageViewModel.getLearningTop20().observe(this, model ->{
            mAdapter.setItems(model);
            mDialog.dismiss();

        });
        return root;
    }

    public void initialize(){
        mDialog = new Dialog(getActivity(), R.style.NewDialog);
        mDialog.addContentView(
                new ProgressBar(mView.getContext()),
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        );
        mDialog.setCancelable(true);
        mDialog.show();
        recyclerView = mView.findViewById(R.id.leaderboardrecyc);
        mAdapter = new LeaderAdapter(mView.getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mView.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
    }
}