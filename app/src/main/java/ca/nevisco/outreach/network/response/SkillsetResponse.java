package ca.nevisco.outreach.network.response;

import com.google.gson.annotations.SerializedName;

import ca.nevisco.outreach.model.Skillset;

public class SkillsetResponse {
    private boolean status;
    private String message;

    @SerializedName("skillset")
    private Skillset skillset;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Skillset getSkillset() {
        return skillset;
    }

    public void setSkillset(Skillset skillset) {
        this.skillset = skillset;
    }
}
