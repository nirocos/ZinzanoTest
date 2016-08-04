package com.faprun.zinzanotest.activity;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.faprun.zinzanotest.R;
import com.faprun.zinzanotest.fragment.NewlotFragment;

public class NewLotActivity extends AppCompatActivity {
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_lot);
        initInstance();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContrainer3,
                            NewlotFragment.newInstance())
                    .commit();
        }


    }

    private void initInstance() {
            MainActivity mainActivity = new MainActivity();
            mainActivity.toolBar();
        }


    }

