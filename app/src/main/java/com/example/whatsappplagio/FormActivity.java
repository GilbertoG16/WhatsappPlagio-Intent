package com.example.whatsappplagio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.whatsappplagio.Models.Chats;

public class FormActivity extends AppCompatActivity {
    EditText nombre, chat, chats;
    TimePicker hora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        InicizalizarControles();
    }
    private void InicizalizarControles(){
        nombre = (EditText)findViewById(R.id.txtNombre);
        chat = (EditText)findViewById(R.id.txtChat);
        chats = (EditText)findViewById(R.id.txtChats);
        hora = (TimePicker)findViewById(R.id.tpHora);
    }
    public void AgregarChat (View view){

        try {
            Chats newChat = new Chats(
                    R.drawable.ic_launcher_background,
                    nombre.getText().toString(),
                    chat.getText().toString(),
                    hora.getHour()+":"+hora.getMinute(),
                    chats.getText().toString()
            );
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            i.putExtras(newChat.ChatToBundle());
            startActivity(i);
        }catch(Exception e){

        }
    }
}