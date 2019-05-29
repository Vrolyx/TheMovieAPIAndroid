package avans.wesselvrolijks.themoviedb.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by WesselVrolijks on 25/04/2019.
 */

public class Movie {

    private String id;
    private String title;
    private String voteAverage;
    private String imagePath;
    private String description;
    private SimpleDateFormat releaseDate;

    public Movie(String id, String title, String voteAverage, String imagePath, String description, SimpleDateFormat releaseDate) {
        this.id = id;
        this.title = title;
        this.voteAverage = voteAverage;
        this.imagePath = imagePath;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getDescription() {
        return description;
    }

    public SimpleDateFormat getReleaseDate() {
        return releaseDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseDate(SimpleDateFormat releaseDate) {
        this.releaseDate = releaseDate;
    }
}

