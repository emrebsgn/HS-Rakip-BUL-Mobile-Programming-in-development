package com.emrebisgun.hsrakipbul;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HesapOlustur extends AppCompatActivity {
    //Edittext'lerimi tanımladım fakat ParseUser veritabanını bağladığımda bu alanlar değişebilir
    EditText k_adi,k_sifre,adi,soyadi,d_yili,mail,k_sehir,k_ilce,k_mevki;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hesap_olustur);
        //ID tarafından görünümü bulup değişkenime atadım.
        k_adi=findViewById(R.id.k_adi);
        k_sifre=findViewById(R.id.k_sifre);
        adi=findViewById(R.id.adi);
        soyadi=findViewById(R.id.soyadi);
        d_yili=findViewById(R.id.d_yili);
        mail=findViewById(R.id.mail);
        k_sehir =findViewById(R.id.k_sehir);
        k_ilce=findViewById(R.id.k_ilce);
        k_mevki=findViewById(R.id.k_mevki);
        button=findViewById(R.id.button88);

    }
    public void kayit(View view){
        Toast.makeText(HesapOlustur.this, "Çalışıyor", Toast.LENGTH_SHORT).show();
    }
}