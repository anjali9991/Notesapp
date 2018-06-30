package com.example.anjali.notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {
EditText username,password;
    Button register;
    Database d;
    SQL operations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register=(Button)findViewById(R.id.button2);
        password=(EditText)findViewById(R.id.editText5);
        d=new Database(getApplicationContext());
        operations=new SQL(getApplicationContext());
        username=(EditText)findViewById(R.id.editText4);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.createUser(username.getText().toString(),password.getText().toString());
                Intent i=new Intent(Register.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
