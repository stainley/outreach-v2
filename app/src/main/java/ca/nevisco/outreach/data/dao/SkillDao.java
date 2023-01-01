package ca.nevisco.outreach.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ca.nevisco.outreach.data.entity.SkillEntity;

@Dao
public interface SkillDao extends AbstractDao<SkillEntity> {

    @Query("SELECT * FROM SKILLS")
    @Override
    List<SkillEntity> findAll();

    @Insert
    @Override
    void save(SkillEntity skill);
}
