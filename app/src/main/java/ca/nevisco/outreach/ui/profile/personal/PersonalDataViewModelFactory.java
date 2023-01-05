package ca.nevisco.outreach.ui.profile.personal;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

@SuppressWarnings("unchecked")
public class PersonalDataViewModelFactory implements ViewModelProvider.Factory {

    private final Context context;

    public PersonalDataViewModelFactory(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        return (T) new PersonalDataViewModel(context);
    }
}
