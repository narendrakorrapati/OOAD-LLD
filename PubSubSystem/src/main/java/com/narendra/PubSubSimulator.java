package com.narendra;

public class PubSubSimulator {

    public static void main(String[] args) {
        Subscriber subscriber = new SubscriberImpl();
        Topic topic = new Topic("MOVIES");

        Publisher publisher = new PublisherImpl();
        publisher.registerTopic(topic);

        topic.subscribe(subscriber);

        publisher.publish(topic, new Message("Hello"));
    }
}
