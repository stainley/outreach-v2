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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ca.nevisco.outreach.R;
import ca.nevisco.outreach.databinding.FragmentSkillsetBinding;
import ca.nevisco.outreach.model.Skill;
import ca.nevisco.outreach.network.request.SkillsetRequest;
import ca.nevisco.outreach.sharepref.UserSharePreference;

public class SkillsetFragment extends Fragment {

    private final List<Skill> skillsData = new ArrayList<>();
    final Skill[] skillsetDto = new Skill[1];
    private AutoCompleteTextView dropdownSkill;
    FragmentSkillsetBinding binding;
    SkillsetViewModel skillsetViewModel;
    SkillsetViewAdapter skillsetViewAdapter;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentSkillsetBinding.inflate(inflater, container, false);
        skillsetViewModel = new ViewModelProvider(this, new SkillsetViewModelFactory(requireActivity().getApplication())).get(SkillsetViewModel.class);
        dropdownSkill = binding.skillSetSpinner;
        recyclerView = binding.skillRecycleView;

        getAllSkills();


        skillsetViewModel.getAllSkills().observe(getViewLifecycleOwner(), skill -> {
            if (skill != null) {
                skillsData.addAll(skill);
            }

        });

        ArrayAdapter<Skill> arrayAdapter = new ArrayAdapter<>(getContext(), R.layout.list_item, skillsData);
        dropdownSkill.setAdapter(arrayAdapter);

        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 1));

        onSkillSelected();

        binding.addSkillButton.setOnClickListener(viewButton -> {
            String year = binding.skillYearTxt.getText().toString();
            if (year.equals("") || dropdownSkill.getText().toString().equals("")) {
                Toast.makeText(requireActivity(), "Could not be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            SkillsetRequest request = new SkillsetRequest(getUserId(), skillsetDto[0].getId(), Integer.parseInt(year));
            skillsetViewModel.addNewSkill(getToken(), request);

            arrayAdapter.notifyDataSetChanged();
            clearField();

        });
        return binding.getRoot();
    }

    private void clearField() {
        binding.skillSetSpinner.setText("");
        binding.skillYearTxt.setText("");
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

        skillsetViewModel.getAllMySkills().observe(requireActivity(), skillsets -> {
            if (skillsets.size() > 0) {
                skillsetViewAdapter = new SkillsetViewAdapter(skillsets);
                recyclerView.setAdapter(skillsetViewAdapter);
                skillsetViewAdapter.notifyItemRangeChanged(0, skillsets.size());
            }

        });

        skillsetViewModel.getServiceResponseMessage().observe(getViewLifecycleOwner(), responseMessage -> {
            Toast.makeText(getContext(), responseMessage, Toast.LENGTH_LONG).show();
            if (responseMessage.contains("successfully")) {
                // TODO: Add to the list the new skill and 2 year
                skillsetViewAdapter.notifyDataSetChanged();
            }
        });

    }
}
