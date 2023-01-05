package ca.nevisco.outreach.repository;


import ca.nevisco.outreach.network.ApiClient;
import ca.nevisco.outreach.network.UserServiceImpl;
import ca.nevisco.outreach.network.request.UserRequest;
import ca.nevisco.outreach.network.response.UserResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private final UserServiceImpl userService;

    public UserRepository() {
        userService = new UserServiceImpl();
    }


   /* public MutableLiveData<UserResponse> loginUserFromNetwork(@NonNull UserRequest request, ILoginResponse loginResponse) {

        Thread thread = new Thread(() -> {
            UserResponse userResponse = userService.login(request);
            if (userResponse != null)
                userResponseMutableLiveData.postValue(userResponse);
        });
        thread.start();

        return userResponseMutableLiveData;
    }*/

    public void loginRemote(UserRequest request, ILoginResponse loginResponse) {
        Call<UserResponse> userResponseCall = ApiClient.getUserService().login(request);
        userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
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
    }

}
