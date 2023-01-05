package ca.nevisco.outreach.ui.profile;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;

import ca.nevisco.outreach.R;
import ca.nevisco.outreach.ui.profile.personal.PersonalDataFragment;
import ca.nevisco.outreach.ui.profile.skillset.SkillsetFragment;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Profile");
        }

        TabLayout tabMenuSkill = findViewById(R.id.tabMenuSkill);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_profile_container, new PersonalDataFragment()).commit();

        tabMenuSkill.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = new PersonalDataFragment();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                int position = tabMenuSkill.getSelectedTabPosition();

                switch (position) {
                    case 0:
                        fragment = new PersonalDataFragment();
                        break;
                    case 1:
                        fragment = new SkillsetFragment();
                        // TODO: add skillset
                        break;
                    default:
                        Log.e("", "Invalid option");
                }
                ft.replace(R.id.fragment_profile_container, fragment).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}