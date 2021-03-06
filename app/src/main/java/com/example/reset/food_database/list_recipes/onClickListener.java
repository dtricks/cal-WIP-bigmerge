
package com.example.reset.food_database.list_recipes;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * Created by Matthias Dellert
 */

//manages searchview, listview & clicklisteners for this activity
//public class onClickListener implements android.widget.SearchView.OnQueryTextListener, ListView.OnItemClickListener  {
public class onClickListener implements OnClickListener, android.widget.SearchView.OnQueryTextListener, ListView.OnItemClickListener {

    private Activity activity;
    private logic applicationLogic;
    private com.example.reset.food_database.list_recipes.gui gui;

    public onClickListener(Activity act, com.example.reset.food_database.list_recipes.gui gui, logic appLogic) {
        super();
        this.gui = gui;
        applicationLogic = appLogic;
        activity = act;
        //this.gui.getAddFood().setOnClickListener(this);
        this.gui.getAddRecipe().setOnClickListener(this);
        this.gui.getRecipeSearch().setOnQueryTextListener(this);
        this.gui.getRecipeList().setOnItemClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view == gui.getAddRecipe()) {
            applicationLogic.addRecipeButtonClicked();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final String selectedItem = (String) parent.getItemAtPosition(position);
        applicationLogic.itemClicked(selectedItem);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
            gui.getRecipeList().clearTextFilter();
        } else {
            gui.getRecipeList().setFilterText(newText.toString());
        }
        return true;
    }

}
