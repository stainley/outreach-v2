package ca.nevisco.outreach.repository;

import ca.nevisco.outreach.network.response.ProfileResponse;
import ca.nevisco.outreach.network.service.ProfileServiceImpl;

public class ProfileRepository {

    private final ProfileServiceImpl profileService;

    public ProfileRepository() {
        this.profileService = new ProfileServiceImpl();
    }

    public void loginRemote(String token, int studentId, IProfileResponse profileResponse) {
        this.profileService.fetchProfileInfoFromNetwork(token, studentId, profileResponse);
    }

    public interface IProfileResponse {
        void onResponse(ProfileResponse profileResponse);

        void onFailure(Throwable t);
    }
}
