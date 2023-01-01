package ca.nevisco.outreach.data.network.response;

import com.google.gson.annotations.SerializedName;

import ca.nevisco.outreach.data.dto.UserDto;

public class UserResponse {

    private boolean status;
    private String message;
    private String token;

    @SerializedName("user")
    private UserDto userDto;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
