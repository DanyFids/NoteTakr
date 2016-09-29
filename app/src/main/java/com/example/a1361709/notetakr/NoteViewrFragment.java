package com.example.a1361709.notetakr;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class NoteViewrFragment extends Fragment {

    private Spinner sort;
    private ListView notes;
    private ArrayAdapter<Note> adapter;

    public NoteViewrFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_note_viewr, container, false);

        //Spinner
        sort = (Spinner) root.findViewById(R.id.sp_sort);

        final List<String> sortMethods = new ArrayList<String>();
        final List<Note> data = NoteData.getData();
        //final List<Note> sortedData;

        sortMethods.add("Title");
        sortMethods.add("Category");
        sortMethods.add("Reminder");
        sortMethods.add("Date Created");
        ArrayAdapter<String> sp_adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_item, sortMethods);

        sp_adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        sort.setAdapter(sp_adapter);

        sort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //sortedData.addAll(data);
                switch(sortMethods.get(position)) {
                    case "title":
                        Collections.sort(data, new Comparator<Note>() {
                            @Override
                            public int compare(Note o1, Note o2) {
                                return o1.getTitle().compareTo(o2.getTitle());
                            }
                        });
                        break;
                    case "Category":
                        Collections.sort(data, new Comparator<Note>() {
                            @Override
                            public int compare(Note o1, Note o2) {
                                if(o1.getCategory() > o2.getCategory()) return 1;
                                else if(o1.getCategory() == o2.getCategory()) return 0;
                                else return -1;
                            }
                        });
                        break;
                    case "Reminder":
                        Collections.sort(data, new Comparator<Note>() {
                            @Override
                            public int compare(Note o1, Note o2) {
                                if(o1.isHasReminder() == o2.isHasReminder()) return 0;
                                else if(o1.isHasReminder() && !o2.isHasReminder()) return 1;
                                else return -1;
                            }
                        });
                        break;
                    case "Date Created":
                        Collections.sort(data, new Comparator<Note>() {
                            @Override
                            public int compare(Note o1, Note o2) {
                                return o1.getCreated().compareTo(o2.getCreated());
                            }
                        });
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Note List
        // 1. Retrieve the ListView
        notes = (ListView) root.findViewById(R.id.lv_notes);

        // 2. Create and initialize adapter
        //adapter = new ArrayAdapter<>(this.getContext(), R.layout.list_item_contact, R.id.firstName_TextView);
        adapter = new NoteDataAdapter(this.getContext());

        // 3.  for today we have sample data

        adapter.addAll(data);

        // 4.  Connect the adapter to the ListView
        notes.setAdapter(adapter);

        // Toast the Contact on click
        notes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), NoteData.getNoteById((int)id).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        //*************************** TESTING *************************

        NoteDatabaseHandler dbh = new NoteDatabaseHandler(getContext());
        NoteTable noteTable = dbh.getNoteTable();
        try {
            noteTable.create(NoteData.getNoteById(0));
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        //*************************************************************

        return root;
    }

    private class NoteDataAdapter extends ArrayAdapter<Note> {

        public NoteDataAdapter(Context context) {
            super(context, -1);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            // inflate or reuse previously inflated UI
            View root;
            if(convertView != null)
                root = convertView;
            else {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                root = inflater.inflate(R.layout.list_item_note, parent, false);
            }

            // Update UI components
            Note note = getItem(position);

            TextView title = (TextView) root.findViewById(R.id.tv_title);
            TextView body = (TextView) root.findViewById(R.id.tv_body);
            ImageView category = (ImageView) root.findViewById(R.id.iv_category);
            ImageView reminder = (ImageView) root.findViewById(R.id.iv_reminder);

            title.setText(note.getTitle());
            body.setText(note.getBody());
            category.setBackgroundColor(note.getCategory());

            if(note.isHasReminder()){
                reminder.setBackground(getResources().getDrawable(R.drawable.ic_remind_on));
            }else{
                reminder.setBackground(getResources().getDrawable(R.drawable.ic_remind_off));
            }

            return root;
        }

        @Override
        public long getItemId(int position) {
            return position; // use Contact IDs
        }
    }
}
