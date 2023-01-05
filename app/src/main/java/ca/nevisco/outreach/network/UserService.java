package ca.nevisco.outreach.network;

import ca.nevisco.outreach.network.request.UserRequest;
import ca.nevisco.outreach.network.response.UserResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService extends JobService {

    @POST(value = "/api/signin")
    Call<UserResponse> login(@Body UserRequest request);

    @POST(value = "/api/signup")
    Call<UserResponse> register(@Body UserRequest request);


}
