package ca.nevisco.outreach.ui.profile;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ca.nevisco.outreach.model.Student;
import ca.nevisco.outreach.network.response.ProfileResponse;
import ca.nevisco.outreach.repository.ProfileRepository;

public class ProfileViewModel extends ViewModel {

    private final MutableLiveData<Student> profileResponseMutableLiveData;
    private final MutableLiveData<String> errorMessageMutableLiveData;

    private final ProfileRepository profileRepository;

    private final MutableLiveData<Student> studentLiveData;

    public ProfileViewModel(@NonNull Context context) {
        this.profileRepository = new ProfileRepository(context);
        profileResponseMutableLiveData = new MutableLiveData<>();
        errorMessageMutableLiveData = new MutableLiveData<>();
        studentLiveData = new MutableLiveData<>();
    }

    public void fetchProfileInfo(String token, int studentId) {

        profileRepository.loginRemote(token, studentId, new ProfileRepository.IProfileResponse() {
            @Override
            public void onResponse(ProfileResponse profileResponse) {
                //profileResponseMutableLiveData.setValue(profileResponse);
            }

            @Override
            public void onFailure(Throwable t) {
                //errorMessageMutableLiveData.setValue(t.getLocalizedMessage());
            }
        });


    }

    public void getStudentInfo() {

    }


    public LiveData<Student> getProfileResponseMutableLiveData() {
        return profileRepository.getStudentProfileInfo();
    }

    public LiveData<String> getErrorMessageMutableLiveData() {
        return errorMessageMutableLiveData;
    }
}
