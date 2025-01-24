package com.narendra;

import java.util.*;

public class Intersection {
    private final String id;
    private final Map<String, Road> roads;

    public Intersection() {
        this.id = UUID.randomUUID().toString();
        this.roads = new HashMap<>();
    }

    public void addRoad(Road road) {
        roads.put(road.getId(), road);
    }

    public void removeRoad(Road road) {
        roads.remove(road.getId());
    }

    public String getId() {
        return id;
    }

    public Map<String, Road> getRoads() {
        return roads;
    }

    public Thread start() {
        Thread thread = new Thread(this::startSignals);
        thread.start();
        return thread;
    }

    private void startSignals() {
        boolean isInterrupted = false;
        while(!isInterrupted) {
            for (Road road : roads.values()) {
                try {
                    road.getTrafficSignal().setCurrentColor(Color.GREEN);
                    System.out.println("Road Id:" + road.getId() + " Color:" + road.getTrafficSignal().getCurrentColor());
                    Thread.sleep(road.getTrafficSignal().getGreenDuration());

                    road.getTrafficSignal().setCurrentColor(Color.YELLOW);
                    System.out.println("Road Id:" + road.getId() + " Color:" + road.getTrafficSignal().getCurrentColor());
                    Thread.sleep(road.getTrafficSignal().getYellowDuration());

                    road.getTrafficSignal().setCurrentColor(Color.RED);
                    System.out.println("Road Id:" + road.getId() + " Color:" + road.getTrafficSignal().getCurrentColor());
                } catch (InterruptedException e) {
                    System.out.println("Intersection Id:" + id + " has been interrupted for emergency");
                    isInterrupted = true;
                }
            }
        }
    }
}
