package ca.nevisco.outreach.ui.profile.skillset;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ca.nevisco.outreach.model.Skill;
import ca.nevisco.outreach.network.response.SkillsetResponse;
import ca.nevisco.outreach.repository.SkillsetRepository;

public class SkillsetViewModel extends ViewModel {

    private final MutableLiveData<String> errorMessageLiveData;

    private final MutableLiveData<Skill> skillMutableLiveData;
    private static final String TAG = SkillsetViewModel.class.getName();

    private final SkillsetRepository skillsetRepository;

    public SkillsetViewModel(Application application) {
        skillsetRepository = new SkillsetRepository(application);
        skillMutableLiveData = new MutableLiveData<>();
        errorMessageLiveData = new MutableLiveData<>();
    }


    public void getAllSkills(String token) {
        skillsetRepository.loadSkillsFromNetwork(token, new SkillsetRepository.ISkillsetResponse() {

            @Override
            public void onResponse(SkillsetResponse response) {
                Log.i(TAG, response.getSkill().size() + "");
            }

            @Override
            public void onFailure(Throwable throwable) {
                errorMessageLiveData.setValue(throwable.getLocalizedMessage());
            }
        });
    }

    public LiveData<List<Skill>> getAllSkills() {
        return skillsetRepository.getAllSkills();
    }
}
