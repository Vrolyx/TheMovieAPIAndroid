package avans.wesselvrolijks.themoviedb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import avans.wesselvrolijks.themoviedb.entity.Movie;

public class MovieAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflator;
    private ArrayList movies;

    public MovieAdapter(Context ct, LayoutInflater li, ArrayList<Movie> movies)
    {
        mContext = ct;
        mInflator = li;
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void clearData() {
        movies.clear();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if(view == null){
            view = mInflator.inflate(R.layout.list_item, null);

            viewHolder = new ViewHolder();
            viewHolder.photoPreview = (ImageView) view.findViewById(R.id.photoPreview);
            viewHolder.movieTitle = (TextView) view.findViewById(R.id.movieTitle);
            viewHolder.releaseDate = (TextView) view.findViewById(R.id.releaseDate);

            view.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) view.getTag();
        }

        // Vul viewholder
        Movie movie = (Movie) movies.get(i);

        viewHolder.movieTitle.setText(movie.getTitle());
        viewHolder.releaseDate.setText(movie.getReleaseDate());

        // Parse image using the Picasso library
        Picasso.get()
                .load(movie.getImagePath())
                .resize(viewHolder.photoPreview.getLayoutParams().width, viewHolder.photoPreview.getLayoutParams().height)
                .centerCrop()
                .into(viewHolder.photoPreview);

        if (i %2 == 1)
        {
            view.setBackgroundColor(mContext.getResources().getColor(R.color.listPrimary));
        }
        else
        {
            view.setBackgroundColor(mContext.getResources().getColor(R.color.listSecondary));
        }

        return view;
    }

    private static class ViewHolder {
        public ImageView photoPreview;
        public TextView movieTitle;
        public TextView releaseDate;
    }
}
