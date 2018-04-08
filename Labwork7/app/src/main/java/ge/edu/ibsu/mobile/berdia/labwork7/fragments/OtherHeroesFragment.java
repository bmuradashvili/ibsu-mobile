package ge.edu.ibsu.mobile.berdia.labwork7.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ge.edu.ibsu.mobile.berdia.labwork7.R;
import ge.edu.ibsu.mobile.berdia.labwork7.adapters.OtherHeroesAdapter;

/**
 * Created by rogel on 4/7/2018.
 */

public class OtherHeroesFragment extends Fragment {
    private RecyclerView mOtherHeores;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_other_heroes, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        OtherHeroesAdapter adapter = new OtherHeroesAdapter();
        mOtherHeores = view.findViewById(R.id.rvOtherHeroesContainer);
        mOtherHeores.setLayoutManager(new LinearLayoutManager(getActivity()));
        mOtherHeores.setItemAnimator(new DefaultItemAnimator());
        mOtherHeores.setAdapter(adapter);
    }
}
