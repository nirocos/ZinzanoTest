package com.faprun.zinzanotest.view;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.InputType;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.faprun.zinzanotest.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by north on 6/8/2559.
 */
public class InputValueCustomViewGroup extends FrameLayout {

    TextView textInputValue;
    EditText inputValue;

    DatePickerDialog datePickerDialog;
    SimpleDateFormat dateFormat;

    String text;
    public InputValueCustomViewGroup(Context context) {
        super(context);
        initInflate();
        initInstance();
        setDateTimeField();
    }

    public InputValueCustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstance();
        setDateTimeField();
    }

    public InputValueCustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstance();
        setDateTimeField();
    }
    @TargetApi(21)
    public InputValueCustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstance();
        setDateTimeField();

    }

    private void initInflate() {
        inflate(getContext(),
                R.layout.customviewgroup_inputvalue,
                this);
    }

    private void initInstance() {
        dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        textInputValue = (TextView)findViewById(R.id.tvtextInputvalue);
        inputValue = (EditText)findViewById(R.id.etinputValue);

    }
    public String etGetText(){
       text =  inputValue.getText().toString().trim();
        return text;
    }
    public void etSetType(int type){
        inputValue.setInputType(type);
    }
    public void etCalender (){
        inputValue.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });


    }
    private void setDateTimeField(){
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year,monthOfYear,dayOfMonth);
                inputValue.setText(dateFormat.format(newDate.getTime()));
            }
        },newCalendar.get(Calendar.YEAR),
                newCalendar.get(Calendar.MONTH),
                newCalendar.get(Calendar.DAY_OF_MONTH));
    }
    public void tvSetText(String text){
        textInputValue.setText(text);
    }


}
