package ca.nevisco.outreach.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ca.nevisco.outreach.dao.SkillDao;
import ca.nevisco.outreach.dao.SkillsetDao;
import ca.nevisco.outreach.dao.StudentDao;
import ca.nevisco.outreach.model.Skill;
import ca.nevisco.outreach.model.Skillset;
import ca.nevisco.outreach.model.Student;

@Database(entities = {Student.class, Skillset.class, Skill.class}, version = 1, exportSchema = false)
public abstract class JobRoomDatabase extends RoomDatabase {

    private static JobRoomDatabase INSTANCE;

    public static JobRoomDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (JobRoomDatabase.class) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), JobRoomDatabase.class, "JOB_DB").allowMainThreadQueries().build();
            }
        }
        return INSTANCE;
    }

    public abstract StudentDao studentDao();

    public abstract SkillsetDao skillsetDao();

    public abstract SkillDao skillDao();

}
