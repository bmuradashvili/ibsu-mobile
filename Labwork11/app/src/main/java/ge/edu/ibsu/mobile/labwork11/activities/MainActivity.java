package ge.edu.ibsu.mobile.labwork11.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import ge.edu.ibsu.mobile.labwork11.R;
import ge.edu.ibsu.mobile.labwork11.fragments.EmailFragment;
import ge.edu.ibsu.mobile.labwork11.fragments.PeopleFragment;
import ge.edu.ibsu.mobile.labwork11.utils.SharedPreferenceUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String BUTTON_PEOPLE_LIST = "BUTTON_PEOPLE_LIST";
    private static final String BUTTON_EMAIL = "BUTTON_EMAIL";

    private Button bPeopleList;
    private Button bEmail;
    private FrameLayout fragmentPlaceholder;

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        bPeopleList = findViewById(R.id.bPeopleList);
        bEmail = findViewById(R.id.bEmail);
        fragmentPlaceholder = findViewById(R.id.fragmentPlaceholder);

        bPeopleList.setOnClickListener(this);
        bEmail.setOnClickListener(this);

        mFragmentManager = getSupportFragmentManager();
    }

    @Override
    public void onClick(View v) {
        int vId = v.getId();

        if (vId == bPeopleList.getId()) {
            bPeopleListClick();
        } else if (vId == bEmail.getId()) {
            bEmailClick();
        }
    }

    private void bPeopleListClick() {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(fragmentPlaceholder.getId(), new PeopleFragment());
        transaction.addToBackStack(BUTTON_PEOPLE_LIST);
        transaction.commit();
    }

    private void bEmailClick() {
        String email = SharedPreferenceUtils.getInstance(this).getString(LoginActivity.EMAIL_TAG);

        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(fragmentPlaceholder.getId(), EmailFragment.getInstance(email));
        transaction.addToBackStack(BUTTON_EMAIL);
        transaction.commit();
    }
}
