package ca.nevisco.outreach.repository;


import ca.nevisco.outreach.network.IUserService;
import ca.nevisco.outreach.network.request.UserRequest;
import ca.nevisco.outreach.network.response.UserResponse;

public class UserRepository {

    private final IUserService userService;

    public UserRepository() {
        userService = new IUserService();
    }

    public void loginRemote(UserRequest request, ILoginResponse loginResponse) {
        userService.loginRemote(request, loginResponse);
    }

    public interface ILoginResponse {
        void onResponse(UserResponse userResponse);

        void onFailure(Throwable t);
    }

}
