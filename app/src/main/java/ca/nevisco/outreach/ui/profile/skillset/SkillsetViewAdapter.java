package ca.nevisco.outreach.ui.profile.skillset;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ca.nevisco.outreach.R;
import ca.nevisco.outreach.model.Skillset;

public class SkillsetViewAdapter extends RecyclerView.Adapter<SkillsetViewAdapter.SkillViewHolder> {

    private final List<Skillset> skillset;

    public SkillsetViewAdapter(List<Skillset> skillset) {
        this.skillset = skillset;
    }

    @NonNull
    @Override
    public SkillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_skillset, parent, false);

        return new SkillViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillViewHolder holder, int position) {

        holder.skillNameTxt.setText(skillset.get(position).getSkill().getName());
        holder.skillYearTxt.setText(skillset.get(position).getTotalYearsExperience());
    }

    @Override
    public int getItemCount() {
        return skillset.size();
    }

    static class SkillViewHolder extends RecyclerView.ViewHolder {
        private final AppCompatTextView skillNameTxt;
        private final AppCompatTextView skillYearTxt;

        public SkillViewHolder(@NonNull View itemView) {
            super(itemView);
            skillNameTxt = itemView.findViewById(R.id.skill_name);
            skillYearTxt = itemView.findViewById(R.id.skill_year);
        }
    }
}
