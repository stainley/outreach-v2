package ca.nevisco.outreach.network.service;

import ca.nevisco.outreach.model.Job;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JobService {

    @GET(value = "/api/jobs")
    Call<Job> fetchAllJobs();
}
