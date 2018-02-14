package com.example.reset.food_database.addtodiary;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.reset.food_database.DatabaseHandler;
import com.example.reset.food_database.addtodiary.logic;
import com.example.reset.food_database.objects.DiaryEntry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Richard Sengfelder
 */

//manages the clicklisteners for this activity
public class onClickListener implements OnClickListener {

    private Activity activity;
    private logic applicationLogic;
    private com.example.reset.food_database.addtodiary.gui gui;


    public onClickListener(Activity act, com.example.reset.food_database.addtodiary.gui gui, logic appLogic) {
        super();
        this.gui = gui;
        applicationLogic = appLogic;
        activity = act;
        this.gui.getSubmitfoodbutton().setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view == gui.getSubmitfoodbutton()) {
            applicationLogic.submitFoodButtonClicked();
        }
    }


}
