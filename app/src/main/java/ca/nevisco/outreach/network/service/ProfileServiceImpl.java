package ca.nevisco.outreach.network.service;

import ca.nevisco.outreach.network.ApiClient;
import ca.nevisco.outreach.network.response.ProfileResponse;
import ca.nevisco.outreach.repository.ProfileRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileServiceImpl {



    public void fetchProfileInfoFromNetwork(String token, int studentId, ProfileRepository.IProfileResponse response) {
        Call<ProfileResponse> studentInfo = ApiClient.getUserServiceWithToken(token).getStudentInfo(studentId);

        studentInfo.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> profileResponse) {

                if (profileResponse.isSuccessful()) {
                    response.onResponse(profileResponse.body());
                } else {
                    response.onFailure(new Throwable(profileResponse.message()));
                }
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                response.onFailure(t);
            }
        });
    }
}
