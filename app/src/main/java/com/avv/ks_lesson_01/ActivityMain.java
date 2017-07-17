package com.avv.ks_lesson_01;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by user on 16.07.2017.
 */

public class ActivityMain extends Activity implements View.OnClickListener{
    Button bt_ShowToast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ativity_maim);

        bt_ShowToast = (Button) findViewById(R.id.bt_ShowToast);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(bt_ShowToast)){

            Context cntApp = getApplicationContext();
            Context cntBase = getBaseContext();
            StringBuilder msgText  =new StringBuilder("CntApp and CntBase is ");

            if ( cntApp != null && cntBase != null && cntApp.equals(cntBase)){
                msgText.append("equal");
            }else {
                msgText.append("NOT equal");
            }

            Toast.makeText(cntApp,msgText.toString(),Toast.LENGTH_SHORT).show();
        }
    }
}
