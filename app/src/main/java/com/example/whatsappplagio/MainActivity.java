package com.example.whatsappplagio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.whatsappplagio.Helpers.ChatsAdapter;
import com.example.whatsappplagio.Models.Chats;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ChatsAdapter adapterComp;
    ListView lstChats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstChats = (ListView)findViewById(R.id.lstChats) ;
        //Adapter sencillo
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                LlenarListViewSimple()
        );
        //Adapter Complejo

        Bundle b = getIntent().getExtras();
        if(b!=null){

            Chats chat = new Chats().restoreBundle(b);
            List<Chats> chats = LlenarListViewCompuesto();
            chats.add(chat);
             adapterComp = new ChatsAdapter(
                    getApplicationContext(),
                    chats
            );
        }else{
            adapterComp = new ChatsAdapter(
                    getApplicationContext(),
                    LlenarListViewCompuesto()
            );
        }

    lstChats.setAdapter(adapterComp);
    }
    //Llenar ListView de forma simple.
    private List<String> LlenarListViewSimple(){
        List<String> chats = new ArrayList<String>();
        chats.add("Cristobal Colón");
        chats.add("Diomedez Diaz");
        chats.add("Cristofer Robin");

        return chats;
    }
    //Llenar List View de forma compleja.
    private List<Chats> LlenarListViewCompuesto(){
        List<Chats> chats = new ArrayList<Chats>();
        chats.add(new Chats( R.drawable.ic_launcher_background,"Camaleón","Te mentí, te ignoré","4:40","1"));
        chats.add(new Chats( R.drawable.ic_launcher_background,"Sifilis","ok","7:30","2"));
        chats.add(new Chats( R.drawable.ic_launcher_background,"Perrito","Se quedó","7:40","7"));
        chats.add(new Chats( R.drawable.ic_launcher_background,"Angel","ola","4:40","5"));
        return chats;
    }
     @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.principal,menu);
        return true;
     }
     @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.miNew){
            Intent i = new Intent(getApplicationContext(),FormActivity.class);
            startActivity(i);
        }
        else{
            Toast.makeText(this, "Opción no habilitada",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
     }
}