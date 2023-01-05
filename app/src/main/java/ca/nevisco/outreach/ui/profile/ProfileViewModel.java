package ca.nevisco.outreach.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ca.nevisco.outreach.network.response.ProfileResponse;
import ca.nevisco.outreach.repository.ProfileRepository;

public class ProfileViewModel extends ViewModel {

    private final MutableLiveData<ProfileResponse> profileResponseMutableLiveData;
    private final MutableLiveData<String> errorMessageMutableLiveData;

    private final ProfileRepository profileRepository;

    public ProfileViewModel() {
        this.profileRepository = new ProfileRepository();
        profileResponseMutableLiveData = new MutableLiveData<>();
        errorMessageMutableLiveData = new MutableLiveData<>();
    }

    public void fetchProfileInfo(String token, int studentId) {

        profileRepository.loginRemote(token, studentId, new ProfileRepository.IProfileResponse() {
            @Override
            public void onResponse(ProfileResponse profileResponse) {
                profileResponseMutableLiveData.setValue(profileResponse);
            }

            @Override
            public void onFailure(Throwable t) {
                errorMessageMutableLiveData.setValue(t.getLocalizedMessage());
            }
        });
    }

    public LiveData<ProfileResponse> getProfileResponseMutableLiveData() {
        return profileResponseMutableLiveData;
    }

    public LiveData<String> getErrorMessageMutableLiveData() {
        return errorMessageMutableLiveData;
    }
}
