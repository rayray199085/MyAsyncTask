package com.project.stephencao.myasynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

public class ProgressBarTestActivity extends AppCompatActivity {
    private ProgressBar mProgressBar;
    private MyAsyncTask mMyAsyncTask;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar_test);
        mProgressBar = findViewById(R.id.id_progress_bar_pb);
        mProgressBar.setMax(100);
        mMyAsyncTask = new MyAsyncTask();
        mMyAsyncTask.execute();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mMyAsyncTask!=null && mMyAsyncTask.getStatus()== AsyncTask.Status.RUNNING){
            // request to cancel asyncTask, but not actually cancel it, just mark it cancel
            mMyAsyncTask.cancel(true);
        }
    }

    class MyAsyncTask extends AsyncTask<Void,Integer,Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for(int i = 1; i <= 100; i++){
                if(isCancelled()){ // check the status, whether or not it is going to be cancelled
                    break;
                }
                publishProgress(i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            if(isCancelled()){
                return;
            }
            mProgressBar.setProgress(values[0]);
        }
    }
}
