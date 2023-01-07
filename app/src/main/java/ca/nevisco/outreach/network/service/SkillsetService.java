package ca.nevisco.outreach.network.service;

import ca.nevisco.outreach.model.Skillset;
import ca.nevisco.outreach.network.request.SkillsetRequest;
import ca.nevisco.outreach.network.response.SkillResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SkillsetService {

    /**
     * Get all skills
     *
     * @return SkillResponse
     */
    @GET(value = "api/skillset")
    Call<SkillResponse> getAllSkillSet();

    @POST(value = "api/studentSkillset")
    Call<SkillResponse> addStudentSkillset(@Body SkillsetRequest request);

    @DELETE(value = "api/studentSkillset/{student_skillset_id}")
    Call<SkillResponse> deleteStudentSkillset(@Path(value = "student_skillset_id") long skillsetId);

}
