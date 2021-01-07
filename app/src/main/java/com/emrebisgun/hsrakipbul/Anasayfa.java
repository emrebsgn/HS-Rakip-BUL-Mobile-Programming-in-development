package com.emrebisgun.hsrakipbul;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogOutCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class Anasayfa extends AppCompatActivity {

    TextView ustAdText;

    //Hangi menuyu bağlayacağımızı belirtmek için kullanıyoruz.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Eklediğim menudelerden bir seçenek tıklanırsa ne olacak.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.gonderi_Ekle){
            Intent intent=new Intent(getApplicationContext(),Paylasim.class);
            startActivity(intent);
        }else if(item.getItemId()==R.id.cikis){
            ParseUser.logOutInBackground(new LogOutCallback() {
                @Override
                public void done(ParseException e) {
                    if(e!=null){
                        Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }else{
                        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);

                    }
                }
            });
        }else if(item.getItemId()==R.id.gonderiler){
            Intent intent=new Intent(getApplicationContext(),Gonderiler.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);

        ustAdText=findViewById(R.id.ustAdText);
        ustAdText.setText(ParseUser.getCurrentUser().getUsername());
    }


    public void istek(View view){
        Intent intent=new Intent(getApplicationContext(),Bolge.class);
        startActivity(intent);
    }

    public void profil(View view){
        Intent intent=new Intent(getApplicationContext(),profil.class);
        startActivity(intent);
    }
}