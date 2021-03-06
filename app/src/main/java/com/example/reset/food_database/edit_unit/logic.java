package com.example.reset.food_database.edit_unit;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.example.reset.food_database.DatabaseHandler;
import com.example.reset.food_database.objects.Unit;

/**
 * Created by Annabella Peekhaus
 */

//logic for editing a unit
public class logic {
    private Activity activity;
    private database data;
    private gui gui;
    private Unit editCurrentUnit;

    public logic(Activity act, database data, gui gui) {
        super();
        this.data = data;
        this.gui = gui;
        activity = act;

        //getting the Id of the unit chosen in add food
        Intent intent = activity.getIntent();
        if (intent != null) {
            DatabaseHandler db = new DatabaseHandler(activity);
            db.getReadableDatabase();
            editCurrentUnit = db.getUnitbyName(intent.getStringExtra("current"));

        }

        gui.getUnitText().setText(String.valueOf(editCurrentUnit.getName()));
    }
    //upgrades the unit which was chosen for editing
    public void submitEditUnitButtonClicked() {
        String indicatedUnit =  gui.getUnitText().getText().toString();
        DatabaseHandler db = new DatabaseHandler(activity);

        if (indicatedUnit.matches("")){
            Toast.makeText(activity, "Please insert a Unit!", Toast.LENGTH_SHORT).show();

        }
        else if (db.doesUnitExist(indicatedUnit) == true){
            Toast.makeText(activity, "Unit is already existing!", Toast.LENGTH_SHORT).show();

        }
        else {
            db.updateUnit(editCurrentUnit.getId(),indicatedUnit);

            Toast.makeText(activity, "Unit " + indicatedUnit + " has been edited!", Toast.LENGTH_SHORT).show();
            Intent intent = activity.getIntent();
            Intent myIntent = new Intent(activity, com.example.reset.food_database.add_food.init.class);
            //handsover the data from add food back to add food + the new unit to set the unitspinner
            if (intent != null) {
                myIntent.putExtra("name", intent.getStringExtra("name"));
                myIntent.putExtra("quantity", intent.getStringExtra("quantity"));
                myIntent.putExtra("kcal", intent.getStringExtra("kcal"));
                myIntent.putExtra("unitname", indicatedUnit);
            }
            activity.startActivity(myIntent);
        }
    }



}
