package ge.edu.ibsu.mobile.berdia.labwork6.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ge.edu.ibsu.mobile.berdia.labwork6.R;
import ge.edu.ibsu.mobile.berdia.labwork6.models.Course;
import ge.edu.ibsu.mobile.berdia.labwork6.viewholders.CourseViewHolder;

/**
 * Created by rogel on 4/1/2018.
 */

public class CoursesRecyclerViewAdapter extends RecyclerView.Adapter<CourseViewHolder> {

    private List<Course> mCourses;
    private LayoutInflater mInflater;

    public CoursesRecyclerViewAdapter(Context context, List<Course> mCourses) {
        this.mInflater = LayoutInflater.from(context);
        this.mCourses = mCourses;
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.course_list_row, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {
        Course course = mCourses.get(position);
        holder.tvCourseName.setText(course.getName());
        holder.tvCourseGrade.setText(String.valueOf(course.getGrade()));
    }

    @Override
    public int getItemCount() {
        return mCourses.size();
    }
}
