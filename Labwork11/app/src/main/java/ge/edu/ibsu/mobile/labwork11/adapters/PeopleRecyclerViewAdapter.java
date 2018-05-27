package ge.edu.ibsu.mobile.labwork11.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ge.edu.ibsu.mobile.labwork11.R;
import ge.edu.ibsu.mobile.labwork11.models.Person;

public class PeopleRecyclerViewAdapter extends RecyclerView.Adapter<PeopleRecyclerViewAdapter.ViewHolder> {
    private List<Person> mPeopleList;
    private LayoutInflater mLayoutInflater;

    public PeopleRecyclerViewAdapter(Context context, List<Person> peopleList) {
        mLayoutInflater = LayoutInflater.from(context);
        mPeopleList = peopleList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowView = mLayoutInflater.inflate(R.layout.view_people_row, parent, false);
        return new ViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int resId = position % 2 == 0 ? R.color.overwatchOrange : R.color.overwatchBlue;
        holder.itemView.setBackgroundResource(resId);

        Person currentPerson = mPeopleList.get(position);
        holder.tvFirstName.setText(currentPerson.getFirstName());
        holder.tvLastName.setText(currentPerson.getLastName());
        holder.tvReason.setText(currentPerson.getReason());
    }

    @Override
    public int getItemCount() {
        return mPeopleList.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvFirstName;
        private TextView tvLastName;
        private TextView tvReason;

        ViewHolder(View itemView) {
            super(itemView);

            tvFirstName = itemView.findViewById(R.id.tvFirstName);
            tvLastName = itemView.findViewById(R.id.tvLastName);
            tvReason = itemView.findViewById(R.id.tvReason);
        }
    }
}
