package com.narendra;

public class TrafficSignal {
    private Color currentColor;
    private int greenDuration;
    private int yellowDuration;

    public TrafficSignal(int greenDuration, int yellowDuration) {
        this.greenDuration = greenDuration;
        this.yellowDuration = yellowDuration;
        this.currentColor = Color.RED;
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    public int getGreenDuration() {
        return greenDuration;
    }

    public void setGreenDuration(int greenDuration) {
        this.greenDuration = greenDuration;
    }

    public int getYellowDuration() {
        return yellowDuration;
    }

    public void setYellowDuration(int yellowDuration) {
        this.yellowDuration = yellowDuration;
    }
}
