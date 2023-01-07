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
import ca.nevisco.outreach.network.response.SkillsetResponse;
import ca.nevisco.outreach.room.JobRoomDatabase;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillsetRepository {

    private final JobRoomDatabase db;
    private final SkillsetDao skillsetDao;

    private final SkillDao skillDao;

    public SkillsetRepository(Application application) {
        this.db = JobRoomDatabase.getInstance(application);
        this.skillsetDao = db.skillsetDao();
        this.skillDao = db.skillDao();
    }

    public void loadSkillsFromNetwork(String token, ISkillsetResponse skillResponse) {
        Call<SkillsetResponse> allSkillSet = ApiClient.getUserServiceWithToken(token).getAllSkillSet();

        allSkillSet.enqueue(new Callback<SkillsetResponse>() {

            @Override
            public void onResponse(@NonNull Call<SkillsetResponse> call, @NonNull Response<SkillsetResponse> response) {
                if (response.isSuccessful()) {

                    assert response.body() != null;
                    skillResponse.onResponse(response.body());
                    response.body().getSkill().forEach(skill -> {
                        insertSkill(skill);
                    });

                } else {
                    skillResponse.onFailure(new Throwable(response.message()));
                }
            }

            @Override
            public void onFailure(@Nullable Call<SkillsetResponse> call, @Nullable Throwable t) {
                skillResponse.onFailure(t);
            }
        });
    }

    public LiveData<List<Skill>> getAllSkills() {
        return skillDao.getAllSkills();
    }


    private void insertSkill(Skill... skill) {
        skillDao.insertSkill(skill);
    }


    public interface ISkillsetResponse {

        void onResponse(SkillsetResponse response);

        void onFailure(Throwable throwable);
    }
}
