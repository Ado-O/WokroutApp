package com.tech387.wokroutapp.data.storage.local.exerciseTag;

import com.tech387.wokroutapp.data.storage.convertor.RemoteToLocal;
import com.tech387.wokroutapp.data.storage.remote.response.ExerciseResponse;
import com.tech387.wokroutapp.util.AppExecutors;

import java.util.List;

public class ExerciseTagLocalDataSource {

    private static final String TAG = ExerciseTagLocalDataSource.class.getSimpleName();

    private static ExerciseTagLocalDataSource sInstance = null;

    private final ExerciseTagDao mExerciseTagDao;
    private final AppExecutors mAppExecutors;

    private ExerciseTagLocalDataSource(ExerciseTagDao exerciseTagDao, AppExecutors appExecutors) {
        mExerciseTagDao = exerciseTagDao;
        mAppExecutors = appExecutors;
    }

    public static ExerciseTagLocalDataSource getInstance(ExerciseTagDao exerciseTagDao, AppExecutors appExecutors) {
        if (sInstance == null) {
            sInstance = new ExerciseTagLocalDataSource(exerciseTagDao, appExecutors);
        }
        return sInstance;
    }
    public void insertTags(List<ExerciseResponse> exerciseResponse){
        mExerciseTagDao.insert(RemoteToLocal.exerciseTagConverter(exerciseResponse));
    }
}
