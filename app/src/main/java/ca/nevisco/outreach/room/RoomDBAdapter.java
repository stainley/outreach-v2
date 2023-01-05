package ca.nevisco.outreach.room;

import androidx.room.Database;

import ca.nevisco.outreach.dao.StudentDao;
import ca.nevisco.outreach.model.Student;

@Database(entities = {Student.class}, version = 1, exportSchema = false)
public abstract class RoomDBAdapter {

    public abstract StudentDao studentDao();


}
