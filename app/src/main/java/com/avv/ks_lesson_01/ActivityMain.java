package com.avv.ks_lesson_01;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.avv.ks_lesson_01.fragment.FragmentCancel;
import com.avv.ks_lesson_01.fragment.FragmentMain;
import com.avv.ks_lesson_01.fragment.FragmentOk;


public class ActivityMain extends Activity implements View.OnClickListener,OnFragmentNotify {

    public static final String KEY_EMAIL = "key_email";

    private Button btShowToast;


    private FragmentMain frMain;
    private FragmentOk frOk;
    private FragmentCancel frCancel;
    private Fragment frCurrent = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ativity_maim);

        btShowToast = (Button) findViewById(R.id.bt_ShowToast);
        btShowToast.setOnClickListener(this);

        frMain = new FragmentMain();
        frMain.setOnFragmentNotify(this);

        frOk = new FragmentOk();
        frOk.setOnOnFragmentNotifyListenet(this);

        frCancel = new FragmentCancel();
        frCancel.setOnOnFragmentNotifyListener(this);

        setFragment(frMain);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK)
           // et_Email.getText().clear();
            setFragment(frOk);
        if (resultCode == RESULT_CANCELED )
           // showToast("Canceled !");
            setFragment(frCancel);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_ShowToast:
                showToastCompareContext();
                break;
        }
    }

    public void sendEmail(String email){
        if (email.isEmpty() || email.length() < 5 ||email.indexOf("@")<0 || email.indexOf(".")<0) {
            showToast("Bad email");
            return;
        }
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(),ActivityConfirm.class);
        intent.putExtra(KEY_EMAIL,email);
        startActivityForResult(intent,0);
    }
    private void showToast(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();

    }
    private void showToastCompareContext(){
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


    private void setFragment(Fragment newFragment){
        FragmentTransaction fTrn = getFragmentManager().beginTransaction();

        if (frCurrent!= null) {
            fTrn.remove(frCurrent);
            frCurrent = null;
        }

        /*
        if (frCurrent == frOk &&  newFragment == frMain)
            frMain.clearEmail();

        if (newFragment == frMain)
            frMain.doSendDisaible();
        */
        fTrn.add(R.id.fl_FragmentCont,newFragment);
        frCurrent = newFragment;

        fTrn.commit();

    }

    @Override
    public void onFragmentClosed() {
        setFragment(frMain);
    }

    @Override
    public void onFragmentAction(String data) {

        sendEmail( data );

    }
}
