package com.avv.ks_lesson_01.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.avv.ks_lesson_01.R;

/**
 * Created by user on 20.07.2017.
 */

public class FragmentCancel extends Fragment implements View.OnClickListener{
    Button btCancel;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View viewFragment = inflater.inflate(R.layout.layout_fragment_error,null);

        btCancel = (Button) viewFragment.findViewById(R.id.bt_Ok);
        btCancel.setOnClickListener(this);


        return viewFragment;
    }

    @Override
    public void onClick(View view) {

    }
}
