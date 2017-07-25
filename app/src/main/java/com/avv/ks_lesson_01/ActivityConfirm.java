package com.avv.ks_lesson_01;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by user on 17.07.2017.
 */

public class ActivityConfirm extends Activity implements View.OnClickListener{
    private String email = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layuot_activity_confirm);

        Button btOk = (Button) findViewById(R.id.bt_Ok);
        btOk.setOnClickListener(this);

        Button btCancel = (Button) findViewById(R.id.bt_Cancel);
        btCancel.setOnClickListener(this);

        TextView tvEmail = (TextView) findViewById(R.id.tv_Email);
        tvEmail.setText("no email");

        Intent intent= getIntent();
        if ( intent != null) {
            email = intent.getExtras().get(ActivityMain.KEY_EMAIL).toString();
            tvEmail.setText(email);

        } else
            btOk.setEnabled(false);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.bt_Ok:
                sendEmail();
                setResult(RESULT_OK,intent);
                finish();
                break;
            case R.id.bt_Cancel:
                Toast.makeText(getApplicationContext(), "Email canceled", Toast.LENGTH_SHORT).show();
                setResult(RESULT_CANCELED,intent);
                finish();
                break;
        }
    }

    private void sendEmail(){
        if (email.isEmpty()) return;

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL  , new String[]{ email });
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        intent.putExtra(Intent.EXTRA_TEXT, "Some text");

        startActivity(Intent.createChooser(intent, "Send mail..."));

        Toast.makeText(getApplicationContext(), "Email sending ...", Toast.LENGTH_SHORT).show();
    }
}
