package ca.nevisco.outreach.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import ca.nevisco.outreach.model.Skillset;

@Dao
public interface SkillsetDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSkillset(Skillset... skillsets);

    @Query("SELECT * FROM Skillset")
    LiveData<List<Skillset>> getAllMySkills();

    @Query("DELETE FROM Skillset")
    void clearSkillsetTable();
}
