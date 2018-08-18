package com.kurobarabenjamingeorge.themes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        //Retrieves the current mode
        int nightMode = AppCompatDelegate.getDefaultNightMode();

        //Retrieves the night mode menu item
        MenuItem nightModeMenuItem = menu.findItem(R.id.nightMode);

        //Updates the night mode menu item title to match the current mode
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            nightModeMenuItem.setTitle(R.string.night_mode);
        }else{
            nightModeMenuItem.setTitle(R.string.day_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.nightMode){
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }

            recreate();
            return  true;
        }else{
            return super.onOptionsItemSelected(item);
        }
    }
}
