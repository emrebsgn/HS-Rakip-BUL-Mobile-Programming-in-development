package com.emrebisgun.hsrakipbul;

import android.app.Activity;
import android.graphics.Bitmap;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PostClass extends ArrayAdapter<String> {
    private final ArrayList<String> username;
    private final ArrayList<String> userComment;
    private final ArrayList<Bitmap> userImage;
    private final Activity context;

    public PostClass(ArrayList<String> username,ArrayList<String> userComment,ArrayList<Bitmap> userImage,Activity context){
        //Hangi layout'u bağlamak istediğimizi belirttim. username'ye göre bağlama işlemi yaptırdım.
        super(context,R.layout.gonderi_gorunum,username);
        this.username=username;
        this.userComment=userComment;
        this.userImage=userImage;
        this.context=context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //gonderi_gorunumdeki textview,imageview alanlarına bu class sayesinde değerleri tek tek atayacağız.
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View gonderiGorunum=layoutInflater.inflate(R.layout.gonderi_gorunum,null,true);
        TextView userNameText=gonderiGorunum.findViewById(R.id.gonderı_usernameText);
        TextView userCommentText=gonderiGorunum.findViewById(R.id.gonderi_yorumText);
        ImageView imageView=gonderiGorunum.findViewById(R.id.gonderiImage);

        userNameText.setText(username.get(position));
        imageView.setImageBitmap(userImage.get(position));
        userCommentText.setText(userComment.get(position));




        return gonderiGorunum;
    }
}
