package com.emrebisgun.hsrakipbul;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.LogOutCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    EditText editTextName,editTextSifre; //Kullanıcı adı ve şifre girişi için editText lerimi tanımladım.



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*ParseUser parseUser=new ParseUser();
        if(parseUser!=null){
            Intent intent=new Intent(getApplicationContext(),Anasayfa.class);
            startActivity(intent);
        }*/

        editTextName=findViewById(R.id.editTextName); //Edit textlerimin ID tarafından görünümünü bulmasını sağladım.
        editTextSifre=findViewById(R.id.editTextSifre);

    }
    public void giris(View view){
        //Intent sınıfından bir obje oluştururken parametre olarak bulunduğım sınıftan gitmek istediğim sınıfı yazdım
        Intent intent=new Intent(MainActivity.this,Anasayfa.class);
        ParseUser.logInInBackground(editTextName.getText().toString(), editTextSifre.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e!=null){
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Hoşgeldin: "+editTextName.getText().toString(), Toast.LENGTH_SHORT).show();
                    startActivity(intent );
                }
            }
        });


















        /*if(editTextName.getText().toString().matches("emre")&&editTextSifre.getText().toString().matches("123")){
            //editText değerlerini if içinde belirlediğin değer ile karşılaştırıp doğru ise if bloku içine girecek.
            //Bu değerler şimdilik benim tarafımdan oluşturulmuştur fakat ParseUser veri tabanı kullanılarak dimanik bir şekilde erişim olcaktır.
            Toast.makeText(MainActivity.this,"Giriş Yapılıyor",Toast.LENGTH_LONG).show();
            //Giriş işlemi başarılı ise Toast mesaj ile kullanıcıya anlik olarak Giriş yapılıyor mesajı verdim.
            //ToasT mesajın parametreleri şu şekildedir, bulunduğun activity,vermek istediğin mesaj,mesajın app da kalma suresi.
            startActivity(intent);//Başta oluşturduğum parametrelerce Sayfalar arası geçiş yap.
        }
        else{
            //Şifre hatalı ise Kullanıcıya toast mesaj ile hatalı giriş yazdırdım.
            Toast.makeText(MainActivity.this,"Hatalı giriş!",Toast.LENGTH_LONG).show();
        }*/

    }
    public void kayit_ol(View view){
        Intent kayit_ol=new Intent(MainActivity.this,kayitol.class);
        //Kayıt butonuna basınca alertDiaolog yani yeni pencere içinde bu işlemi yapmak istiyor musun mesajı verdim.
        //Sağladığı Pozitif ve negatif butonlar ilede gerekli işlemler yaptım.
        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setTitle("Kayıt"); //Pencere başlığında yazılacak metin.
        alert.setMessage("Kayıt olmak istiyor musun?"); //Kullanıcıya sunduğu mesaj.
        alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() { //pozitif buton ,bu butona basınca kayıt ol'a gidecek.
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Kayıt ol'a gidiliyor!",Toast.LENGTH_LONG).show();
                startActivity(kayit_ol);
            }
        });
        alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() { //negatif buton,bu butona basınca giriş sayfasında kalmayada
                                                                                        //devam edecek.
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Giriş sayfası",Toast.LENGTH_LONG).show();
            }
        });
        alert.show();

    }
}