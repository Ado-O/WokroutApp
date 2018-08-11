package com.tech387.wokroutapp.data.storage;

import com.tech387.wokroutapp.data.Format;
import com.tech387.wokroutapp.data.storage.local.format.FormatLocalDataSource;

import java.util.List;

public class FormatRespository {

    public static final String TAG = FormatRespository.class.getSimpleName();

    private static FormatRespository sInstance = null;

    private final FormatLocalDataSource mFormatLocalDataSource;

    //construct
    private FormatRespository(FormatLocalDataSource formatLocalDataSource) {
        mFormatLocalDataSource = formatLocalDataSource;
    }

    public static FormatRespository getInstance(FormatLocalDataSource formatLocalDataSource) {
        if (sInstance == null) {
            sInstance = new FormatRespository(formatLocalDataSource);
        }
        return sInstance;
    }

    public void getFormat(final GetFormatCallback callback){
        mFormatLocalDataSource.getFormat(new FormatLocalDataSource.GetFormatCallback() {
            @Override
            public void onSuccess(List<Format> format) {
                callback.onSuccess(format);
            }

            @Override
            public void onError() {

            }
        });
    }



    public interface GetFormatCallback {
        void onSuccess(List<Format> format);

        void onError();
    }
}
