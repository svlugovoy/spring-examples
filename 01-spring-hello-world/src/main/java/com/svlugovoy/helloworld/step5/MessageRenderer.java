package com.svlugovoy.helloworld.step5;

public interface MessageRenderer {

    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();

}
