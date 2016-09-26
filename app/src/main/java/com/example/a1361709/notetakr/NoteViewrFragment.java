package com.example.a1361709.notetakr;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class NoteViewrFragment extends Fragment {

    private ListView notes;
    private ArrayAdapter<Note> adapter;

    public NoteViewrFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_note_viewr, container, false);

        // 1. Retrieve the ListView
        notes = (ListView) root.findViewById(R.id.lv_notes);

        // 2. Create and initialize adapter
        //adapter = new ArrayAdapter<>(this.getContext(), R.layout.list_item_contact, R.id.firstName_TextView);
        adapter = new NoteDataAdapter(this.getContext());

        // 3.  for today we have sample data
        final List<Note> data = NoteData.getData();
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

            title.setText(note.getTitle());
            body.setText(note.getBody());
            category.setBackgroundColor(getResources());

            return root;
        }

        @Override
        public long getItemId(int position) {
            return position; // use Contact IDs
        }
    }
}
