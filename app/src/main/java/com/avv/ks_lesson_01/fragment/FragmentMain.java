package com.avv.ks_lesson_01.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.avv.ks_lesson_01.ActivityMain;
import com.avv.ks_lesson_01.R;


public class FragmentMain extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {


    private Button bt_Clear;
    private Button bt_Send;
    private CheckBox cb_Enable;
    private EditText et_Email;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View viewFragment = inflater.inflate(R.layout.layout_fragment_send_message,null);

        bt_Clear = (Button) viewFragment.findViewById(R.id.bt_Clear);
        bt_Clear.setOnClickListener(this);

        bt_Send = (Button) viewFragment.findViewById(R.id.bt_Send);
        bt_Send.setOnClickListener(this);
        bt_Send.setEnabled(false);

        cb_Enable = (CheckBox) viewFragment.findViewById(R.id.cb_Enable);
        cb_Enable.setOnCheckedChangeListener(this);

        et_Email = (EditText) viewFragment.findViewById(R.id.et_Email);

        return viewFragment;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(ActivityMain.KEY_EMAIL,et_Email.getText().toString());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_Clear:
                et_Email.getText().clear();
                break;
            case R.id.bt_Send:
                //send();
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        bt_Send.setEnabled(b);
    }

}
