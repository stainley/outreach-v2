package ca.nevisco.outreach.network;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import ca.nevisco.outreach.network.request.UserRequest;
import ca.nevisco.outreach.network.response.UserResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserServiceImpl {

    private static final String TAG = UserServiceImpl.class.getName();

    public UserResponse login(UserRequest request) {
        Call<UserResponse> userResponseCall = ApiClient.getUserService().login(request);
        final UserResponse[] userResponse = new UserResponse[1];

        try {
            Response<UserResponse> execute = userResponseCall.execute();

            return execute.body();

        } catch (IOException e) {
            Log.e(TAG, e.getLocalizedMessage());
            throw new RuntimeException(e.getLocalizedMessage());
        }

        /*userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                if (response.isSuccessful()) {
                    assert response.body() != null;
                    if (response.body().getStatus().equals("true")) {

                        userResponse[0] = response.body();
                    }
                } else {
                    JSONObject errorMessageJSON;
                    try {
                        String errorResponse = response.errorBody().string();
                        errorMessageJSON = new JSONObject(errorResponse);

                        userResponse[0].setMessage(String.valueOf(errorMessageJSON.get("message")));
                    } catch (JSONException | IOException e) {
                        Log.e(TAG, e.getMessage());
                    }

                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.e(TAG, t.getLocalizedMessage());
            }
        });

        return userResponse[0];*/
    }
}
