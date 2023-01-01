package ca.nevisco.outreach.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ca.nevisco.outreach.data.dto.StudentDto;

@Entity(tableName = "USERS")
public class UserEntity {

    @PrimaryKey
    private int id;

    private String email;

    @ColumnInfo(name = "user_type_id")
    private int userTypeId;

    private int verified, enabled;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
