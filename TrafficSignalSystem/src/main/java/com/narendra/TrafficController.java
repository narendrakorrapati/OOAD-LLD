package com.narendra;

import java.util.HashMap;
import java.util.Map;

public class TrafficController {
    private final Map<String, Intersection> intersections;
    private final Map<String, Thread> intersectionThreadMap;

    public TrafficController() {
        this.intersections = new HashMap<>();
        this.intersectionThreadMap = new HashMap<>();
    }

    public void addIntersection(Intersection intersection) {
        intersections.put(intersection.getId(), intersection);
    }

    public Map<String, Intersection> getIntersections() {
        return intersections;
    }

    public Map<String, Thread> getIntersectionThreadMap() {
        return intersectionThreadMap;
    }

    public void start() {
        for(Intersection intersection : intersections.values()) {
            intersectionThreadMap.put(intersection.getId(), intersection.start());
        }
    }

    public void handleEmergency(String intersectionId, String roadId, int duration) {
        Intersection intersection = intersections.get(intersectionId);

        if(intersection == null || intersection.getRoads().get(roadId) == null) {
            System.out.println("Invalid intersection/road");
            return;
        }

        Road emergencyRoad = intersection.getRoads().get(roadId);
        Thread thread = intersectionThreadMap.get(intersectionId);

        thread.interrupt();

        emergencyRoad.getTrafficSignal().setCurrentColor(Color.GREEN);
        System.out.println("Road Id:" + emergencyRoad.getId() + " Color:" + emergencyRoad.getTrafficSignal().getCurrentColor() + " This is Emergency");
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        intersectionThreadMap.put(intersection.getId(), intersection.start());
    }
}
