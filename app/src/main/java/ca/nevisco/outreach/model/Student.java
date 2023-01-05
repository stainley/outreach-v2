package ca.nevisco.outreach.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "STUDENTS")
public class Student {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "user_id")
    @SerializedName("user_id")
    @Expose
    private String userId;

    @ColumnInfo(name = "first_name")
    @SerializedName("first_name")
    @Expose
    private String firstName;

    @ColumnInfo(name = "last_name")
    @SerializedName("last_name")
    @Expose
    private String lastName;

    @ColumnInfo(name = "contact_number")
    @SerializedName("contact_number")
    @Expose
    private String contactNumber;

    private int availability;
    private String email;
    private String link;
    private String about;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}

