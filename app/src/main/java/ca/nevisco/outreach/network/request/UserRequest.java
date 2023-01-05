package ca.nevisco.outreach.network.request;

import com.google.gson.annotations.SerializedName;

public class UserRequest {
    private String email, password;
    @SerializedName("user_type_id")
    private int userTypeId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }
}
