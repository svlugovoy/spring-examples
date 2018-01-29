package com.svlugovoy.helloworld.step3;

public interface MessageRenderer {

    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();

}
