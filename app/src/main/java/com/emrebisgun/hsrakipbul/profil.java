package com.emrebisgun.hsrakipbul;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogOutCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class profil extends AppCompatActivity {

    TextView profilKadiText;
    TextView profilAdiText;
    TextView profilMevkiText;
    TextView profilDTarihiText;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.takim_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.takim_olustur){
            Intent intent=new Intent(this,TakimOlustur.class);
            startActivity(intent);
        }
        if(item.getItemId()==R.id.oyuncu_ekle){
            Intent intent=new Intent(this,OyuncuEkle.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        profilKadiText=findViewById(R.id.profilKadiText);
        profilAdiText=findViewById(R.id.profilAdiText);
        profilMevkiText=findViewById(R.id.profilMevkiText);
        profilDTarihiText=findViewById(R.id.profilDTarihiText);

        profilKadiText.setText(ParseUser.getCurrentUser().getUsername());
        profilAdiText.setText(ParseUser.getCurrentUser().get("ad").toString());
        profilMevkiText.setText(ParseUser.getCurrentUser().get("mevki").toString());
        profilDTarihiText.setText(ParseUser.getCurrentUser().get("dogumyili").toString());




    }

}