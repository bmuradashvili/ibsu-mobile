package ge.edu.ibsu.mobile.labwork11.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ge.edu.ibsu.mobile.labwork11.R;
import ge.edu.ibsu.mobile.labwork11.adapters.PeopleRecyclerViewAdapter;
import ge.edu.ibsu.mobile.labwork11.models.Person;

public class PeopleFragment extends Fragment {
    private RecyclerView rvPeople;
    private List<Person> mPeopleList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fillPeople();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_people, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvPeople = view.findViewById(R.id.rvPeople);

        Context context = getActivity();
        PeopleRecyclerViewAdapter adapter = new PeopleRecyclerViewAdapter(context, mPeopleList);
        rvPeople.setLayoutManager(new LinearLayoutManager(context));
        rvPeople.setItemAnimator(new DefaultItemAnimator());
        rvPeople.setAdapter(adapter);
    }

    private void fillPeople() {
        mPeopleList = new ArrayList<>();

        mPeopleList.add(new Person("Doom", "Fist", "Doomfist’s cybernetics make him a highly-mobile, powerful frontline fighter."));
        mPeopleList.add(new Person("Pha", "Rah", "Soaring through the air in her combat armor, and armed with a launcher that lays down high-explosive rockets."));
        mPeopleList.add(new Person("Soldier", "76", "Armed with cutting-edge weaponry, including an experimental pulse rifle."));
        mPeopleList.add(new Person("Junk", "Rat", "Junkrat’s area-denying armaments include a Frag Launcher that lobs bouncing grenades."));
        mPeopleList.add(new Person("Road", "Hog", "Roadhog uses his signature Chain Hook to pull his enemies close before shredding them with his Scrap Gun."));
        mPeopleList.add(new Person("Bri", "gitte", "Brigitte specializes in armor."));
        mPeopleList.add(new Person("Mer", "Cy", "Mercy’s Valkyrie Suit helps keep her close to teammates like a guardian angel."));
        mPeopleList.add(new Person("Moi", "Ra", "Moira’s biotic abilities enable her to contribute healing or damage in any crisis."));
        mPeopleList.add(new Person("Reap", "er", "Hellfire Shotguns, the ghostly ability to become immune to damage."));
    }
}
