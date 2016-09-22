package com.example.a1361709.notetakr;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Sample data for notes
 * @author Ian Clement (ian.clement@johnabbott.qc.ca)
 */
public class NoteData {

    private static final SimpleDateFormat format;

    // color values retrieved manually, for test data only.
    private static final int BASE08_COLOR = R.color.color_01;
    private static final int BASE09_COLOR = R.color.color_02;
    private static final int BASE0A_COLOR = R.color.color_03;
    private static final int BASE0B_COLOR = R.color.color_04;
    private static final int BASE0C_COLOR = R.color.color_05;
    private static final int BASE0D_COLOR = R.color.color_06;
    private static final int BASE0E_COLOR = R.color.color_07;
    private static final int BASE0F_COLOR = R.color.color_08;

    private static List<Note> data;

    static {

        format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        data = new ArrayList<>();
        try {
            data.add(new Note("Lorem ipsum dolor"
                            , "Lorem ipsum dolor sit amet, vel ei graece primis ullamcorper, unum denique an nam. Eum fabulas impedit tibique ex. No nonumes lobortis usu, te probo partem consequat vel. An dicta fastidii iracundia mel, eum pertinax consequat id. Est commune sadipscing ex, vocent laoreet an ius."
                            , true
                            , format.parse("2016-10-10 21:32:43")
                            , format.parse("2016-10-12 12:23:34")
                            , BASE0A_COLOR));

            data.add(new Note("Nullam disputando eam"
                            , "Nullam disputando eam at, ullamcorper conclusionemque sed ad. Sit urbanitas adolescens cu, elit saepe ei nam. Latine voluptua adipisci sed ei. Per eu nostro eruditi sanctus, ad duo eleifend mediocrem definiebas, usu cibo commodo euripidis id."
                            , true
                            , format.parse("2016-10-10 21:32:43")
                            , format.parse("2016-09-10 12:24:34"), BASE0D_COLOR));

            data.add(new Note("Pro civibus salutatus"
                            , "Pro civibus salutatus at, eum ei propriae accusamus, duo vidisse prompta ne. Has movet ocurreret elaboraret in, choro accommodare ne sea. Vel assum albucius nominati no. Te nam quem impetus, graeci intellegam mea ea."
                            , false, null
                            , format.parse("2016-09-10 12:25:34")
                            , BASE0D_COLOR));

            data.add(new Note("An commodo legimus lucilius"
                            , "An commodo legimus lucilius cum, cu clita noluisse apeirian duo. Cu sanctus blandit splendide per. Duo no assum vidisse deleniti. Integre similique assueverit ne eum, ad mei admodum fuisset similique, zril saepe theophrastus vim ut. Ea tation omittam principes has. Id nec consequat adversarium, ne pri ipsum numquam."
                            , true, format.parse("2016-10-13 12:12:12")
                            , format.parse("2016-09-10 12:26:34")
                            , BASE08_COLOR));

            data.add(new Note("Te magna animal civibus"
                            , "Te magna animal civibus cum, assum efficiantur mel id. At nec meis oportere, nihil quidam temporibus mei ad. Nec suas convenire ea, ad qui numquam copiosae. Amet vide possit et has. Vim elitr maiorum voluptatibus te."
                            , true, format.parse("2016-10-12 16:32:54")
                            , format.parse("2016-09-10 12:27:34")
                            , BASE0F_COLOR));

        }
        catch (ParseException e) {
            // will not occur
            e.printStackTrace();
        }
    }


    public static List<Note> getData() {
        // create a copy of the original data and return it.
        // copy prevent messing with order of the original.
        List<Note> dataCopy = new ArrayList<>(data.size());
        for(Note note : data)
            dataCopy.add(note);
        // this didn't work as expected Collections.copy(dataCopy, data);
        return dataCopy;
    }
}
