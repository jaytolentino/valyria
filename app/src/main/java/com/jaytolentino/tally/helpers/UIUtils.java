package com.jaytolentino.tally.helpers;

import android.content.Context;

import com.jaytolentino.tally.R;
import com.jaytolentino.tally.models.Party;

public class UIUtils {

    public static int getPartyColor(Context context, Party party) {
        int democratColor = context.getResources().getColor(R.color.democrats);
        int republicanColor = context.getResources().getColor(R.color.republicans);
        if (party == Party.DEMOCRATS)
            return democratColor;
        else
            return republicanColor;
    }

    public static int getTint(Context context, Party party) {
        int democratTint = context.getResources().getColor(R.color.democrat_tint);
        int republicanTint = context.getResources().getColor(R.color.republican_tint);
        if (party == Party.DEMOCRATS)
            return democratTint;
        else
            return republicanTint;
    }
}
