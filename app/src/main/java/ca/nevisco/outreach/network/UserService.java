package ca.nevisco.outreach.network;

import ca.nevisco.outreach.network.request.UserRequest;
import ca.nevisco.outreach.network.response.ProfileResponse;
import ca.nevisco.outreach.network.response.UserResponse;
import ca.nevisco.outreach.network.service.JobService;
import ca.nevisco.outreach.network.service.SkillsetService;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService extends SkillsetService, JobService {

    @POST(value = "/api/signin")
    Call<UserResponse> login(@Body UserRequest request);

    @POST(value = "/api/signup")
    Call<UserResponse> register(@Body UserRequest request);

    @GET(value = "api/student/{id}")
    Call<ProfileResponse> getStudentInfo(@Path(value = "id") long id);

}
