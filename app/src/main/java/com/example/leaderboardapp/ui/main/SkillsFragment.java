package com.example.leaderboardapp.ui.main;


import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leaderboardapp.R;
import com.example.leaderboardapp.adapter.SkillsAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SkillsFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private SkillsAdapter mAdapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;

    View mView;

    public static SkillsFragment newInstance(int index) {
        SkillsFragment fragment = new SkillsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        pageViewModel.fetchDataSkills();

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
        pageViewModel.getSkillsTop20().observe(this, model ->{
            mAdapter.setItems(model);

        });
        return root;
    }

    public void initialize(){
        recyclerView = mView.findViewById(R.id.leaderboardrecyc);
        mAdapter = new SkillsAdapter(mView.getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mView.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
    }
}
