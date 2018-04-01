package ge.edu.ibsu.mobile.berdia.labwork6.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ge.edu.ibsu.mobile.berdia.labwork6.R;

/**
 * Created by rogel on 4/1/2018.
 */

public class CourseViewHolder extends RecyclerView.ViewHolder {

    public TextView tvCourseName;
    public TextView tvCourseGrade;

    public CourseViewHolder(View itemView) {
        super(itemView);

        this.tvCourseName = itemView.findViewById(R.id.tvCourseName);
        this.tvCourseGrade = itemView.findViewById(R.id.tvCourseGrade);
    }

}
