package avans.wesselvrolijks.themoviedb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import avans.wesselvrolijks.themoviedb.entity.Movie;

public class DetailedActivity extends AppCompatActivity
{
    private ImageView fullImage;
    private TextView detailedTitle;
    private TextView detailedReleaseDate;
    private TextView description;
    private TextView voteAverage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_activity);

        Intent intent = getIntent();

        Movie movie = (Movie) intent.getSerializableExtra("movie");

        fullImage = findViewById(R.id.fullImage);
        detailedTitle = findViewById(R.id.detailedTitle);
        detailedReleaseDate = findViewById(R.id.detailedReleaseDate);
        description = findViewById(R.id.description);
        voteAverage = findViewById(R.id.voteAverage);

        Picasso.get()
                .load(movie.getImagePath())
                .fit()
                .centerCrop()
                .into(fullImage);

        detailedTitle.setText(movie.getTitle());
        detailedReleaseDate.setText(movie.getReleaseDate());
        description.setText(movie.getDescription());
        voteAverage.setText(movie.getVoteAverage());
    }
}
