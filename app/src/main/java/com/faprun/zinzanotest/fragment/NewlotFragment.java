package com.faprun.zinzanotest.fragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.faprun.zinzanotest.R;
import com.faprun.zinzanotest.activity.MainActivity;
import com.faprun.zinzanotest.activity.NewLotActivity;
import com.faprun.zinzanotest.view.InputValueCustomViewGroup;
import com.faprun.zinzanotest.view.StatusBarCustomViewGroup;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by north on 4/8/2559.
 */
public class NewlotFragment extends Fragment {


    Boolean changeToDataForm = false;
    Button btNext;
    InputValueCustomViewGroup cgLot,cgModel,cgDate,cgAmout;
    StatusBarCustomViewGroup cgStatus ;
    boolean checklogin = false;

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
        btNext = (Button)rootView.findViewById(R.id.btNext);
        cgStatus = (StatusBarCustomViewGroup)rootView.findViewById(R.id.cgStatus);
        cgLot = (InputValueCustomViewGroup)rootView.findViewById(R.id.cgLot);
        cgModel = (InputValueCustomViewGroup)rootView.findViewById(R.id.cgModel);
        cgDate = (InputValueCustomViewGroup)rootView.findViewById(R.id.cgDate);
        cgAmout = (InputValueCustomViewGroup)rootView.findViewById(R.id.cgAmout);

        cgLot.tvSetText("Lot");
        cgLot.etSetType(InputType.TYPE_CLASS_TEXT );

        cgModel.tvSetText("Model");
        cgModel.etSetType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

        cgDate.tvSetText("Date");
        cgDate.etSetType(InputType.TYPE_NULL);
        cgDate.etCalender();

        cgAmout.tvSetText("Quality");
        cgAmout.etSetType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        SharedPreferences pref = getContext()
                .getSharedPreferences("personnelName",
                        Context.MODE_PRIVATE);
        String text = pref.getString("personnelName", "0");
        cgStatus.setPersonnel(text);
        cgStatus.Logout();
        btNext.setOnClickListener(listener);


    }
    public Boolean getChangeToDataForm() {
        return changeToDataForm;
    }

    public void setChangeToDataForm(Boolean changeToDataForm) {
        this.changeToDataForm = changeToDataForm;
    }
    private Boolean checkEdittextNull(InputValueCustomViewGroup inputValueCustomViewGroup){
        if(inputValueCustomViewGroup.etGetText().matches("")){
            return true;
        }
        return false;
    }
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(v == btNext){

               if(checkEdittextNull(cgLot)||checkEdittextNull(cgModel)||checkEdittextNull(cgDate)||checkEdittextNull(cgAmout)){
                   Toast.makeText(getContext(),
                           "Please input data is complete !!",
                           Toast.LENGTH_SHORT)
                           .show();
               }else{
                   getActivity().getSupportFragmentManager().beginTransaction()
                           .replace(R.id.contentContrainer3,
                                   DataFormFragment.newInstance())
                           .addToBackStack(null)
                           .commit();
               }

            }
        }
    };
}



