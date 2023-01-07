package ca.nevisco.outreach.ui.profile.skillset;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ca.nevisco.outreach.R;
import ca.nevisco.outreach.databinding.FragmentSkillsetBinding;
import ca.nevisco.outreach.model.Skill;
import ca.nevisco.outreach.network.request.SkillsetRequest;
import ca.nevisco.outreach.sharepref.UserSharePreference;

public class SkillsetFragment extends Fragment {

    private List<Skill> skillsData = new ArrayList<>();
    final Skill[] skillsetDto = new Skill[1];
    private AutoCompleteTextView dropdownSkill;

    FragmentSkillsetBinding binding;
    SkillsetViewModel skillsetViewModel;
    SkillsetViewAdapter skillsetViewAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentSkillsetBinding.inflate(inflater, container, false);
        skillsetViewModel = new ViewModelProvider(this, new SkillsetViewModelFactory(requireActivity().getApplication())).get(SkillsetViewModel.class);
        dropdownSkill = binding.skillSetSpinner;

        getAllSkills();


        skillsetViewModel.getAllSkills().observe(getViewLifecycleOwner(), skill -> {
            if (skill != null) {
                skillsData.addAll(skill);
            }

        });

        ArrayAdapter<Skill> arrayAdapter = new ArrayAdapter<>(getContext(), R.layout.list_item, skillsData);

        dropdownSkill.setAdapter(arrayAdapter);

        RecyclerView recyclerView = new RecyclerView(requireContext());
        //skillsetViewAdapter = new SkillsetViewAdapter(skillsData);

        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 1));
        recyclerView.setAdapter(skillsetViewAdapter);

        onSkillSelected();

        binding.addSkillButton.setOnClickListener(viewButton -> {
            String year = binding.skillYearTxt.getText().toString();
            if (year.equals("") || dropdownSkill.getText().equals("")) {
                Toast.makeText(requireActivity(), "Could not be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            SkillsetRequest request = new SkillsetRequest(getUserId(), skillsetDto[0].getId(), Integer.parseInt(year));
            skillsetViewModel.addStudentSkillset(getToken(), request);

            arrayAdapter.notifyDataSetChanged();

        });

        return binding.getRoot();
    }



    private void onSkillSelected() {

        dropdownSkill.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(getContext(), "SELECTED: " + skillsData.get(position).getId(), Toast.LENGTH_SHORT).show();
            skillsetDto[0] = skillsData.get(position);
        });
    }

    public void getAllSkills() {
        skillsetViewModel.getAllSkills(getToken());
    }

    private String getToken() {
        Map<String, ?> sharedPref = UserSharePreference.getInstance().getSharePreference(requireContext());
        return String.valueOf(sharedPref.get("token"));
    }

    private int getUserId() {
        Map<String, ?> sharedPref = UserSharePreference.getInstance().getSharePreference(requireContext());
        return Integer.parseInt(String.valueOf(sharedPref.get("id")));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //skillsetViewModel.g



    }
}
