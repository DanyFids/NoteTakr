package com.example.a1361709.notetakr;

import android.graphics.Color;

import java.util.Date;

/**
 * Created by 1361709 on 2016-09-08.
 */
public class Note {
    private String title;
    private String body;
    private boolean hasReminder;
    private Date date;
    private int category;


    public Note(String title, String body, boolean hasReminder, Date d, int category) {
        this.title = title;
        this.body = body;
        this.hasReminder = hasReminder;
        this.date = d;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", hasReminder=" + hasReminder +
                ", d=" + date +
                ", category=" + category +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setHasReminder(boolean hasReminder) {
        this.hasReminder = hasReminder;
    }

    public void setD(Date d) {
        this.date = d;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getTitle() {

        return title;
    }

    public String getBody() {
        return body;
    }

    public boolean isHasReminder() {
        return hasReminder;
    }

    public Date getD() {
        return date;
    }

    public int getCategory() {
        return category;
    }
}
