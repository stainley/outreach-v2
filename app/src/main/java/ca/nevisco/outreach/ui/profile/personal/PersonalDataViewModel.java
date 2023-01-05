package ca.nevisco.outreach.ui.profile.personal;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ca.nevisco.outreach.model.Student;
import ca.nevisco.outreach.network.response.ProfileResponse;
import ca.nevisco.outreach.repository.ProfileRepository;

public class PersonalDataViewModel extends ViewModel {

    private final MutableLiveData<String> errorMessageMutableLiveData;

    private final ProfileRepository profileRepository;

    public PersonalDataViewModel(@NonNull Context context) {
        this.profileRepository = new ProfileRepository(context);
        errorMessageMutableLiveData = new MutableLiveData<>();
    }

    public void fetchProfileInfo(String token, int studentId) {

        profileRepository.loginRemote(token, studentId, new ProfileRepository.IProfileResponse() {
            @Override
            public void onResponse(ProfileResponse profileResponse) {
            }

            @Override
            public void onFailure(Throwable t) {
                errorMessageMutableLiveData.setValue(t.getLocalizedMessage());
            }
        });
    }


    public LiveData<Student> getProfileResponseMutableLiveData() {
        return profileRepository.getStudentProfileInfo();
    }
}
