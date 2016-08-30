package com.faprun.zinzanotest.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.faprun.zinzanotest.R;
import com.faprun.zinzanotest.util.BundleSavedState;

/**
 * Created by Admin on 30/8/2559.
 */
public class LanceFormCustomViewGroup extends FrameLayout {
    TextView lanceCgTitle;
    InputDataCustomViewGroup cgPressure , cgFlowRate,cgVoltage,cgCurrent,cgPower,cgPowerFactor;
    public LanceFormCustomViewGroup(Context context) {
        super(context);
        initInflate();
        initInstance();
    }

    public LanceFormCustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstance();
    }

    public LanceFormCustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstance();
    }
    @TargetApi(21)
    public LanceFormCustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstance();
    }
    private void initInflate() {
        inflate(getContext(),
                R.layout.customviewgroup_formdatalance,
                this);
    }
    private void initInstance() {
        lanceCgTitle = (TextView)findViewById(R.id.lanceCgTitle);

        cgPressure = (InputDataCustomViewGroup)findViewById(R.id.cgDataPressure);
        cgFlowRate = (InputDataCustomViewGroup)findViewById(R.id.cgDataFlowRate);
        cgVoltage = (InputDataCustomViewGroup)findViewById(R.id.cgDataVoltage);
        cgCurrent = (InputDataCustomViewGroup) findViewById(R.id.cgDataCurrent);
        cgPower = (InputDataCustomViewGroup)findViewById(R.id.cgDataPower);
        cgPowerFactor = (InputDataCustomViewGroup)findViewById(R.id.cgDataPowerFactor);


        cgPressure.etSetType(InputType.TYPE_CLASS_TEXT);
        cgPressure.tvSetText("Pressure");
        cgPressure.setUnit("bars./True bar");

        cgFlowRate.etSetType(InputType.TYPE_CLASS_TEXT);
        cgFlowRate.setUnit("l/min / l/hr");
        cgFlowRate.tvSetText("FlowRate(AV)");

        cgVoltage.etSetType(InputType.TYPE_CLASS_TEXT);
        cgVoltage.tvSetText("Voltage");
        cgVoltage.setUnit("Volt.");

        cgCurrent.etSetType(InputType.TYPE_CLASS_TEXT);
        cgCurrent.tvSetText("Current");
        cgCurrent.setUnit("Amps.");

        cgPower.etSetType(InputType.TYPE_CLASS_TEXT);
        cgPower.tvSetText("Power");
        cgPower.setUnit("watts");

        cgPowerFactor.etSetType(InputType.TYPE_CLASS_TEXT);
        cgPowerFactor.tvSetText("Power factor");
        cgPowerFactor.setUnit(" ");
    }

    public String getPressureData(){
        return cgPressure.etGetText();
    }
    public String getFlowRateData(){
        return cgFlowRate.etGetText();
    }
    public String getVoltageData(){
        return cgVoltage.etGetText();
    }
    public String getCurrentData(){
        return cgCurrent.etGetText();
    }
    public String getPowerData(){
        return cgPower.etGetText();
    }
    public String getPowerFactorData(){
        return cgPowerFactor.etGetText();
    }
    public void setTitle(String text){
        lanceCgTitle.setText(text);
    }

    @Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        dispatchFreezeSelfOnly(container);
    }

    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        dispatchThawSelfOnly(container);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        Bundle childrenStates = new Bundle();
        for(int i = 0;i< getChildCount();i++){
            int id = getChildAt(i).getId();
            if(id != 0){
                SparseArray childrenState = new SparseArray();
                getChildAt(i).saveHierarchyState(childrenState);
                childrenStates.putSparseParcelableArray(String.valueOf(id),
                        childrenState);
            }
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("childrenStates", childrenStates);

        BundleSavedState ss = new BundleSavedState(superState);
        ss.setBundle(bundle);
        return ss;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        BundleSavedState ss = (BundleSavedState) state;
        super.onRestoreInstanceState(state);

        Bundle childrenStates = ss.getBundle().getBundle("childrenStates");
        for(int i = 0;i <getChildCount();i++){
            int id = getChildAt(i).getId();
            if(id !=0){
                if(childrenStates.containsKey(String.valueOf(id))){
                    SparseArray childrenState =
                            childrenStates.getSparseParcelableArray(String.valueOf(id));
                    getChildAt(i).restoreHierarchyState(childrenState);
                }
            }
        }

    }
}
