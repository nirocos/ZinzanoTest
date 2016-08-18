package com.faprun.zinzanotest.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.faprun.zinzanotest.R;
import com.faprun.zinzanotest.activity.LotActivity;
import com.faprun.zinzanotest.activity.NewLotActivity;
import com.faprun.zinzanotest.manager.UserManager;
import com.faprun.zinzanotest.realm.UserRealm;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Admin on 2/8/2559.
 */
public class MainFragment extends Fragment {
    UserManager mHelper = new UserManager(getContext());

    String text;
    EditText etPersonnelId;
    Button btSubmit;
    public static MainFragment newInstance(){
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences getPref = getContext()
                .getSharedPreferences("personnelName",
                        Context.MODE_PRIVATE);
       String getText = getPref.getString("personnelName", "0");

        UserManager userManager = new UserManager(getContext());

        if(!getText.equals("0")){
            Intent intent = new Intent(getActivity(),
                    NewLotActivity.class);
            startActivity(intent);
            getActivity().finish();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main,
                container,
                false);
        InitInstance(rootView);

        return rootView;
    }

    private void InitInstance(View rootView) {
        etPersonnelId = (EditText)rootView.findViewById(R.id.etPersonnelID);
        btSubmit = (Button)rootView.findViewById(R.id.btSubmit);

        btSubmit.setOnClickListener(listener);
        etPersonnelId.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v == btSubmit){
                text = etPersonnelId.getText().toString();
                if(text.matches("")){
                    Toast.makeText(getActivity(),
                            "Please input your personnel ID",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    mHelper = new UserManager(getContext());
                    String userSN = mHelper.checkLogin(text);
                    Log.d("abbbbb",userSN);
                    if(userSN.equals("found")){
                        String userName = mHelper.getUsername(text);
                        SharedPreferences pref = getContext().getSharedPreferences("personnelName",
                                Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("personnelName",userName);
                        editor.apply();
                        String text  = pref.getString("personnelName","0");
                        Toast.makeText(getContext(),
                                text,
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getContext(),
                                NewLotActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    }else{
                        Toast.makeText(getContext(),
                                "Your Personnel ID is wrong",
                                Toast.LENGTH_SHORT).show();
                    }


                }
            }
        }
    };


}
