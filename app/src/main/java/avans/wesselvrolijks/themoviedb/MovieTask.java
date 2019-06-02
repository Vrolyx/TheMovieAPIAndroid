package avans.wesselvrolijks.themoviedb;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import avans.wesselvrolijks.themoviedb.api.ApiConnector;
import avans.wesselvrolijks.themoviedb.entity.Movie;

public class MovieTask extends AsyncTask<String, String, String> {

    private OnMovieAvailable listener = null;

    private static final String TAG = MovieTask.class.getSimpleName();

    public MovieTask(OnMovieAvailable listener){
        this.listener = listener;
    }


    /**
     * Execute API call with name input
     *
     * @param params
     * @return
     */
    @Override
    protected String doInBackground(String... params) {
        return new ApiConnector().findByName(params[0]);
    }

    /**
     * Parse result from doInBackGround method
     *
     * @param response
     */
    protected void onPostExecute(String response)
    {
        Log.i(TAG, "API response: " + response);

        if(response.isEmpty())
        {
            Log.e(TAG, "Lege api response");
        }


        // Parse response to JSONObject
        try
        {

            JSONObject res = new JSONObject(response);

            JSONArray movies = res.getJSONArray("results");

            for( int index = 0; index < movies.length(); index ++)
            {

                // Parse elk resultaat naar een movie object
                JSONObject movie = movies.getJSONObject(index);

                String id = movie.getString("id");
                String title = movie.getString("original_title");
                String voteAverage = movie.getString("vote_average");
                String imagePath = getImagePath(200, movie.getString("poster_path"));
                String description = movie.getString("overview");
                String releaseDate = movie.getString("release_date");

                Movie m = new Movie(id, title, voteAverage, imagePath, description, releaseDate);

                Log.i(TAG, "Movie added: " + m.getTitle());

                listener.onMovieAvailable(m);
            }
        }

        // Catch parseError
        catch (JSONException ex) {
            Log.e(TAG, "JSONException tijdens het parsen van de response: " + ex.getLocalizedMessage());
        }
    }

    /**
     * Parse image from api to url
     *
     * @param size
     * @param id
     * @return
     */
    private String getImagePath(int size, String id)
    {
        return "https://image.tmdb.org/t/p/w" + size + "/" + id;
    }

    /**
     * Callback interface
     */
    public interface OnMovieAvailable
    {
        void onMovieAvailable(Movie movie);
    }
}
