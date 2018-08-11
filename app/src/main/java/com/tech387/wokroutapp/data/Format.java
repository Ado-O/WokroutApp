package com.tech387.wokroutapp.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "format_table")
public class Format {

    @ColumnInfo(name = "_id")
    @PrimaryKey(autoGenerate = true)
    private long mId;

    @ColumnInfo(name = "source")
    private String source;

    public Format(long mId, String source) {
        this.mId = mId;
        this.source = source;
    }


    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String mSource) {
        this.source = source;
    }
}
