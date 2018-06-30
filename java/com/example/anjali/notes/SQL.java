package com.example.anjali.notes;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class SQL {
    Context context;
    SQLiteDatabase db;
    SQL(Context context)
    {
        this.context=context;
        db=context.openOrCreateDatabase("userDB",context.MODE_PRIVATE,null);
    }
    void createTable(String name)
    {
        db.execSQL("Create table if not exists "+name+"(note VARCHAR)");
    }
    boolean checkTable(String name) {

        Cursor c = null;
        try
        {
            c = db.query(name, null, null, null, null, null, null);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
    void insert(String name,String note)
    {
        db.execSQL("Insert into "+name+" Values('"+note+"')");
    }
    void update(String name,String previousnote,String newnote)
    {

    }
    void delete(String name,String note)
    {

    }
    ArrayList<String> getNotes(String name) {
        Cursor c = db.rawQuery("SELECT * FROM " +name+ "",null);
        ArrayList<String> list = new ArrayList<>();
        if(c.moveToFirst()) {
            do {
                int index = c.getColumnIndex("notes");
                String note = c.getString(index);
                list.add(note);
            } while (c.moveToNext());
        }
        return  list;
    }
}
