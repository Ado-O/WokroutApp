package com.tech387.wokroutapp.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "exercise_tag_table")
public class ExerciseTag {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private Long id;

    @ColumnInfo(name = "exercise_id")
    private Long exerciseId;

    @ColumnInfo(name = "tag_id")
    private Long tagId; //list

    //This constrictor will use Room
    public ExerciseTag(Long id, Long exerciseId, Long tagId) {
        this.id = id;
        this.exerciseId = exerciseId;
        this.tagId = tagId;
    }

    @Ignore
    public ExerciseTag(Long exerciseId, Long tagId) {
        this.id = null;
        this.exerciseId = exerciseId;
        this.tagId = tagId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public Long getTagId() {
        return tagId;
    }
}
