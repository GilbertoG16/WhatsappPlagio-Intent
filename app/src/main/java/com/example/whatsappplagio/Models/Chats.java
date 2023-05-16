package com.example.whatsappplagio.Models;

import android.os.Bundle;

import com.example.whatsappplagio.R;

public class Chats {
    private int imagen;
    private String Nombre;
    private String Chat;
    private String Hora;
    private String ChatCount;


    public Chats(){

    }
    public Chats(int f, String nombre, String chat, String hora, String chatCount) {
        imagen=f;
        Nombre = nombre;
        Chat = chat;
        Hora = hora;
        ChatCount = chatCount;
    }
    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getChat() {
        return Chat;
    }

    public void setChat(String chat) {
        Chat = chat;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public String getChatCount() {
        return ChatCount;
    }

    public void setChatCount(String chatCount) {
        ChatCount = chatCount;
    }

    public Bundle ChatToBundle(){
        Bundle b = new Bundle();
        b.putString("nombre",this.getNombre());
        b.putString("chat",this.getChat());
        b.putInt("count",Integer.parseInt(this.getChatCount()));
        b.putString("hora",this.getHora());

        return b;
    }

    public Chats restoreBundle(Bundle b){
        return new Chats(
                R.drawable.ic_launcher_background,
                b.getString("nombre"),
                b.getString("chat"),
                b.getString("hora"),
                Integer.toString(b.getInt("hora"))

        );
    }

}
