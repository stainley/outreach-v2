package ca.nevisco.outreach.model;

import com.google.gson.annotations.SerializedName;

public class Skillset {

    private int id;

    @SerializedName("student_id")
    private int studentId;

    @SerializedName("skillset_id")
    private String skillsetId;

    @SerializedName("total_years_experience")
    private String totalYearsExperience;

    private String name;

    @SerializedName("skill")
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
