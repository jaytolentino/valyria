package com.jaytolentino.tally.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaytolentino.tally.R;
import com.jaytolentino.tally.activities.ProfileActivity;
import com.jaytolentino.tally.fragments.CandidateHeaderFragment;
import com.jaytolentino.tally.models.Candidate;
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
        final Candidate candidate = candidates.get(position);
        viewHolder.tvName.setText(candidate.getName());
        viewHolder.tvTitle.setText(candidate.getTitle());
        viewHolder.tvState.setText(candidate.getState());
        setupProfileImage(candidate, viewHolder.ivProfile);
        setupTransitionToProfile(viewHolder, candidate);
    }

    private void setupTransitionToProfile(final CandidatesAdapter.ViewHolder viewHolder,
                                          final Candidate candidate) {
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openProfile = new Intent(context, ProfileActivity.class);
                openProfile.putExtra(CandidateHeaderFragment.CANDIDATE_INFO, candidate);

                Pair<View, String> images = Pair.create(
                        (View) viewHolder.ivProfile,
                        context.getString(R.string.transition_profile_image));
                Pair<View, String> names = Pair.create(
                        (View) viewHolder.tvName,
                        context.getString(R.string.transition_candidate_name));

                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(((Activity) context), images, names);
                context.startActivity(openProfile, options.toBundle());
            }
        });
    }

    private void setupProfileImage(Candidate candidate, ImageView ivProfile) {
        Picasso.with(context).load(Uri.parse(candidate.getImageUrl())).into(ivProfile);
        ivProfile.setColorFilter(candidate.getParty().getTint(context), PorterDuff.Mode.MULTIPLY);
    }

    @Override
    public int getItemCount() {
        return this.candidates.size();
    }

    public final static class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.ivProfileImage)
        ImageView ivProfile;

        @InjectView(R.id.tvName)
        TextView tvName;

        @InjectView(R.id.tvTitle)
        TextView tvTitle;

        @InjectView(R.id.tvState)
        TextView tvState;

        private ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }
}
