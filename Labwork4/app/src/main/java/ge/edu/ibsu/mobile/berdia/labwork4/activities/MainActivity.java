package ge.edu.ibsu.mobile.berdia.labwork4.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ge.edu.ibsu.mobile.berdia.labwork4.R;
import ge.edu.ibsu.mobile.berdia.labwork4.models.Person;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    public static final String MONTH_OF_BIRTH_TAG = "MOB";

    public static final String PERSON_TAG = "PERSON";

    public static final int CALCULATE_REQUEST_CODE = 407;

    private EditText etName;

    private EditText etSurname;

    private EditText etMonthOfBirth;

    private EditText etSeason;

    private EditText etFavouriteLecture;

    private Button bCalculate;

    private Button bDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewInit();
        eventListenerInit();
    }

    private void viewInit() {
        etName = findViewById(R.id.etName);
        etSurname = findViewById(R.id.etSurname);
        etMonthOfBirth = findViewById(R.id.etMonthOfBirth);
        etSeason = findViewById(R.id.etSeason);
        etFavouriteLecture = findViewById(R.id.etFavouriteLecture);
        bCalculate = findViewById(R.id.bCalculate);
        bDetails = findViewById(R.id.bDetails);
    }

    private void eventListenerInit() {
        bCalculate.setOnClickListener(this);
        bDetails.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bCalculate:
                bCalculateOnClick();
                break;
            case R.id.bDetails:
                bDetailsOnClick();
                break;
        }
    }

    private void bCalculateOnClick() {
        try {
            int mob = Integer.parseInt(etMonthOfBirth.getText().toString());

            if (mob < 1 || mob > 12)
                throw new NumberFormatException();

            Intent intent = new Intent(MainActivity.this, CalculateActivity.class);
            intent.putExtra(MONTH_OF_BIRTH_TAG, mob);
            startActivityForResult(intent, CALCULATE_REQUEST_CODE);
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Enter valid number in month of birth", Toast.LENGTH_LONG).show();
        }
    }

    private void bDetailsOnClick() {
        try {
            String name = getValue(etName);
            String surname = getValue(etSurname);
            int mob = Integer.parseInt(getValue(etMonthOfBirth));
            String season = getValue(etSeason);
            String favouriteLecture = getValue(etFavouriteLecture);

            if (mob < 1 || mob > 12)
                throw new NumberFormatException();

            Person p = new Person(name, surname, mob, season, favouriteLecture);

            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra(PERSON_TAG, p);
            startActivity(intent);
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Enter valid number in month of birth", Toast.LENGTH_LONG).show();
        }
    }

    private String getValue(EditText editText) {
        return editText.getText().toString();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CALCULATE_REQUEST_CODE) {
            switch (resultCode) {
                case RESULT_OK:
                    etSeason.setText(data.getStringExtra(CalculateActivity.SEASON_TAG));
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(MainActivity.this, "Cancelled", Toast.LENGTH_LONG).show();
                    break;
                default:
                    break;
            }

            Log.e(TAG, "onActivityResult: " + requestCode);
        }
    }
}
