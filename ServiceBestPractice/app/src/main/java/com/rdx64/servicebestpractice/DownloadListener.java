package com.rdx64.servicebestpractice;

/**
 * Created by RDX64 on 2017/6/17.
 */

public interface DownloadListener {
    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPaused();

    void onCanceled();
}
