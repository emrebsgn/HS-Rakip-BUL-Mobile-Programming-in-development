package com.emrebisgun.hsrakipbul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.LogOutCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class Gonderiler extends AppCompatActivity {

    ListView listview;
    ArrayList<String> usernamesFromParse;
    ArrayList<String> userCommentsFromParse;
    ArrayList<Bitmap> userImageFromParse;
    PostClass postClass;
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
                        Toast.makeText(Gonderiler.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
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
        setContentView(R.layout.activity_gonderiler);

        listview=findViewById(R.id.listview);
        usernamesFromParse=new ArrayList<>();
        userCommentsFromParse=new ArrayList<>();
        userImageFromParse=new ArrayList<>();

        //ArrayAdatperdan miras alan postClassımızın constructer yardımı ile değerlerini girdik.
        postClass=new PostClass(usernamesFromParse,userCommentsFromParse,userImageFromParse,this);
        //postClass taki verileri postClass'a aktardık.
        listview.setAdapter(postClass);

        download();
    }
    public void download(){
        ParseQuery<ParseObject> query=ParseQuery.getQuery("Gonderiler");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e!=null){
                    Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }else{
                    //Hata mesajı yoksa yapılacak olan işlemler.
                    if(objects.size()>0){
                        //Geriye alabildildiğimiz bir obje var mı? var ise yapılacak işlemler.
                        for(ParseObject object:objects){
                            //görseli almak için önce ParseFile sınıfından nesne oluşturdum.
                            ParseFile parseFile=(ParseFile) object.get("gorsel");

                            parseFile.getDataInBackground(new GetDataCallback() {
                                @Override
                                public void done(byte[] data, ParseException e) {
                                    if(e==null&& data!=null){
                                        Bitmap bitmap= BitmapFactory.decodeByteArray(data,0,data.length);

                                        userImageFromParse.add(bitmap);
                                        usernamesFromParse.add(object.getString("username"));
                                        userCommentsFromParse.add(object.getString("aciklama"));

                                        postClass.notifyDataSetChanged();
                                    }
                                }
                            });

                        }
                    }
                }
            }
        });

    }
}