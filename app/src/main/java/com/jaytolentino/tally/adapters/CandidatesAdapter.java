package com.jaytolentino.tally.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jaytolentino.tally.R;
import com.jaytolentino.tally.models.Candidate;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CandidatesAdapter extends RecyclerView.Adapter<CandidatesAdapter.CandidateItemViewHolder> {

    private final List<Candidate> candidates;

    public CandidatesAdapter(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    @Override
    public CandidateItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_candidate, viewGroup, false);
        return new CandidateItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CandidateItemViewHolder candidateItemViewHolder, int position) {
        Candidate candidate = candidates.get(position);
        candidateItemViewHolder.tvName.setText(candidate.getName());
    }

    @Override
    public int getItemCount() {
        return this.candidates.size();
    }

    public final static class CandidateItemViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.tvName)
        TextView tvName;

        private CandidateItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }
}
