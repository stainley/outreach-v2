package ca.nevisco.outreach.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import ca.nevisco.outreach.model.Skillset;

@Dao
public interface SkillsetDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSkillset(Skillset... skillsets);
}
