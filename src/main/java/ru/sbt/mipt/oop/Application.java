package ru.sbt.mipt.oop;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {
        SmartHome smartHome = Reader.read();
        EventObserver eventObserver = new EventObserver();
        configureHandlers(eventObserver);
        eventObserver.runEventCycle(smartHome);
    }

    private static void configureHandlers(EventObserver observer) {
        observer.addHandler(new LightEventHandler());
        observer.addHandler(new DoorEventHandler());
    }

    public static SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}