package com.example.a1361709.notetakr;

import android.graphics.Color;

import java.util.Date;

/**
 * Created by 1361709 on 2016-09-08.
 */
public class Note implements Comparable<Note>{
    private String title;
    private String body;
    private boolean hasReminder;
    private Date date;
    private int category;
    private Date created;


    public Note(String title, String body, boolean hasReminder, Date d, Date created, int category) {
        this.title = title;
        this.body = body;
        this.hasReminder = hasReminder;
        this.date = d;
        this.created = created;
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
                ", created=" + created +
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public int compareTo(Note o) {
        if(this.title.compareTo(o.title) > 0) return 1;
        else if(this.title.compareTo(o.title) == 0) return 0;
        else return -1;
    }
}
