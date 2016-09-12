package com.example.a1361709.notetakr;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;

/**
 * A placeholder fragment containing a simple view.
 */
public class NoteTakrFragment extends Fragment {

    private CircleView clr_01;
    private CircleView clr_02;
    private CircleView clr_03;
    private CircleView clr_04;
    private CircleView clr_05;
    private CircleView clr_06;
    private CircleView clr_07;
    private CircleView clr_08;
    private Switch sw_remind;
    private EditText title;
    private EditText body;
    private LinearLayout noteView;
    private EditText date;
    private EditText time;

    public NoteTakrFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_note_takr, container, false);

        sw_remind = (Switch) v.findViewById(R.id.sw_reminder);
        clr_01 = (CircleView) v.findViewById(R.id.clr_01);
        clr_02 = (CircleView) v.findViewById(R.id.clr_02);
        clr_03 = (CircleView) v.findViewById(R.id.clr_03);
        clr_04 = (CircleView) v.findViewById(R.id.clr_04);
        clr_05 = (CircleView) v.findViewById(R.id.clr_05);
        clr_06 = (CircleView) v.findViewById(R.id.clr_06);
        clr_07 = (CircleView) v.findViewById(R.id.clr_07);
        clr_08 = (CircleView) v.findViewById(R.id.clr_08);
        noteView = (LinearLayout) v.findViewById(R.id.ll_Note);
        date = (EditText) v.findViewById(R.id.et_date);
        time = (EditText) v.findViewById(R.id.et_time);

        clr_01.setColor(255,90,90);
        clr_02.setColor(255,120,30);
        clr_03.setColor(255,255,90);
        clr_04.setColor(90,255,90);
        clr_05.setColor(90,255,255);
        clr_06.setColor(90,90,255);
        clr_07.setColor(255,90,255);
        clr_08.setColor(255,255,255);

        clr_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteView.setBackgroundColor(clr_01.getColor());
            }
        });
        clr_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteView.setBackgroundColor(clr_02.getColor());
            }
        });
        clr_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteView.setBackgroundColor(clr_03.getColor());
            }
        });
        clr_04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteView.setBackgroundColor(clr_04.getColor());
            }
        });
        clr_05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteView.setBackgroundColor(clr_05.getColor());
            }
        });
        clr_06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteView.setBackgroundColor(clr_06.getColor());
            }
        });
        clr_07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteView.setBackgroundColor(clr_07.getColor());
            }
        });
        clr_08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteView.setBackgroundColor(clr_08.getColor());
            }
        });

        sw_remind.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    date.setVisibility(View.VISIBLE);
                    time.setVisibility(View.VISIBLE);
                }else{
                    date.setVisibility(View.GONE);
                    time.setVisibility(View.GONE);

                }
            }

        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialogFragment t = new DatePickerDialogFragment();
                t.show(getFragmentManager(), "datePikr");
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialogFragment t = new TimePickerDialogFragment();
                t.show(getFragmentManager(), "timePikr");

            }
        });


        return v;
    }
}
