package com.example.anjali.notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText user,password;
    Button button1,button2;
    Database d;
    SQL operations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText2);
        button1=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button3);
        d=new Database(getApplicationContext());
        operations=new SQL(getApplicationContext());
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!operations.checkTable(user.getText().toString())){
                    operations.createTable(user.getText().toString());
                }
                Intent i=new Intent(MainActivity.this,List.class);
                startActivity(i);
                finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Register.class);
                startActivity(i);
                finish();
            }
        });
    }
}
