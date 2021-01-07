package com.emrebisgun.hsrakipbul;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.List;

public class OyuncuEkle extends AppCompatActivity {

    EditText txtOyuncuEkle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyuncu_ekle);

        txtOyuncuEkle=findViewById(R.id.txtOyuncuEkle);
    }
    public void oyuncuBul(View view){
        ParseQuery<ParseObject> query=ParseQuery.getQuery("User");
        query.whereEqualTo("username",txtOyuncuEkle.getText().toString());
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e!=null){
                    e.printStackTrace();
                }else{
                    Toast.makeText(OyuncuEkle.this, "Bulundu", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    public void oyuncuEkle(View view){
        ParseQuery<ParseObject> query1=ParseQuery.getQuery("Takimlar");
        query1.whereEqualTo("username",ParseUser.getCurrentUser().getUsername());
        query1.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                ParseObject object=new ParseObject("Takimlar");
                object.put("oyuncu1",txtOyuncuEkle.getText().toString());
                object.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e!=null){
                            Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(),"Oyuncu eklendi" , Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });

    }
}