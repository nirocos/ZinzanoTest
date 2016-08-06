package com.faprun.zinzanotest.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.faprun.zinzanotest.R;
import com.faprun.zinzanotest.activity.MainActivity;
import com.faprun.zinzanotest.fragment.MainFragment;

/**
 * Created by north on 5/8/2559.
 */
public class StatusBarCustomViewGroup extends FrameLayout {


    boolean checkLogout = false;
    Button btLogOut;
    TextView tvPersonnel;
    public StatusBarCustomViewGroup(Context context) {
        super(context);
        initInflate();
        initInstance();
    }

    public StatusBarCustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstance();
    }

    public StatusBarCustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstance();
    }
    @TargetApi(21)
    public StatusBarCustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstance();
    }

    private void initInstance() {
        tvPersonnel = (TextView)findViewById(R.id.tvPersonnel);
        btLogOut = (Button)findViewById(R.id.btLogOut);


    }
    public void setPersonnel(String text){
        tvPersonnel.setText(text);
    }
    public void Logout(){
        btLogOut.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getContext()
                        .getSharedPreferences("personnelID",
                                Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.apply();
                String getText = pref.getString("personnelID", "0");

                if (getText.equals("0")) {
                    checkLogout = true;
                    Toast.makeText(getContext(),
                            R.string.textLogout,
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(),
                            MainActivity.class);
                            getContext().startActivity(intent);
                            ((Activity) getContext()).finish();
                }
            }
        });
    }

    private void initInflate() {
        inflate(getContext(),
                R.layout.custoviewgroup_statususer,
                this);
    }
}