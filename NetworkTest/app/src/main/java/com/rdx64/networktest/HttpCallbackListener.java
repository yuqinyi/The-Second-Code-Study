package com.rdx64.networktest;

/**
 * Created by RDX64 on 2017/6/17.
 */

public interface HttpCallbackListener {
    void onFinish(int responseCode, String response);

    void onError(Exception e);
}
