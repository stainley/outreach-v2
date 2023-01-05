package ca.nevisco.outreach.ui.login;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ca.nevisco.outreach.network.request.UserRequest;
import ca.nevisco.outreach.network.response.UserResponse;
import ca.nevisco.outreach.repository.UserRepository;

public class LoginViewModel extends ViewModel {
    private static final String TAG = LoginViewModel.class.getName();
    private final MutableLiveData<UserResponse> userResponseData;
    private final UserRepository userRepository;
    private final MutableLiveData<String> errorResponseData;


    public LoginViewModel() {
        userResponseData = new MutableLiveData<>();
        errorResponseData = new MutableLiveData<>();
        userRepository = new UserRepository();
    }

    public LiveData<UserResponse> getUserResponseData() {
        Log.i(TAG, "getUserResponseData");
        return userResponseData;
    }

    public void login(UserRequest request) {
        userRepository.loginRemote(request, new UserRepository.ILoginResponse() {

            @Override
            public void onResponse(UserResponse userResponse) {
                userResponseData.postValue(userResponse);
            }

            @Override
            public void onFailure(Throwable t) {
                errorResponseData.postValue(t.getLocalizedMessage());
            }
        });
    }

    public LiveData<String> getErrorResponseData() {
        return errorResponseData;
    }
}
