package com.example.a1361709.notetakr;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by 1361709 on 2016-09-22.
 */
public class NoteTable implements CRUDRepository<Long, Note>{

    private SQLiteOpenHelper dbh;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.sss");

    private final String COLUMN_TITLE = "title";
    private final String COLUMN_BODY = "body";
    private final String COLUMN_REMINDER = "reminder";
    private final String COLUMN_REMIND_DATE = "reminder_date";
    private final String COLUMN_CREATE_DATE = "create_date";
    private final String COLUMN_CATEGORY = "category";

    public String getCreateTableStatement() {
        return "CREATE TABLE Notes (\n" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "title TEXT NOT NULL UNIQUE,\n" +
                "body TEXT NOT NULL,\n" +
                "hasRemind BOOLEAN NOT NULL,\n" +
                "remind TEXT, \n" +
                "created TEXT NOT NULL,\n" +
                "category INTEGER NOT NULL\n" +
                ");";
    }

    public String getDropTableStatement() {
        return "DROP TABLE IF EXISTS Notes;";
    }

    public NoteTable(SQLiteOpenHelper dbh) {
        this.dbh = dbh;
    }

    @Override
    public Long create(Note element) throws DatabaseException {
        SQLiteDatabase db = dbh.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, element.getTitle());
        values.put(COLUMN_BODY, element.getBody());
        values.put(COLUMN_REMINDER, element.isHasReminder());
        values.put(COLUMN_REMIND_DATE, dateFormat.format(element.getD()));
        values.put(COLUMN_CREATE_DATE, dateFormat.format(element.getCreated()));
        values.put(COLUMN_CATEGORY, element.getCategory());

        long insertId = -1;

        try{
            db.insertOrThrow("Notes", null, values);
        }catch(Exception e){
            throw new DatabaseException(e);
        }finally{
            db.close();
        }

        return insertId;
    }

    @Override
    public Note read(Long key) throws DatabaseException {
        return null;
    }

    @Override
    public List<Note> readAll() throws DatabaseException {
        return null;
    }

    @Override
    public boolean update(Note element) throws DatabaseException {
        return false;
    }

    @Override
    public boolean delete(Note element) throws DatabaseException {

        return false;
    }

    public boolean hasInitialData() {
        return true;
    }

    /**
     * Populate table with initial data.
     * Precondition: table has been created.
     * Note: this method is called during the handler's onCreate method where a writable database is opne
     *       trying to get a second writable database will throw an error, hence the parameter.
     * @param database
     */
    public void initialize(SQLiteDatabase database) {

    }
}
