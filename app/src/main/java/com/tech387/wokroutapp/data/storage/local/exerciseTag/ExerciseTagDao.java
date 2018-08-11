package com.tech387.wokroutapp.data.storage.local.exerciseTag;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import com.tech387.wokroutapp.data.ExerciseTag;

import java.util.List;

@Dao
public interface ExerciseTagDao {

    //onCOnfilctStrategy we we identify the duplicate data
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<ExerciseTag> exerciseTags);

}
