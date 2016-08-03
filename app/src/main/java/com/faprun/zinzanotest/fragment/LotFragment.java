package com.faprun.zinzanotest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.faprun.zinzanotest.R;

/**
 * Created by north on 3/8/2559.
 */
public class LotFragment extends Fragment {

    public static LotFragment newInstance(){
        LotFragment lotFragment = new LotFragment();
        Bundle args = new Bundle();
        return lotFragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_lot,
                container,false);
        return rootView;
    }
}
