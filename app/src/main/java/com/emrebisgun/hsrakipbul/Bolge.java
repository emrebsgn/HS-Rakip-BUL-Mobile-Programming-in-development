package com.emrebisgun.hsrakipbul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Bolge extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolge);
    }
    public void anasayfa(View view){
        //Intent sınıfından bir obje oluştururken parametre olarak bulunduğım sınıftan gitmek istediğim sınıfı yazdım
        Intent intent=new Intent(getApplicationContext(),Anasayfa.class);
        startActivity(intent);
    }
    public void istekler(View view){
        //Intent sınıfından bir obje oluştururken parametre olarak bulunduğım sınıftan gitmek istediğim sınıfı yazdım
        Intent intent=new Intent(getApplicationContext(),Bolge_Istek.class);
        startActivity(intent);
    }
    public void istek(View view){
        //Intent sınıfından bir obje oluştururken parametre olarak bulunduğım sınıftan gitmek istediğim sınıfı yazdım
        Intent intent=new Intent(getApplicationContext(),Bolge.class);
        startActivity(intent);
    }

}