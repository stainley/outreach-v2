package ca.nevisco.outreach.repository;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import java.util.List;

import ca.nevisco.outreach.dao.SkillDao;
import ca.nevisco.outreach.dao.SkillsetDao;
import ca.nevisco.outreach.model.Skill;
import ca.nevisco.outreach.model.Skillset;
import ca.nevisco.outreach.network.ApiClient;
import ca.nevisco.outreach.network.request.SkillsetRequest;
import ca.nevisco.outreach.network.response.SkillResponse;
import ca.nevisco.outreach.network.response.SkillsetResponse;
import ca.nevisco.outreach.room.JobRoomDatabase;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillsetRepository {

    private final SkillsetDao skillsetDao;

    private final SkillDao skillDao;

    public SkillsetRepository(Application application) {
        JobRoomDatabase db = JobRoomDatabase.getInstance(application);
        this.skillsetDao = db.skillsetDao();
        this.skillDao = db.skillDao();
    }

    /**
     * Obtain all skills created by the admin in the server from the REST API
     *
     * @param token         Bearer Token from the server in the Auth
     * @param skillResponse @see SkillResponse
     */
    public void loadSkillsFromNetwork(String token, ISkillsetResponse skillResponse) {
        Call<SkillResponse> allSkillSet = ApiClient.getUserServiceWithToken(token).getAllSkillSet();

        allSkillSet.enqueue(new Callback<SkillResponse>() {

            @Override
            public void onResponse(@NonNull Call<SkillResponse> call, @NonNull Response<SkillResponse> response) {
                if (response.isSuccessful()) {

                    assert response.body() != null;
                    skillsetDao.clearSkillsetTable();
                    skillResponse.onResponse(response.body());
                    response.body().getSkill().forEach(skill -> insertSkill(skill));

                } else {
                    skillResponse.onFailure(new Throwable(response.message()));
                }
            }

            @Override
            public void onFailure(@Nullable Call<SkillResponse> call, @Nullable Throwable t) {
                skillResponse.onFailure(t);
            }
        });
    }

    /**
     * Add an skill to the profile REST Api
     *
     * @param token            Bearer Token obtained from the server in the Auth
     * @param skillsetRequest  @see SkillsetRequest
     * @param skillsetResponse @see SkillsetResponse
     */
    public void addSkillToMyProfileNetwork(String token, SkillsetRequest skillsetRequest, ISkillsetResponse skillsetResponse) {
        Call<SkillsetResponse> skillResponseCall = ApiClient.getUserServiceWithToken(token).addStudentSkillset(skillsetRequest);

        skillResponseCall.enqueue(new Callback<SkillsetResponse>() {
            @Override
            public void onResponse(@Nullable Call<SkillsetResponse> call, @NonNull Response<SkillsetResponse> response) {

                if (response.isSuccessful()) {
                    skillsetResponse.onResponse(response.body());
                    if (response.message().contains("successfully")) {
                        //
                        
                    }
                } else {
                    skillsetResponse.onFailure(new Throwable(response.message()));
                }
            }

            @Override
            public void onFailure(@Nullable Call<SkillsetResponse> call, @Nullable Throwable t) {
                skillsetResponse.onFailure(t);
            }
        });
    }

    public LiveData<List<Skill>> getAllSkills() {
        return skillDao.getAllSkills();
    }

    public LiveData<List<Skillset>> getAllMySkills() {
        return skillsetDao.getAllMySkills();
    }

    private void insertSkill(Skill... skill) {
        skillDao.insertSkill(skill);
    }

    public interface ISkillsetResponse {

        void onResponse(SkillsetResponse skillsetResponse);

        void onResponse(SkillResponse response);

        void onFailure(Throwable throwable);
    }
}
