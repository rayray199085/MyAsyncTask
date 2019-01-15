package com.project.stephencao.myasynctask;

import android.os.AsyncTask;
import android.util.Log;

/**
 *  execution order
 *
 *  1. onPreExecute (initialize params)
 *
 *  2. doInBackground
 *     call publishProgress (progress values) -->  onProgressUpdate,  (update progress bar)
 *
 *  3. onPostExecute
 */
public class MyAsyncTask extends AsyncTask<Void, Void, Void> {
    @Override
    protected Void doInBackground(Void... voids) {
        Log.i("xiaohema", "doinbackground");
        publishProgress();
        return null;
    }

    @Override
    protected void onPreExecute() {
        Log.i("xiaohema", "onPreExecute");
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        Log.i("xiaohema", "onPostExecute");
        super.onPostExecute(aVoid);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        Log.i("xiaohema", "onProgressUpdate");
        super.onProgressUpdate(values);
    }
}
