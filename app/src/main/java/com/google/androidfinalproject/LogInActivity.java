package com.google.androidfinalproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LogInActivity extends AppCompatActivity {

    private EditText editEmailText;
    private EditText editPasswordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_project);

        editEmailText = findViewById(R.id.editTextTextEmailAddress);
        editPasswordText = findViewById(R.id.editTextTextPassword);

    }

    public void loginOnClick(View view){
        //Intent intent = new Intent(Intent.ACTION_PROCESS_TEXT);
        String email = editEmailText.getText().toString();
        String password = editPasswordText.getText().toString();
        Intent intent = new Intent(LogInActivity.this, MainActivity.class);


        if(email.isEmpty())
        {
            Toast.makeText(LogInActivity.this, "Please insert a valid e-mail adress", Toast.LENGTH_LONG).show();
        }
        else if(password.isEmpty()){
            Toast.makeText(LogInActivity.this, "Please insert a password", Toast.LENGTH_LONG).show();
        }
        else{
            String[] separated = editEmailText.getText().toString().split("@");
            intent.putExtra("Name", separated[0]);
            intent.putExtra("Email", editEmailText.getText().toString());
            startActivity(intent);
        }


    }
}