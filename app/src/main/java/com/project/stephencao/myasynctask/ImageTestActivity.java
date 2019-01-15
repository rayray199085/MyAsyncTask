package com.project.stephencao.myasynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class ImageTestActivity extends AppCompatActivity {
    private ImageView mImageView;
    private ProgressBar mProgressBar;
    private static final String IMAGE_PATH = "http://img.my.csdn.net/uploads/201504/12/1428806103_9476.png";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_test);
        initView();
        initEvent();
    }

    private void initEvent() {
       new MyAsyncTask().execute(IMAGE_PATH);
    }

    private void initView() {
        mImageView = findViewById(R.id.id_image_text_image);
        mProgressBar = findViewById(R.id.id_image_text_progress_bar);
    }

    class MyAsyncTask extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            String url = strings[0]; // get the Image path
            Bitmap bitmap = null;
            URLConnection urlConnection;
            InputStream inputStream = null;
            BufferedInputStream bufferedInputStream = null;
            try {
                urlConnection = new URL(url).openConnection();
                inputStream = urlConnection.getInputStream();
                bufferedInputStream = new BufferedInputStream(inputStream);
                Thread.sleep(3000);
                bitmap = BitmapFactory.decodeStream(bufferedInputStream);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            mProgressBar.setVisibility(View.GONE);
            mImageView.setImageBitmap(bitmap);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}
