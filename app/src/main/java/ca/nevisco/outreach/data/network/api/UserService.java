package ca.nevisco.outreach.data.network.api;

import ca.nevisco.outreach.data.network.request.AbstractUserRequest;
import ca.nevisco.outreach.data.network.request.StudentUserRequest;
import ca.nevisco.outreach.network.response.UserResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

@Deprecated
public interface UserService {

    @POST(value = "api/signin")
    Call<UserResponse> login(@Body StudentUserRequest studentRequest);

    @POST(value = "api/signup")
    Call<UserResponse> register(@Body AbstractUserRequest userRequest);

}
