package com.jaytolentino.tally.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.jaytolentino.tally.R;
import com.jaytolentino.tally.fragments.CandidateHeaderFragment;
import com.jaytolentino.tally.models.Candidate;

public class ProfileActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Candidate candidate = (Candidate) getIntent().getSerializableExtra(CandidateHeaderFragment.CANDIDATE_INFO);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        Bundle args = new Bundle();
        args.putSerializable(CandidateHeaderFragment.CANDIDATE_INFO, candidate);
        ft.replace(R.id.rlHeaderContainer, CandidateHeaderFragment.newInstance(args));
        ft.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}