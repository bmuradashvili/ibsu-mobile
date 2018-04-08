package ge.edu.ibsu.mobile.berdia.labwork7.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import ge.edu.ibsu.mobile.berdia.labwork7.R;

/**
 * Created by rogel on 4/7/2018.
 */

public class WebViewFragment extends Fragment {
    private WebView mContainer;
    private String url;

    public static WebViewFragment newInstance(String url) {
        WebViewFragment fragment = new WebViewFragment();
        Bundle args = new Bundle();
        args.putString("url", url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null)
            this.url = getArguments().getString("url");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_web_view, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mContainer = view.findViewById(R.id.wvContainer);
        WebSettings webSettings = mContainer.getSettings();
        webSettings.setJavaScriptEnabled(true);
        if (this.url != null)
            mContainer.loadUrl(this.url);
        else
            mContainer.loadUrl("http://www.imdb.com/name/nm0797705/");
    }
}
