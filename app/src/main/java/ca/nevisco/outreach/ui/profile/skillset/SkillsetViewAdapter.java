package ca.nevisco.outreach.ui.profile.skillset;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ca.nevisco.outreach.R;

public class SkillsetViewAdapter extends RecyclerView.Adapter<SkillsetViewAdapter.SkillViewHolder> {

    private final List<?> skillset;

    public SkillsetViewAdapter(List<?> skillset) {
        this.skillset = skillset;
    }

    @NonNull
    @Override
    public SkillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_skillset, parent, false);

        return new SkillViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return skillset.size();
    }

    static class SkillViewHolder extends RecyclerView.ViewHolder {

        public SkillViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
