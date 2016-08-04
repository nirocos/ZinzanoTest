package com.faprun.zinzanotest.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
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

/**
 * Created by Admin on 2/8/2559.
 */
public class MainFragment extends Fragment {
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
                String text = etPersonnelId.getText().toString();
                    Intent intent = new Intent(getActivity(), NewLotActivity.class);
                    getActivity().startActivity(intent);
                    getActivity().finish();

            }
        }
    };
}
