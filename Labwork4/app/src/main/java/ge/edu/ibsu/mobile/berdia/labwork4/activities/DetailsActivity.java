package ge.edu.ibsu.mobile.berdia.labwork4.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ge.edu.ibsu.mobile.berdia.labwork4.R;
import ge.edu.ibsu.mobile.berdia.labwork4.models.Person;

public class DetailsActivity extends AppCompatActivity {

    private TextView tvName;

    private TextView tvSurname;

    private TextView tvMonthOfBirth;

    private TextView tvSeason;

    private TextView tvFavouriteLecture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        viewInit();
        fillData();
    }

    private void viewInit() {
        tvName = findViewById(R.id.tvName);
        tvSurname = findViewById(R.id.tvSurname);
        tvMonthOfBirth = findViewById(R.id.tvMonthOfBirth);
        tvSeason = findViewById(R.id.tvSeason);
        tvFavouriteLecture = findViewById(R.id.tvFavouriteLecture);
    }

    private void fillData() {
        Person p = (Person) getIntent().getSerializableExtra(MainActivity.PERSON_TAG);

        tvName.setText(p.getName());
        tvSurname.setText(p.getSurname());
        tvMonthOfBirth.setText(p.getmonthOfBirth() + "");
        tvSeason.setText(p.getSeason());
        tvFavouriteLecture.setText(p.getFavouriteLecture());
    }
}
