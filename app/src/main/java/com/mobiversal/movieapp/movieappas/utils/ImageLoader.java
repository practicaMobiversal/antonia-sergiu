package com.mobiversal.movieapp.movieappas.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageLoader {
    public static  void loadUrl(ImageView imageview, String url, Context context){
        Glide.with(context).load(url).into(imageview);


    }
}
