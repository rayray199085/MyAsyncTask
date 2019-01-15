package com.project.stephencao.myasynctask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mImageTestButton;
    private Button mProgressBarTestButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        MyAsyncTask myAsyncTask = new MyAsyncTask();
//        myAsyncTask.execute();
        mImageTestButton = findViewById(R.id.id_main_to_image_test);
        mImageTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ImageTestActivity.class);
                startActivity(intent);
            }
        });
        mProgressBarTestButton = findViewById(R.id.id_main_to_progressbar_test);
        mProgressBarTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ProgressBarTestActivity.class);
                startActivity(intent);
            }
        });
    }
}
