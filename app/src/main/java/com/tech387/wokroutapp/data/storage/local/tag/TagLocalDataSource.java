package com.tech387.wokroutapp.data.storage.local.tag;

import com.tech387.wokroutapp.data.storage.convertor.RemoteToLocal;
import com.tech387.wokroutapp.data.storage.remote.response.TagResponse;
import com.tech387.wokroutapp.util.AppExecutors;

import java.util.List;

public class TagLocalDataSource {
    private static final String TAG = TagLocalDataSource.class.getSimpleName();

    private static TagLocalDataSource sInstance = null;

    private final TagDao mTagDao;
    private final AppExecutors mAppExecutors;

    private TagLocalDataSource(TagDao tagDao,AppExecutors appExecutors) {
        mTagDao = tagDao;
        mAppExecutors = appExecutors;
    }

    public static TagLocalDataSource getInstance(TagDao tagDao, AppExecutors appExecutors) {
        if (sInstance == null) {
            sInstance = new TagLocalDataSource(tagDao, appExecutors);
        }
        return sInstance;
    }

    public void insertTags(List<TagResponse> tagResponses){
        mTagDao.insert(RemoteToLocal.tagConvertor(tagResponses));
    }
}
