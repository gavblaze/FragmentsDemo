package com.example.android.fragmantsdemo_fragment_interaction;

import android.os.Bundle;

public interface FragmentActionListener {
    // here we define possible actions
    String ACTION_KEY = "actionKey";

    int ACTION_COUNTRY_CLIKED = 1;
    String COUNTRY_NAME_KEY = "clickKey";
    String DESCRIPTION_KEY = "descKey";


    void onActionPerformed(Bundle bundle);

}
