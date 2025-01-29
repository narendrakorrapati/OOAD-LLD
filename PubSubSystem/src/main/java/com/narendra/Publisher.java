package com.narendra;

public interface Publisher {
    void registerTopic(Topic topic);

    void publish(Topic topic, Message message);
}
