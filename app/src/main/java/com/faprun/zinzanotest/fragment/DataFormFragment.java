package com.faprun.zinzanotest.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.faprun.zinzanotest.R;
import com.faprun.zinzanotest.view.InputDataCustomViewGroup;
import com.faprun.zinzanotest.view.LanceFormCustomViewGroup;
import com.faprun.zinzanotest.view.StatusBarCustomViewGroup;

/**
 * Created by Admin on 30/8/2559.
 */
public class DataFormFragment extends Fragment {
    LanceFormCustomViewGroup adjustableLance,rotoLance;
    InputDataCustomViewGroup cgPressure , cgFlowRate,cgVoltage,cgCurrent,cgPower,cgPowerFactor;
    StatusBarCustomViewGroup cgStatus;
    public static DataFormFragment newInstance(){
        DataFormFragment fragment = new DataFormFragment();
        Bundle args = new Bundle();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dataform,
                container,
                false);
        initInstance(rootView);
        return rootView;
    }


    private void initInstance(View rootView) {
        adjustableLance =(LanceFormCustomViewGroup)rootView.findViewById(R.id.adjustableLance);
        rotoLance =(LanceFormCustomViewGroup)rootView.findViewById(R.id.rotoLance);
        adjustableLance.setTitle("Adjustable Lance");
        rotoLance.setTitle("Roto Lance");
//        cgPressure = (InputDataCustomViewGroup)rootView.findViewById(R.id.cgDataPressure);
//        cgFlowRate = (InputDataCustomViewGroup)rootView.findViewById(R.id.cgDataFlowRate);
//        cgVoltage = (InputDataCustomViewGroup)rootView.findViewById(R.id.cgDataVoltage);
//        cgCurrent = (InputDataCustomViewGroup) rootView.findViewById(R.id.cgDataCurrent);
//        cgPower = (InputDataCustomViewGroup)rootView.findViewById(R.id.cgDataPower);
//        cgPowerFactor = (InputDataCustomViewGroup)rootView.findViewById(R.id.cgDataPowerFactor);
        cgStatus = (StatusBarCustomViewGroup)rootView.findViewById(R.id.cgStatus);

//        cgPressure.etSetType(InputType.TYPE_CLASS_TEXT);
//        cgPressure.tvSetText("Pressure");
//        cgPressure.setUnit("bars./True bar");
//
//        cgFlowRate.etSetType(InputType.TYPE_CLASS_TEXT);
//        cgFlowRate.setUnit("l/min / l/hr");
//        cgFlowRate.tvSetText("FlowRate(AV)");
//
//        cgVoltage.etSetType(InputType.TYPE_CLASS_TEXT);
//        cgVoltage.tvSetText("Voltage");
//        cgVoltage.setUnit("Volt.");
//
//        cgCurrent.etSetType(InputType.TYPE_CLASS_TEXT);
//        cgCurrent.tvSetText("Current");
//        cgCurrent.setUnit("Amps.");
//
//        cgPower.etSetType(InputType.TYPE_CLASS_TEXT);
//        cgPower.tvSetText("Power");
//        cgPower.setUnit("watts");
//
//        cgPowerFactor.etSetType(InputType.TYPE_CLASS_TEXT);
//        cgPowerFactor.tvSetText("Power factor");
//        cgPowerFactor.setUnit(" ");

        SharedPreferences pref = getContext()
                .getSharedPreferences("personnelName",
                        Context.MODE_PRIVATE);
        String text = pref.getString("personnelName", "0");
        cgStatus.setPersonnel(text);
        cgStatus.Logout();

    }

}
