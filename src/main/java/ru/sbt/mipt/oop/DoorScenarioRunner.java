package ru.sbt.mipt.oop;

public class DoorScenarioRunner implements EventHandler {
    @Override
    public void handle(SmartHome smartHome, SensorEvent event)  {
        if (event.getType() != SensorEventType.DOOR_CLOSED) {
            return;
        }

        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    if (room.getName().equals("hall")) {
                        for (Room homeRoom : smartHome.getRooms()) {
                            for (Light light : homeRoom.getLights()) {
                                light.setOn(false);
                            }
                        }
                    }
                    System.out.println("All lights were turned off.");
                }
            }
        }
    }

}
