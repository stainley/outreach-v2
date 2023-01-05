package ca.nevisco.outreach.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import ca.nevisco.outreach.MainActivity;
import ca.nevisco.outreach.databinding.ActivityLoginBinding;
import ca.nevisco.outreach.network.request.UserRequest;
import ca.nevisco.outreach.sharepref.UserSharePreference;
import ca.nevisco.outreach.ui.custom.CustomProgressDialog;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getName();
    ActivityLoginBinding binding;
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        binding.btnCompleteRegister.setOnClickListener(view -> loginUser(createRequest()));
    }

    private UserRequest createRequest() {
        UserRequest request = new UserRequest();
        request.setEmail(binding.txtEmailAddress.getText().toString());
        request.setPassword(binding.txtPassword.getText().toString());
        return request;
    }

    private void loginUser(UserRequest request) {
        Log.i(TAG, "Login to the API");
        final CustomProgressDialog customProgressDialog = new CustomProgressDialog(this);
        CustomProgressDialog.show(this, "Login", "Login", true, true);
        loginViewModel.login(request);

        loginViewModel.getUserResponseData().observe(this, userResponse -> {
            if (userResponse != null) {
                if (userResponse.getStatus().equals("true")) {
                    String token = userResponse.getToken();
                    int studentId = userResponse.getUser().getStudent().getId();

                    UserSharePreference userSharePreference = UserSharePreference.getInstance();
                    userSharePreference.persistSharePreference(this, "token", token);
                    userSharePreference.persistSharePreference(this, "id", studentId);
                    Log.i(TAG, token);

                    Intent intent = new Intent(getApplication(), MainActivity.class);
                    startActivity(intent);
                } else {
                    customProgressDialog.dismiss();
                    customProgressDialog.cancel();
                    Toast.makeText(getApplicationContext(), userResponse.getMessage(), Toast.LENGTH_LONG).show();
                }
            } else {
                customProgressDialog.cancel();
                customProgressDialog.dismiss();
                Toast.makeText(getApplicationContext(), "An error had occurred", Toast.LENGTH_LONG).show();
            }
        });

        loginViewModel.getErrorResponseData().observe(this, errorMessage -> {
            Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG).show();

            customProgressDialog.cancel();
            customProgressDialog.dismiss();
        });
    }
}