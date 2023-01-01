package ca.nevisco.outreach.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ca.nevisco.outreach.data.dao.SkillDao;
import ca.nevisco.outreach.data.entity.SkillEntity;

@Database(entities = {SkillEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabaseRoomHelper extends RoomDatabase {

    private static volatile AppDatabaseRoomHelper INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriterExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public abstract SkillDao skillDao();

    public static AppDatabaseRoomHelper getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabaseRoomHelper.class) {
                INSTANCE = Room.databaseBuilder(context, AppDatabaseRoomHelper.class, "job_db").build();
            }
        }
        return INSTANCE;
    }

}
