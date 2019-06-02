package avans.wesselvrolijks.themoviedb;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import avans.wesselvrolijks.themoviedb.entity.Movie;

public class MainActivity extends AppCompatActivity implements MovieTask.OnMovieAvailable {

    // Data objects
    private ArrayList<Movie> movies;
    private MovieAdapter movieAdapter;

    // UI Elements
    private Button searchButton;
    private TextView searchInput;
    private ListView movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable network communication
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        movies = new ArrayList<>();

        setContentView(R.layout.activity_main);

        // Inflate UI
        searchButton = (Button) findViewById(R.id.searchButton);
        searchInput = (TextView) findViewById(R.id.textView);
        movieList = (ListView) findViewById(R.id.movieList);

        // Implement adapter
        movieAdapter = new MovieAdapter(
                getApplicationContext(),
                getLayoutInflater(),
                movies
        );
        movieList.setAdapter(movieAdapter);

        // On button click, send entered text to api
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItems(searchInput.getText().toString());
            }
        });

        movieList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), DetailedActivity.class);
                intent.putExtra("movie", movies.get(i));
                startActivity(intent);
            }
        });

    }

    private void addItems(String name)
    {
        movieAdapter.clearData();
        movieAdapter.notifyDataSetChanged();

        MovieTask movieTask = new MovieTask(this, this);
        movieTask.execute(name);
    }

    @Override
    public void onMovieAvailable(Movie movie) {
        movies.add(movie);
        movieAdapter.notifyDataSetChanged();
    }
}
