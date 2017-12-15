package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

import static ru.sbt.mipt.oop.Application.getNextSensorEvent;

public class EventObserver {
    private Collection<EventHandler> eventHandlers = new ArrayList<>();


    public EventObserver() {

    }

    public void runEventCycle(SmartHome smartHome) {
        SensorEvent event = getNextSensorEvent();

        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventHandler eventHandler : eventHandlers) {
                eventHandler.handle(smartHome, event);
            }
            event = getNextSensorEvent();
        }
    }

    public void addHandler(EventHandler eventHandler) {
        eventHandlers.add(eventHandler);
    }
}
