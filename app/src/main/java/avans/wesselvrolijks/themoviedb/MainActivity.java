package avans.wesselvrolijks.themoviedb;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnHit;
    TextView txtJson;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        btnHit = (Button) findViewById(R.id.btnHit);
//        txtJson = (TextView) findViewById(R.id.movieItem);
//
//        btnHit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new FetchMovieData().execute();
//            }
//        });


    }
}
