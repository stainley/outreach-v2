package ca.nevisco.outreach.ui.profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.Map;

import ca.nevisco.outreach.databinding.FragmentProfileBinding;
import ca.nevisco.outreach.sharepref.UserSharePreference;

public class ProfileFragment extends Fragment {

    private static final String TAG = ProfileFragment.class.getName();

    FragmentProfileBinding binding;
    ProfileViewModel profileViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        profileViewModel = new ViewModelProvider(this, new ProfileViewModelFactory(requireContext())).get(ProfileViewModel.class);
        Map<String, ?> userSharePreference = UserSharePreference.getInstance().getSharePreference(requireContext());

        String token = String.valueOf(userSharePreference.get("token"));
        int studentId = (int) userSharePreference.get("id");
        // fetch data from the server
        profileViewModel.fetchProfileInfo(token, studentId);

        profileViewModel.getProfileResponseMutableLiveData().observe(getViewLifecycleOwner(), profileResponse -> {

            if (profileResponse != null) {
                Log.i(TAG, profileResponse.getEmail());
                binding.emailTxt.setText(profileResponse.getEmail());
                binding.firstNameTxt.setText(profileResponse.getFirstName());
                binding.lastNameTxt.setText(profileResponse.getLastName());
                binding.phoneTxt.setText(profileResponse.getContactNumber());
                binding.aboutTxt.setText(profileResponse.getAbout());
            }
        });


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editControl();
    }

    private void editControl() {
        binding.emailTxt.setEnabled(false);
    }
}
