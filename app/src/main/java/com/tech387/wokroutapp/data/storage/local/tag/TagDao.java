package com.tech387.wokroutapp.data.storage.local.tag;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import com.tech387.wokroutapp.data.Tag;

import java.util.List;

@Dao
public interface TagDao {

    //onCOnfilctStrategy we we identify the duplicate data
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Tag> exercise);

}
