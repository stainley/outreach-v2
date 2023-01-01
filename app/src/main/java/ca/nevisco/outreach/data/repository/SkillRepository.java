package ca.nevisco.outreach.data.repository;

import android.app.Application;

import ca.nevisco.outreach.data.dao.SkillDao;
import ca.nevisco.outreach.data.db.AppDatabaseRoomHelper;

public class SkillRepository {

    private SkillDao skillDao;

    public SkillRepository(Application application) {
        AppDatabaseRoomHelper databaseRoom = AppDatabaseRoomHelper.getDatabase(application);
        skillDao = databaseRoom.skillDao();
    }
}
