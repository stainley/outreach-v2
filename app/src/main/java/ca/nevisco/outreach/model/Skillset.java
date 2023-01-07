package ca.nevisco.outreach.model;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.SerializedName;

import ca.nevisco.outreach.typeconverters.SkillsetConverter;

@Entity
public class Skillset {

    @PrimaryKey
    private int id;

    @Ignore
    private String name;

    @SerializedName("student_id")
    @ColumnInfo(name = "student_id")
    private int studentId;

    @SerializedName("skillset_id")
    @ColumnInfo(name = "skillset_id")
    private String skillsetId;

    @SerializedName("total_years_experience")
    @ColumnInfo(name = "total_year_experience")
    private String totalYearsExperience;
    @SerializedName("skill")
    @Embedded
    private Skill skill;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getSkillsetId() {
        return skillsetId;
    }

    public void setSkillsetId(String skillsetId) {
        this.skillsetId = skillsetId;
    }

    public String getTotalYearsExperience() {
        return totalYearsExperience;
    }

    public void setTotalYearsExperience(String totalYearsExperience) {
        this.totalYearsExperience = totalYearsExperience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
