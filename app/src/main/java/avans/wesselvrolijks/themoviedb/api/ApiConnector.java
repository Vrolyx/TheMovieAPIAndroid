package avans.wesselvrolijks.themoviedb.api;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


/**
 * Created by WesselVrolijks on 25/04/2019.
 */

public class ApiConnector {

    private String authority = "api.themoviedb.org";
    private String apiVersion = "3";
    private String apiKey = "3629693dbbddf2430cd50ef1344f9aad";
    //private URLConnection request;

    public void ApiConnector()
    {

    }


    /**
     * Zoekt een film in de api op basis van naam.
     * @param name
     * @return
     */
    public String findByName(String name)
    {
        try {
            // Connect to url with build Url
            URL url = new URL(this.buildUrl(name).toString());
            URLConnection connection = url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();
            String line = "";

            while ((line = reader.readLine()) != null) {
                buffer.append(line+"\n");
                Log.d("Response: ", "> " + line); // Log response
            }

            return buffer.toString();
        }

        catch (MalformedURLException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Uri buildUrl(String name)
    {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority(authority)
                .appendPath(apiVersion)
                .appendPath("search")
                .appendPath("movie")
                .appendQueryParameter("api_key", apiKey)
                .appendQueryParameter("query", name);
        System.out.println(builder.build().toString());

        return builder.build();
    }
}
