
package com.example.reset.food_database.statistics;

import android.os.Bundle;


/*
 * Created by Richard Sengfelder
 */


public class database {

    private init activity;

    public database(init activ, Bundle savedInstanceState) {
        super();
        setActivity(activ);
    }

    init getActivity() {
        return activity;
    }

    void setActivity(init activity) {
        this.activity = activity;
    }
}
