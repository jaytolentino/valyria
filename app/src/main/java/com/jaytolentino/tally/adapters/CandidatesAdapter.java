package com.jaytolentino.tally.adapters;

import android.content.Context;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaytolentino.tally.R;
import com.jaytolentino.tally.models.Candidate;
import com.jaytolentino.tally.models.Party;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CandidatesAdapter extends RecyclerView.Adapter<CandidatesAdapter.ViewHolder> {

    private Context context;
    private final List<Candidate> candidates;

    public CandidatesAdapter(Context context, List<Candidate> candidates) {
        this.context = context;
        this.candidates = candidates;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_candidate, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
        Candidate candidate = candidates.get(position);
        viewHolder.tvName.setText(candidate.getName());
        setupProfileImage(candidate, viewHolder.ivProfile);
    }

    private void setupProfileImage(Candidate candidate, ImageView ivProfile) {
        Picasso.with(context).load(Uri.parse(candidate.getImageUrl())).into(ivProfile);
        int democratTint = context.getResources().getColor(R.color.democrat_tint);
        int republicanTint = context.getResources().getColor(R.color.republican_tint);
        int tintId = candidate.getParty() == Party.DEMOCRATS ? democratTint : republicanTint;
        ivProfile.setColorFilter(tintId, PorterDuff.Mode.MULTIPLY);
    }

    @Override
    public int getItemCount() {
        return this.candidates.size();
    }

    public final static class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.ivProfile)
        ImageView ivProfile;

        @InjectView(R.id.tvName)
        TextView tvName;

        private ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }
}
