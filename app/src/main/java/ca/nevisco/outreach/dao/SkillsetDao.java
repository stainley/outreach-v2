package ca.nevisco.outreach.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import ca.nevisco.outreach.model.Skillset;

@Dao
public interface SkillsetDao {

    @Insert
    void insertSkillset(Skillset... skillsets);
}
