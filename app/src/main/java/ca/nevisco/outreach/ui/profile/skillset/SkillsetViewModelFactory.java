package ca.nevisco.outreach.ui.profile.skillset;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

@SuppressWarnings("unchecked")
public class SkillsetViewModelFactory implements ViewModelProvider.Factory {

    private final Application application;

    public SkillsetViewModelFactory(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        SkillsetViewModel viewModel = new SkillsetViewModel(application);

        return (T) viewModel;
    }
}
