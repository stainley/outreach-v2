package ca.nevisco.outreach.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import ca.nevisco.outreach.model.Student;
import retrofit2.http.DELETE;

@Dao
public interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Student student);

    @Query("SELECT * FROM student")
    LiveData<Student> getStudentInfo();

    @Query("DELETE FROM student")
    void clearStudent();

}
