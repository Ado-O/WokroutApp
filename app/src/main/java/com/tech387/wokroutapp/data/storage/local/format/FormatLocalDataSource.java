package com.tech387.wokroutapp.data.storage.local.format;

import com.tech387.wokroutapp.data.Format;
import com.tech387.wokroutapp.data.storage.convertor.RemoteToLocal;
import com.tech387.wokroutapp.data.storage.remote.response.FormatResponse;
import com.tech387.wokroutapp.util.AppExecutors;

import java.util.List;

public class FormatLocalDataSource {

    private static FormatLocalDataSource sInstance = null;

    private final FormatDao mFormatDao;
    private final AppExecutors mAppExecutors;

    private FormatLocalDataSource(FormatDao formatDao, AppExecutors appExecutors) {
        mFormatDao = formatDao;
        mAppExecutors = appExecutors;
    }

    public static FormatLocalDataSource getInstance(FormatDao formatDao, AppExecutors appExecutors) {
        if (sInstance == null) {
            sInstance = new FormatLocalDataSource(formatDao, appExecutors);
        }
        return sInstance;
    }

    public void insert(List<FormatResponse> formatResponse) {
        mFormatDao.insert(
                RemoteToLocal.formatConvertor(formatResponse)
        );
    }

    public void getFormat(final GetFormatCallback callback) {
        mAppExecutors.diskIO().execute(
                new Runnable() {
                    @Override
                    public void run() {
                        final List<Format> format = mFormatDao.getFormat();

                        mAppExecutors.mainThread().execute(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        callback.onSuccess(format);
                                    }
                                });
                    }
                });
    }

    public interface GetFormatCallback {
        void onSuccess(List<Format> format);

        void onError();
    }

}
