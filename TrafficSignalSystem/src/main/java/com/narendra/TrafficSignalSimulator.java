package com.narendra;

public class TrafficSignalSimulator {

    public static void main(String[] args) {
        TrafficSignal trafficSignalRoad1 = new TrafficSignal(10000, 5000);
        TrafficSignal trafficSignalRoad2 = new TrafficSignal(10000, 5000);
        TrafficSignal trafficSignalRoad3 = new TrafficSignal(10000, 5000);
        TrafficSignal trafficSignalRoad4 = new TrafficSignal(10000, 5000);

        Road road1 = new Road(trafficSignalRoad1);
        Road road2 = new Road(trafficSignalRoad2);
        Road road3 = new Road(trafficSignalRoad3);
        Road road4 = new Road(trafficSignalRoad4);

        Intersection intersection = new Intersection();
        intersection.addRoad(road1);
        intersection.addRoad(road2);
        intersection.addRoad(road3);
        intersection.addRoad(road4);

        TrafficController trafficController = new TrafficController();
        trafficController.addIntersection(intersection);

        trafficController.start();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        trafficController.handleEmergency(intersection.getId(), road1.getId(), 30000);
    }
}
