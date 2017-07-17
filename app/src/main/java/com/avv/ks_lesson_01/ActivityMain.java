package com.avv.ks_lesson_01;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;


public class ActivityMain extends Activity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private Button bt_ShowToast;
    private Button bt_Clear;
    private Button bt_Send;
    private CheckBox cb_Enable;
    private EditText et_Email;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ativity_maim);

        bt_ShowToast = (Button) findViewById(R.id.bt_ShowToast);
        bt_ShowToast.setOnClickListener(this);

        bt_Clear = (Button) findViewById(R.id.bt_Clear);
        bt_Clear.setOnClickListener(this);

        bt_Send = (Button) findViewById(R.id.bt_Send);
        bt_Send.setOnClickListener(this);
        bt_Send.setEnabled(false);

        cb_Enable = (CheckBox) findViewById(R.id.cb_Enable);
        cb_Enable.setOnCheckedChangeListener(this);

        et_Email = (EditText) findViewById(R.id.et_Email);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_ShowToast:
                showToast_lesson_01();
                break;
            case R.id.bt_Clear:
                et_Email.getText().clear();
                break;
            case R.id.bt_Send:
                send();
                break;

        }
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        bt_Send.setEnabled(b);
    }

    private void send(){
        String email = et_Email.getText().toString();
        if (email.isEmpty() || email.length() <= 5 ||email.indexOf("@")==0 || email.indexOf(".")==0) {
            showToast_lesson_03("Bad email");
            return;
        }


    }
    private void showToast_lesson_03(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();

    }
    private void showToast_lesson_01(){
        Context cntApp = getApplicationContext();
        Context cntBase = getBaseContext();
        StringBuilder msgText  =new StringBuilder("Cntx_App and Cntx_Base is: ");

        if ( cntApp != null && cntBase != null ){
            if (cntApp.equals(cntBase) || cntApp == cntBase ){
                msgText.append(" equal");
            }else{
                msgText.append(" NOT equal");
            }
        }else {
            msgText.append(" NULL !");
        }

        Toast.makeText(cntApp,msgText.toString(),Toast.LENGTH_SHORT).show();
    }
}
