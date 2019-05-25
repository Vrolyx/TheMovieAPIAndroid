package avans.wesselvrolijks.themoviedb;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import avans.wesselvrolijks.themoviedb.api.ApiConnector;

public class FetchMovieData extends AsyncTask<String, String, String> {

    private MainActivity mainActivity;

//    protected void onPreExecute() {
//        super.onPreExecute();
//
//        pd = new ProgressDialog(mainActivity);
//        pd.setMessage("Please wait");
//        pd.setCancelable(false);
//        pd.show();
//    }

    @Override
    protected String doInBackground(String... params) {
        return new ApiConnector().connect();
    }
}
