package com.jaytolentino.tally.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jaytolentino.tally.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CandidatesListFragment extends Fragment {

    @InjectView(R.id.lvCandidates)
    private ListView lvCandidates;

    public CandidatesListFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_candidates_list, container, false);
        ButterKnife.inject(this, view);
        return view;
    }
}
