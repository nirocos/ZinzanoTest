package com.faprun.zinzanotest.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.faprun.zinzanotest.R;
import com.faprun.zinzanotest.activity.MainActivity;
import com.faprun.zinzanotest.view.StatusBarCustomViewGroup;

/**
 * Created by north on 4/8/2559.
 */
public class NewlotFragment extends Fragment {
    StatusBarCustomViewGroup cgStatus ;

    public static NewlotFragment newInstance(){
        NewlotFragment fragment = new NewlotFragment();
        Bundle args = new Bundle();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_newlot,
                container,
                false);
        initInstance(rootView);
        return rootView;
    }

    private void initInstance(View rootView) {
        cgStatus = (StatusBarCustomViewGroup)rootView.findViewById(R.id.cgStatus);
        SharedPreferences pref = getContext()
                .getSharedPreferences("personnelID",
                        Context.MODE_PRIVATE);
        String text = pref.getString("personnelID", "0");
        cgStatus.setPersonnel(text);
        cgStatus.Logout();

        }




}


