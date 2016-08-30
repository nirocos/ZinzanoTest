package com.faprun.zinzanotest.view;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.faprun.zinzanotest.R;
import com.faprun.zinzanotest.util.BundleSavedState;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by north on 6/8/2559.
 */
public class InputDataCustomViewGroup extends FrameLayout {

    TextView textInputData,textUnit;
    EditText inputData;

    DatePickerDialog datePickerDialog;
    SimpleDateFormat dateFormat;
    Calendar newCalendar;
    int day;
    int month;
    int year;

    String text;
    public InputDataCustomViewGroup(Context context) {
        super(context);
        initInflate();
        initInstance();
    }

    public InputDataCustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstance();
    }

    public InputDataCustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstance();
    }
    @TargetApi(21)
    public InputDataCustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstance();
    }

    private void initInflate() {
        inflate(getContext(),
                R.layout.customviewgroup_inputdata,
                this);
    }

    private void initInstance() {
        newCalendar = Calendar.getInstance();
        day = newCalendar.get(Calendar.DAY_OF_MONTH);
        month = newCalendar.get(Calendar.MONTH);
        year = newCalendar.get(Calendar.YEAR);
        dateFormat = new SimpleDateFormat("dd-MM-yyyy", new Locale("th","TH"));

        textInputData = (TextView)findViewById(R.id.tvtextInputData);
        inputData = (EditText)findViewById(R.id.etinputData);
        textUnit = (TextView)findViewById(R.id.tvtextUnit);
    }
    public String etGetText(){
       text =  inputData.getText().toString().trim();
        return text;
    }
    public void setUnit(String text){
        textUnit.setText(text);
    }
    public void etSetType(int type){
        inputData.setInputType(type);
    }
    public void etCalender (){
        setDateTimeField();
        inputData.setFocusable(false);
        inputData.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });


    }
    public void setTvTextsize(int textsize){
        textInputData.setTextSize(TypedValue.COMPLEX_UNIT_SP,textsize);
    }
    private void setDateTimeField(){
        Context context1 = getContext();
        if(isBrokenSamsungDevice()){
            context1 = new ContextThemeWrapper(getContext(),android.R.style.Theme_Holo_Dialog);
        }
        datePickerDialog = new DatePickerDialog(context1, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year,monthOfYear,dayOfMonth);
                inputData.setText(dateFormat.format(newDate.getTime()));
            }
        },newCalendar.get(Calendar.YEAR),
                newCalendar.get(Calendar.MONTH),
                newCalendar.get(Calendar.DAY_OF_MONTH));
    }
    public void tvSetText(String text){
        textInputData.setText(text);
    }

    private static boolean isBrokenSamsungDevice() {

        return (Build.MANUFACTURER.equalsIgnoreCase("samsung")
                && isBetweenAndroidVersions(
                Build.VERSION_CODES.LOLLIPOP,
                Build.VERSION_CODES.LOLLIPOP_MR1));
    }

    private static boolean isBetweenAndroidVersions(int min, int max) {
        return Build.VERSION.SDK_INT >= min && Build.VERSION.SDK_INT <= max;
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
