package Tests;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DoorScenarioRunnerTest {
    @Test
    public void doorScenarioTestWhenDoorClosed(){
        SmartHome smarthome = new SmartHome();
        Door door = new Door(true, String.valueOf(1));
        ArrayList<Door> doors = new ArrayList<>();
        ArrayList<Light> lights = new ArrayList<Light>();
        Light light1 = new Light( String.valueOf(5),true);
        Light light2 = new Light( String.valueOf(4),true);
        lights.add(light1);
        lights.add(light2);
        doors.add(door);
        String name ="hall";
        Room room = new Room(lights, doors, name);

        smarthome.addRoom(room);
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, "1");
        DoorScenarioRunner doorscenariorunner = new DoorScenarioRunner();
        doorscenariorunner.handle(smarthome,event);
        assertFalse(light1.isOn());
        assertFalse(light2.isOn());

    }
    @Test
    public void testWhenAnotherRoomDoorClosed(){
        SmartHome smarthome = new SmartHome();
        Door door = new Door(true, String.valueOf(1));
        ArrayList<Door> doors = new ArrayList<>();
        ArrayList<Light> lights = new ArrayList<Light>();
        Light light1 = new Light( String.valueOf(5),true);
        Light light2 = new Light( String.valueOf(4),true);
        lights.add(light1);
        lights.add(light2);
        doors.add(door);
        String name ="kitchen";
        Room room = new Room(lights, doors, name);

        smarthome.addRoom(room);
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, "1");
        DoorScenarioRunner doorscenariorunner = new DoorScenarioRunner();
        doorscenariorunner.handle(smarthome,event);
        assertTrue(light1.isOn());
        assertTrue(light2.isOn());
    }

}