package ca.nevisco.outreach.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ca.nevisco.outreach.model.User;

public class UserResponse {
    private int id;
    private String token;
    private String status;
    private String message;

    @SerializedName("user")
    @Expose
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
