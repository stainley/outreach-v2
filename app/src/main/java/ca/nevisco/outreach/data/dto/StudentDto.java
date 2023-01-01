package ca.nevisco.outreach.data.dto;


import com.google.gson.annotations.SerializedName;

import ca.nevisco.outreach.data.entity.EntityModel;

public class StudentDto implements EntityModel {

    private int id;
    @SerializedName("user_id")
    private int userId;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("contact_number")
    private String contactNumber;
    private int availability;
    private String email;
    private String link;
    private String about;
    private int international;
    private int collegeId;

}
