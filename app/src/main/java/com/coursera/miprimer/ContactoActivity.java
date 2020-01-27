package com.coursera.miprimer;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ContactoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }


    public void enviaMail(View view) {



        EditText ETEmail = (EditText)findViewById(R.id.editEmail);
        String Email = ETEmail.getText().toString();

        EditText ETMensaje = (EditText)findViewById(R.id.editMensaje);
        String Mensaje = ETMensaje.getText().toString();

        Log.e("Email", "entra a enviaMail");
        EmailSenderService emailService = new EmailSenderService();
        emailService.sendEmail(Mensaje, Email);
        finish();
        Toast.makeText(ContactoActivity.this, "Email ha sido enviado", Toast.LENGTH_LONG).show();


    }
}
