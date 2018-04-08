package ge.edu.ibsu.mobile.berdia.labwork7.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import ge.edu.ibsu.mobile.berdia.labwork7.activities.FullDescriptionActivity;
import ge.edu.ibsu.mobile.berdia.labwork7.R;

/**
 * Created by rogel on 4/7/2018.
 */

public class DescriptionFragment extends Fragment implements View.OnClickListener {
    private TextView tvFullInfo;
    private Button bShareInfo;
    private Button bViewAll;
    private String description;

    public static DescriptionFragment newInstance(String description) {
        DescriptionFragment fragment = new DescriptionFragment();
        Bundle args = new Bundle();
        args.putString("description", description);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null)
            this.description = getArguments().getString("description", "");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_description, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewInit(view);

        if (this.description != null) {
            tvFullInfo.setText(this.description);
        } else {
            bViewAll.setVisibility(View.GONE);
            bShareInfo.setVisibility(View.GONE);
        }


        eventListenerInit();
    }

    private void viewInit(View view) {
        this.tvFullInfo = view.findViewById(R.id.tvFullInfo);
        this.bShareInfo = view.findViewById(R.id.bShareInfo);
        this.bViewAll = view.findViewById(R.id.bViewAll);
    }

    private void eventListenerInit() {
        this.bShareInfo.setOnClickListener(this);
        this.bViewAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        if (viewId == R.id.bShareInfo)
            bShareClick();
        else if (viewId == R.id.bViewAll)
            bViewAllClick();
    }

    private void bShareClick() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, this.description);
        intent.setType("text/plain");
        startActivity(intent);
    }

    private void bViewAllClick() {
        Intent intent = new Intent(getActivity(), FullDescriptionActivity.class);

        startActivity(intent);
    }
}
