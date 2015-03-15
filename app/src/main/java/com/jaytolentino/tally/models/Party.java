package com.jaytolentino.tally.models;

import android.content.Context;
import android.graphics.Color;

import com.jaytolentino.tally.R;

public enum Party {
    DEMOCRATS, REPUBLICANS, INDEPENDENTS;

    public int getColor(Context context) {
        switch (this) {
            case DEMOCRATS:
                return context.getResources().getColor(R.color.democrats);
            case REPUBLICANS:
                return context.getResources().getColor(R.color.republicans);
            default:
                return Color.DKGRAY;
        }
    }

    public int getTint(Context context) {
        switch (this) {
            case DEMOCRATS:
                return context.getResources().getColor(R.color.democrat_tint);
            case REPUBLICANS:
                return context.getResources().getColor(R.color.republican_tint);
            default:
                return Color.GRAY;
        }
    }
}
