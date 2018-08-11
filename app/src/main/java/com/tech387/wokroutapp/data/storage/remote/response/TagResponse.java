package com.tech387.wokroutapp.data.storage.remote.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TagResponse implements Serializable {

    @SerializedName("id")
    @Expose
    private long mId;

    @SerializedName("name")
    @Expose
    private String mName;

    public TagResponse(long mId, String mName) {
        this.mId = mId;
        this.mName = mName;
    }

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
