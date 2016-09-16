package com.example.a1361709.notetakr;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NoteTakr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_takr);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_note_takr, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save) {
            android.app.FragmentManager fgm =  getFragmentManager();

            //Fragment f = fgm.findFragmentById(R.id.fragment);
            View v = findViewById(R.id.fragment);

            EditText title_ET = (EditText) v.findViewById(R.id.et_title);
            EditText body_ET = (EditText) v.findViewById(R.id.et_body);
            EditText date_ET = (EditText) v.findViewById(R.id.et_date);
            EditText time_ET = (EditText) v.findViewById(R.id.et_time);
            Switch reminder_SW = (Switch) v.findViewById(R.id.sw_reminder);
            LinearLayout noteView_LL = (LinearLayout) v.findViewById(R.id.ll_Note);

            String title = title_ET.getText().toString();
            String body = body_ET.getText().toString();
            String dateStr = date_ET.getText().toString() + " " + time_ET.getText().toString();
            DateFormat dateF = new SimpleDateFormat("yyyy/MM/dd hh:mm");
            Date date;
            try {
                date = dateF.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
                date = new Date();
            }

            ColorDrawable color = (ColorDrawable) noteView_LL.getBackground();
            int category = color.getColor();
            boolean isRemind = reminder_SW.isChecked();

            Note note = new Note(title, body, isRemind, date, category);

            Log.d("Save", note.toString());

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
