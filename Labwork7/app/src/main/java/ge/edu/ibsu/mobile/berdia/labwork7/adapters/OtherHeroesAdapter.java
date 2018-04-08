package ge.edu.ibsu.mobile.berdia.labwork7.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ge.edu.ibsu.mobile.berdia.labwork7.R;

/**
 * Created by rogel on 4/8/2018.
 */

public class OtherHeroesAdapter extends RecyclerView.Adapter<OtherHeroesAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.other_heroes_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mName;
        private TextView mStrength;
        private TextView mWeakness;

        public ViewHolder(View itemView) {
            super(itemView);

            this.mName = itemView.findViewById(R.id.tvOtherHeroName);
            this.mStrength = itemView.findViewById(R.id.tvOtherHeroStrength);
            this.mWeakness = itemView.findViewById(R.id.tvOtherHeroWeakness);
        }
    }
}
