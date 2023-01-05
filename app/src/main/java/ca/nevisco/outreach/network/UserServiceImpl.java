package ca.nevisco.outreach.network;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.IOException;

import ca.nevisco.outreach.network.request.UserRequest;
import ca.nevisco.outreach.network.response.UserResponse;
import ca.nevisco.outreach.repository.UserRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserServiceImpl {

    private static final String TAG = UserServiceImpl.class.getName();
/*
    public void loginRemote(UserRequest request, UserRepository.ILoginResponse loginResponse) {
        Call<UserResponse> userResponseCall = ApiClient.getUserService().login(request);
        userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(@NonNull Call<UserResponse> call, @Nullable Response<UserResponse> response) {
                assert response != null;
                if (response.isSuccessful()) {
                    loginResponse.onResponse(response.body());
                } else {
                    loginResponse.onFailure(new Throwable(response.message()));
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                loginResponse.onFailure(t);
            }
        });
    }

    public interface ILoginResponse {
        void onResponse(UserResponse userResponse);

        void onFailure(Throwable t);
    }*/
}
