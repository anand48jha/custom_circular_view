package com.libraryprojects.json_parsing.activity;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.libraryprojects.json_parsing.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class ImageLoaderActivity extends AppCompatActivity
{
    private ImageLoader imageLoader;
    private ImageView imageView;
    private  ProgressBar spinner;
    private String url="http://media1.santabanta.com/full1/Football/Lionel%20Messi/lionel-messi-33a.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader);
        getWidgets();
        getImageLoader();
    }
    private void getWidgets(){
        imageView=(ImageView) findViewById(R.id.image_iv);
        spinner=new ProgressBar(this);
        spinner.setIndeterminate(false);
//        spinner.set
        spinner.setEnabled(true);

    }
    private void getImageLoader(){
        imageLoader=ImageLoader.getInstance();
        imageLoader.init(new ImageLoaderConfiguration.Builder(getApplicationContext()).build());
        DisplayImageOptions options=new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true)
                .showImageOnFail(R.drawable.failed).imageScaleType(ImageScaleType.EXACTLY).build();
        imageLoader.displayImage(url,imageView,options,new SimpleImageLoadingListener(){
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                spinner.setVisibility(View.VISIBLE);
                super.onLoadingStarted(imageUri, view);

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                spinner.setVisibility(View.GONE);
                super.onLoadingFailed(imageUri, view, failReason);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                spinner.setVisibility(View.GONE);
                super.onLoadingComplete(imageUri, view, loadedImage);
            }
        });
    }
}
