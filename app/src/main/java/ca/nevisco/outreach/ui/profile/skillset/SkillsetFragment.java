package ca.nevisco.outreach.ui.profile.skillset;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

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
import ca.nevisco.outreach.sharepref.UserSharePreference;

public class SkillsetFragment extends Fragment {

    FragmentSkillsetBinding binding;
    SkillsetViewModel skillsetViewModel;
    SkillsetViewAdapter skillsetViewAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentSkillsetBinding.inflate(inflater, container, false);
        skillsetViewModel = new ViewModelProvider(this, new SkillsetViewModelFactory(requireActivity().getApplication())).get(SkillsetViewModel.class);


        getAllSkills();

        List<Skill> skillsData = new ArrayList<>();

        skillsetViewModel.getAllSkills().observe(getViewLifecycleOwner(), skill -> {
            if (skill != null) {
                skillsData.addAll(skill);
            }

        });

        ArrayAdapter<Skill> arrayAdapter = new ArrayAdapter<>(getContext(), R.layout.list_item, skillsData);

        binding.skillSetSpinner.setAdapter(arrayAdapter);

        RecyclerView recyclerView = new RecyclerView(requireContext());
        //skillsetViewAdapter = new SkillsetViewAdapter(skillsData);

        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 1));
        recyclerView.setAdapter(skillsetViewAdapter);
        return binding.getRoot();
    }

    public void getAllSkills() {
        skillsetViewModel.getAllSkills(getToken());
    }

    private String getToken() {
        Map<String, ?> sharedPref = UserSharePreference.getInstance().getSharePreference(requireContext());
        return String.valueOf(sharedPref.get("token"));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}
