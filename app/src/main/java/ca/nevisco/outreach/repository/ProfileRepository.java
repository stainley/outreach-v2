package ca.nevisco.outreach.repository;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import ca.nevisco.outreach.dao.StudentDao;
import ca.nevisco.outreach.model.Student;
import ca.nevisco.outreach.network.ApiClient;
import ca.nevisco.outreach.network.response.ProfileResponse;
import ca.nevisco.outreach.room.JobRoomDatabase;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileRepository {

    private final StudentDao studentDao;
    private JobRoomDatabase db;
    private final LiveData<Student> studentLiveData;

    public ProfileRepository(Context application) {
        db = JobRoomDatabase.getInstance(application);
        studentDao = db.studentDao();

        studentLiveData = studentDao.getStudentInfo();
    }

    public LiveData<Student> getStudentProfileInfo() {
        return studentLiveData;
    }

    public void loginRemote(String token, int studentId, IProfileResponse response) {
        Call<ProfileResponse> studentInfo = ApiClient.getUserServiceWithToken(token).getStudentInfo(studentId);

        studentInfo.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(@NonNull Call<ProfileResponse> call, @NonNull Response<ProfileResponse> profileResponse) {

                if (profileResponse.isSuccessful()) {
                    response.onResponse(profileResponse.body());

                    assert profileResponse.body() != null;
                    studentDao.clearStudent();
                    insertProfileInfoDB(profileResponse.body());
                } else {
                    response.onFailure(new Throwable(profileResponse.message()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<ProfileResponse> call, @NonNull Throwable t) {
                response.onFailure(t);
            }
        });
    }

    public void insertProfileInfoDB(@NonNull ProfileResponse profileResponse) {
        studentDao.insert(profileResponse.getStudent());
    }

    public interface IProfileResponse {
        void onResponse(ProfileResponse profileResponse);

        void onFailure(Throwable t);
    }
}
