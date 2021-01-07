package com.emrebisgun.hsrakipbul;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class kayitol extends AppCompatActivity {
    EditText k_adi,k_sifre,adi,soyadi,d_yili,mail,k_sehir,k_ilce,k_mevki;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayitol);

        ParseUser.getCurrentUser().logOut();


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
    public void kaydet(View view){
        ParseUser user=new ParseUser();
        user.setUsername(k_adi.getText().toString());
        user.setPassword(k_sifre.getText().toString());
        user.setEmail(mail.getText().toString());
        user.put("ad",adi.getText().toString());
        user.put("soyad",soyadi.getText().toString());
        user.put("dogumyili",d_yili.getText().toString());
        user.put("sehir",k_sehir.getText().toString());
        user.put("ilce",k_ilce.getText().toString());
        user.put("mevki",k_mevki.getText().toString());
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e!=null){
                    Toast.makeText(kayitol.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(kayitol.this, "Kayıt eklendi", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}