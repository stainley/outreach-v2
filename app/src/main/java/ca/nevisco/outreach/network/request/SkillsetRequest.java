package ca.nevisco.outreach.network.request;

import com.google.gson.annotations.SerializedName;

public class SkillsetRequest {

    @SerializedName("student_id")
    private final int studentId;
    @SerializedName("skillset_id")
    private final int skillsetId;
    @SerializedName("total_years_experience")
    private final int totalYearsExperience;

    public SkillsetRequest(int studentId, int skillsetId, int totalYearsExperience) {
        this.studentId = studentId;
        this.skillsetId = skillsetId;
        this.totalYearsExperience = totalYearsExperience;
    }

    public int getStudentId() {
        return studentId;
    }


    public int getSkillsetId() {
        return skillsetId;
    }

    public int getTotalYearsExperience() {
        return totalYearsExperience;
    }


}
