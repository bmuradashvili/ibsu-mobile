package ge.edu.ibsu.mobile.berdia.labwork6.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ge.edu.ibsu.mobile.berdia.labwork6.R;
import ge.edu.ibsu.mobile.berdia.labwork6.activities.ProfileActivity;

/**
 * Created by rogel on 4/2/2018.
 */

public class BiographyFragment extends Fragment implements View.OnClickListener {

    private Button bFullInfo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_biography, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        bFullInfo = view.findViewById(R.id.bFullInfo);

        if (getActivity().getClass() == ProfileActivity.class) {
            bFullInfo.setVisibility(View.INVISIBLE);
        }

        bFullInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bFullInfo) {
            bFullInfoClick();
        }
    }

    private void bFullInfoClick() {
        Intent intent = new Intent(getActivity(), ProfileActivity.class);
        startActivity(intent);
    }
}
