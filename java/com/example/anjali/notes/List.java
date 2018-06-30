package com.example.anjali.notes;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class List extends AppCompatActivity {
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> arrayAdapter;
    SQL operations;
    Database d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView) findViewById(R.id.listView);
        d = new Database(getApplicationContext());
        operations = new SQL(getApplicationContext());

        if (!d.isLogin()) {
            Intent i = new Intent(List.this, MainActivity.class);
            startActivity(i);
            finish();
        }
        displayNotes(d.getuser());
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout) {
            d.LogOut();
            Intent i = new Intent(List.this, MainActivity.class);
            startActivity(i);
            finish();
        }
        return true;
    }

    void displayNotes(String username) {
        list = operations.getNotes(username);
        if (list.isEmpty()) {
            Toast.makeText(getApplicationContext(), "No notes present", Toast.LENGTH_SHORT).show();
        } else {
            arrayAdapter = new ArrayAdapter<String>(List.this, android.R.layout.simple_list_item_1, list);
            listView.setAdapter(arrayAdapter);
        }
    }

   /* private void openDialogBox(final String name) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_box, null);
        dialogBuilder.setView(dialogView);
        final EditText edt = (EditText) dialogView.findViewById(R.id.edit1);
        dialogBuilder.setTitle("Custom dialog");
        dialogBuilder.setMessage("Enter text below");
        dialogBuilder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                operations.insert(name, edt.getText().toString());
                displayNotes(name);
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();

    }*/
}
