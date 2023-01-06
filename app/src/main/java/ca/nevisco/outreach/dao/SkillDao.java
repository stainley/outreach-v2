package ca.nevisco.outreach.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import ca.nevisco.outreach.model.Skill;

@Dao
public interface SkillDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertSkill(Skill... skill);

    @Query("SELECT * FROM Skill")
    LiveData<List<Skill>> getAllSkills();
}
