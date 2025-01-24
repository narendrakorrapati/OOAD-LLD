package com.narendra;

import java.util.UUID;

public class Road {
    private final String id;
    private final TrafficSignal trafficSignal;

    public Road(TrafficSignal trafficSignal) {
        this.id = UUID.randomUUID().toString();
        this.trafficSignal = trafficSignal;
    }

    public String getId() {
        return id;
    }

    public TrafficSignal getTrafficSignal() {
        return trafficSignal;
    }
}
