package com.tech387.wokroutapp.data.storage.local.format;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.tech387.wokroutapp.data.Format;

import java.util.List;

@Dao
public interface FormatDao {

    //onCOnfilctStrategy we we identify the duplicate data
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Format> formats);

    //in this line we teak everting from workout table
    @Query("SELECT * FROM format_table")
    List<Format> getFormat();

}
