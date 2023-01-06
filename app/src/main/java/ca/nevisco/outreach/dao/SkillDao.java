package ca.nevisco.outreach.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import ca.nevisco.outreach.model.Skill;

@Dao
public interface SkillDao {

    @Insert
    void insertSkill(Skill... skill);
}
