package ge.edu.ibsu.mobile.berdia.labwork4.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ge.edu.ibsu.mobile.berdia.labwork4.R;

public class CalculateActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String SEASON_TAG = "SEASON";

    private Button bConfirm;

    private Button bCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        viewInit();
        eventListenerInit();
    }

    private void viewInit() {
        bConfirm = findViewById(R.id.bConfirm);
        bCancel = findViewById(R.id.bCancel);
    }

    private void eventListenerInit() {
        bConfirm.setOnClickListener(this);
        bCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bConfirm:
                bConfirmOnClick();
                break;
            case R.id.bCancel:
                bCancelOnClick();
                break;
        }
    }

    private void bConfirmOnClick() {
        int mob = getIntent().getIntExtra(MainActivity.MONTH_OF_BIRTH_TAG, 1);
        String season = "";
        Intent intent = new Intent(CalculateActivity.this, MainActivity.class);

        if (mob <= 2)
            season = "Winter";
        else if (mob <= 5)
            season = "Spring";
        else if (mob <= 8)
            season = "Summer";
        else if (mob <= 11)
            season = "Autumn";
        else
            season = "Winter";

        intent.putExtra(SEASON_TAG, season);

        setResult(RESULT_OK, intent);
        finish();
    }

    private void bCancelOnClick() {
        setResult(RESULT_CANCELED);
        finish();
    }
}
