package ca.nevisco.outreach.data.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "SKILLS")
public class SkillEntity implements Serializable {

    @PrimaryKey
    private Long id;

}
