package com.example.reset.food_database.recipe_addtolist;

import android.os.Bundle;


/**
 * Created by Matthias Dellert
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

