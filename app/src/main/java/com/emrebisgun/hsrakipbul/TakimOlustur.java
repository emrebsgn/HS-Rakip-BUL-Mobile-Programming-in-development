package com.emrebisgun.hsrakipbul;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class TakimOlustur extends AppCompatActivity {

    EditText txtTakim;
    EditText txtSehir;
    EditText txtIlce;
    EditText txtSahaAdi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takim_olustur);

        txtTakim=findViewById(R.id.txtTakim);
        txtSehir=findViewById(R.id.txtSehir);
        txtIlce=findViewById(R.id.txtIlce);
        txtSahaAdi=findViewById(R.id.txtSahaAdi);
    }
    public void takimolustur(View view){
        ParseObject object=new ParseObject("Takimlar");
        object.put("takim",txtTakim.getText().toString());
        object.put("saha_adi",txtSahaAdi.getText().toString());
        object.put("sehir",txtSehir.getText().toString());
        object.put("ilce",txtIlce.getText().toString());
        object.put("username", ParseUser.getCurrentUser().getUsername());

        object.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e!=null){
                    Toast.makeText(TakimOlustur.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(TakimOlustur.this, "Gönderi eklendi", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}