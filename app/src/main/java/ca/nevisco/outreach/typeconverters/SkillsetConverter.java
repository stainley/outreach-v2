package ca.nevisco.outreach.typeconverters;

import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import ca.nevisco.outreach.model.Skill;


public class SkillsetConverter {

    @TypeConverter
    public void convertSkillToEntity(Skill skill) {

    }

    @TypeConverter
    public Skill convertEntityToSkill() {
        return null;
    }

}
