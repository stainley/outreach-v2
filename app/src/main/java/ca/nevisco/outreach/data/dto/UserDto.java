package ca.nevisco.outreach.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ca.nevisco.outreach.data.entity.EntityModel;

public class UserDto implements EntityModel {

    private int id;
    private String email;

    @SerializedName("user_type_id")
    private int userTypeId;
    private int verified, enabled;

    @SerializedName("student")
    @Expose
    private StudentDto studentDto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public int getVerified() {
        return verified;
    }

    public void setVerified(int verified) {
        this.verified = verified;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public StudentDto getStudentDto() {
        return studentDto;
    }

    public void setStudentDto(StudentDto studentDto) {
        this.studentDto = studentDto;
    }
}
