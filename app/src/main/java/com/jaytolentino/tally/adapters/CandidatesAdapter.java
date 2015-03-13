package com.jaytolentino.tally.adapters;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jaytolentino.tally.R;
import com.jaytolentino.tally.models.Candidate;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

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
    public void onBindViewHolder(final ViewHolder candidateItemViewHolder, int position) {
        Candidate candidate = candidates.get(position);
        candidateItemViewHolder.tvName.setText(candidate.getName());
        RelativeLayout layout = candidateItemViewHolder.rlCandidateHolder;

        Target target = new Target() {
            @Override
            @TargetApi(16)
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                RelativeLayout layout = candidateItemViewHolder.rlCandidateHolder;
                int sdk = android.os.Build.VERSION.SDK_INT;
                if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    layout.setBackgroundDrawable(new BitmapDrawable(bitmap));
                } else {
                    layout.setBackground(new BitmapDrawable(context.getResources(), bitmap));
                }
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) { /*NOP*/ }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) { /*NOP*/ }
        };

        layout.setTag(target);
        Picasso.with(context).load(Uri.parse(candidate.getImageUrl())).into(target);
    }

    @Override
    public int getItemCount() {
        return this.candidates.size();
    }

    public final static class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.rlCandidateHolder)
        RelativeLayout rlCandidateHolder;

        @InjectView(R.id.tvName)
        TextView tvName;

        private ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }
}
