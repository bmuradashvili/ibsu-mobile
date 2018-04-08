package ge.edu.ibsu.mobile.berdia.labwork7.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import ge.edu.ibsu.mobile.berdia.labwork7.R;
import ge.edu.ibsu.mobile.berdia.labwork7.fragments.DescriptionFragment;
import ge.edu.ibsu.mobile.berdia.labwork7.fragments.ImageFragment;
import ge.edu.ibsu.mobile.berdia.labwork7.fragments.OtherHeroesFragment;
import ge.edu.ibsu.mobile.berdia.labwork7.fragments.WebViewFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bDetails;
    private Button bImage;
    private Button bWebView;
    private Button bOtherHeroes;
    private FrameLayout fragmentPlaceholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewInit();
        eventListenerInit();

    }

    private void viewInit() {
        this.bDetails = findViewById(R.id.bDetails);
        this.bImage = findViewById(R.id.bImage);
        this.bWebView = findViewById(R.id.bWebView);
        this.bOtherHeroes = findViewById(R.id.bOtherHeroes);
        this.fragmentPlaceholder = findViewById(R.id.fragmentPlaceholder);
    }

    private void eventListenerInit() {
        this.bDetails.setOnClickListener(this);
        this.bImage.setOnClickListener(this);
        this.bWebView.setOnClickListener(this);
        this.bOtherHeroes.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bDetails:
                replacePlaceholder(DescriptionFragment.newInstance(getString(R.string.givi_description)));
                break;
            case R.id.bImage:
                replacePlaceholder(new ImageFragment());
                break;
            case R.id.bWebView:
                replacePlaceholder(WebViewFragment.newInstance("http://www.givisikharulidze.com/index.php?lang=geo"));
                break;
            case R.id.bOtherHeroes:
                replacePlaceholder(new OtherHeroesFragment());
                break;
        }
    }

    private void replacePlaceholder(Fragment fragmentInstance) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentPlaceholder, fragmentInstance);
        transaction.commit();
    }
}
