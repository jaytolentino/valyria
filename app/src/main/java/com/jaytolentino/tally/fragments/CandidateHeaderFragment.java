package com.jaytolentino.tally.fragments;


import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaytolentino.tally.R;
import com.jaytolentino.tally.models.Candidate;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CandidateHeaderFragment extends Fragment {

    public static final String CANDIDATE_INFO = "candidateInfo";

    private Context context;
    private Candidate candidate;

    @InjectView(R.id.ivProfileImage)
    ImageView ivProfileImage;
    @InjectView(R.id.tvName)
    TextView tvName;
    @InjectView(R.id.tvTitle)
    TextView tvTitle;

    public CandidateHeaderFragment() {}

    public static CandidateHeaderFragment newInstance(Bundle args) {
        CandidateHeaderFragment fragment = new CandidateHeaderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        if (getArguments().containsKey(CANDIDATE_INFO)) {
            candidate = (Candidate) getArguments().getSerializable(CANDIDATE_INFO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_candidate_header, container, false);
        ButterKnife.inject(this, view);
        if (candidate != null) {
            tvName.setText(candidate.getName());
            tvTitle.setText(candidate.getTitle());
            ivProfileImage.setColorFilter(candidate.getParty().getTint(context), PorterDuff.Mode.MULTIPLY);
            Picasso.with(context).load(candidate.getImageUrl()).into(ivProfileImage);
        }
        return view;
    }


}
