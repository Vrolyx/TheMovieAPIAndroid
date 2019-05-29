package avans.wesselvrolijks.themoviedb;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import avans.wesselvrolijks.themoviedb.api.ApiConnector;

public class MainActivity extends AppCompatActivity {

    private Button searchButton;
    private TextView searchInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable network comminucation
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        setContentView(R.layout.activity_main);

        searchButton = (Button) findViewById(R.id.searchButton);
        searchInput = (TextView) findViewById(R.id.textView);

        ApiConnector apic = new ApiConnector();

        // On button click, send entered text to api
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MovieTask().execute(searchInput.getText().toString());
            }
        });


    }
}
