package ge.edu.ibsu.mobile.berdia.labwork6.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import ge.edu.ibsu.mobile.berdia.labwork6.R;
import ge.edu.ibsu.mobile.berdia.labwork6.adapters.CoursesRecyclerViewAdapter;
import ge.edu.ibsu.mobile.berdia.labwork6.models.Course;

public class MainActivity extends AppCompatActivity {

    private CoursesRecyclerViewAdapter mAdapter;
    private RecyclerView rvCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewInit();
        loadCourses();

    }

    private void viewInit(){
        this.rvCourses = findViewById(R.id.rvCourses);
    }

    private void loadCourses(){
        ArrayList<Course> courseArrayList = new ArrayList<>();
        courseArrayList.add(new Course("Mobile Development", 100));
        courseArrayList.add(new Course("Statistics with Programming", 98));
        courseArrayList.add(new Course("Cloud Computing", 95));
        courseArrayList.add(new Course("Operating Systems", 97));
        courseArrayList.add(new Course("Introduction to Artificial Intelligence", 94));
        courseArrayList.add(new Course("Advanced Programming", 98));
        courseArrayList.add(new Course("Internship", 97));
        courseArrayList.add(new Course("Computer Graphics I", 100));
        courseArrayList.add(new Course("Discrete Mathematical Structures", 96));
        courseArrayList.add(new Course("Computer Architecture", 95));

        // set up the RecyclerView
        rvCourses.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new CoursesRecyclerViewAdapter(this, courseArrayList);
        rvCourses.setAdapter(mAdapter);
    }
}
