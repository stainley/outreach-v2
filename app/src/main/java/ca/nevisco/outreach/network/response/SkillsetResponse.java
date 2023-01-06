package ca.nevisco.outreach.network.response;

import androidx.room.Embedded;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import ca.nevisco.outreach.model.Skill;
import ca.nevisco.outreach.model.Skillset;

public class SkillsetResponse {

    private boolean status;

    @SerializedName("skillset")
    @Embedded
    private List<Skill> skill;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Skill> getSkill() {
        return skill;
    }

    public void setSkill(List<Skill> skill) {
        this.skill = skill;
    }
}
