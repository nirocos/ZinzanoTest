package com.faprun.zinzanotest.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.faprun.zinzanotest.R;

/**
 * Created by north on 4/8/2559.
 */
public class NewlotFragment extends Fragment {


    public static NewlotFragment newInstance(){
        NewlotFragment newlotFragment = new NewlotFragment();
        Bundle args = new Bundle();
        return newlotFragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_newlot,
                container,
                false);
        initInstance(rootView);
        return rootView;
    }

    private void initInstance(View rootView) {


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
