package com.jaytolentino.tally.fragments;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaytolentino.tally.R;
import com.jaytolentino.tally.adapters.CandidatesAdapter;
import com.jaytolentino.tally.helpers.Constants;
import com.jaytolentino.tally.models.Candidate;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CandidatesListFragment extends Fragment {
    private Context context;

    @InjectView(R.id.lvCandidates)
    RecyclerView lvCandidates;

    private CandidatesAdapter candidatesAdapter;

    public CandidatesListFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivity() != null) context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_candidates_list, container, false);
        ButterKnife.inject(this, view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        lvCandidates.setLayoutManager(layoutManager);

        List<Candidate> candidates = new ArrayList<>(Constants.MOCK_CANDIDATES);
        candidatesAdapter = new CandidatesAdapter(candidates);
        lvCandidates.setAdapter(candidatesAdapter);
        lvCandidates.setHasFixedSize(true);
        return view;
    }
}
