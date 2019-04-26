package avans.wesselvrolijks.themoviedb.api;

import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by WesselVrolijks on 25/04/2019.
 */

public class ApiConnector {

    private String baseUrl = "https://api.themoviedb.org/3/movie/";
    private String apiKey = "3629693dbbddf2430cd50ef1344f9aad";
    private URLConnection request;

    public void ApiConnector()
    {
        this.connect(this.baseUrl, this.apiKey);
    }

    public void connect(String baseUrl, String apiKey)
    {
        // Combine baseurl and api key
        String nUrl = baseUrl + "api_key=" + apiKey;

        try {
            URL url = new URL(nUrl);
            URLConnection request = url.openConnection();
            this.request = request;
        }

        catch (MalformedURLException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JSONObject parseJson()
    {

    }
}
