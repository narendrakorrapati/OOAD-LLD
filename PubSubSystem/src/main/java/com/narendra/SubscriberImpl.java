package com.narendra;

public class SubscriberImpl implements Subscriber{
    @Override
    public void update(Message message) {
        System.out.println("Received message:" + message.getContent());
    }
}
