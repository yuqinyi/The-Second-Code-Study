package com.rdx64.uibestpractice;

/**
 * Created by RDX64 on 2017/6/11.
 */

public class Msg {
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;
    private String content;
    private int type;

    public Msg(String _content, int _type) {
        this.content = _content;
        this.type = _type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
