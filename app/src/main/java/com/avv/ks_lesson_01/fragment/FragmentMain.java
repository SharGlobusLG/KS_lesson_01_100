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
import com.avv.ks_lesson_01.OnFragmentNotify;
import com.avv.ks_lesson_01.R;


public class FragmentMain extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{

    private OnFragmentNotify  callBack;

    private Button btClear;
    private Button btSend;
    private CheckBox cbEnable;
    private EditText etEmail;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View viewFragment = inflater.inflate(R.layout.layout_fragment_send_message,null);

        btClear = (Button) viewFragment.findViewById(R.id.bt_Clear);
        btClear.setOnClickListener(this);

        btSend = (Button) viewFragment.findViewById(R.id.bt_Send);
        btSend.setOnClickListener(this);
        btSend.setEnabled(false);

        cbEnable = (CheckBox) viewFragment.findViewById(R.id.cb_Enable);
        cbEnable.setOnCheckedChangeListener(this);

        etEmail = (EditText) viewFragment.findViewById(R.id.et_Email);



        return viewFragment;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(ActivityMain.KEY_EMAIL, etEmail.getText().toString());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_Clear:
                etEmail.getText().clear();
                break;
            case R.id.bt_Send:
                if ( callBack != null )
                    callBack.onFragmentAction( etEmail.getText().toString() );
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        btSend.setEnabled(b);
    }

    public void setOnFragmentNotify(OnFragmentNotify callBack) {
        this.callBack = callBack;
    }


    public void  doSendDisaible(){
        cbEnable.setPressed(false);
        btSend.setEnabled(false);
    }


    public void clearEmail(){
        etEmail.getText().clear();
    }

}
