package com.narendra;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class PublisherImpl implements Publisher{
    private final Set<Topic> topics;

    public PublisherImpl() {
        this.topics = new CopyOnWriteArraySet<>();
    }

    @Override
    public void registerTopic(Topic topic) {
        topics.add(topic);
    }
    @Override
    public void publish(Topic topic, Message message) {
        if(topics.contains(topic)) {
            topic.getSubscribers().forEach(subscriber -> subscriber.update(message));
        } else {
            System.out.println("Topic has not been registered");
        }
    }
}
