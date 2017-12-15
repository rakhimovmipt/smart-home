package Tests;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DoorEventHandlerTest {

    @Test
    public void handleTest()  {
        SmartHome smarthome = new SmartHome();
        Door door = new Door(false, String.valueOf(5));
        ArrayList<Door> doors = new ArrayList<>();
        ArrayList<Light> lights = new ArrayList<Light>();
        doors.add(door);
        String name ="Hall";
        Room room = new Room(lights, doors, name);
        smarthome.addRoom(room);
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_OPEN, "5");
        DoorEventHandler dooreventhandler = new DoorEventHandler();
        dooreventhandler.handle(smarthome,event);
        assertTrue(door.getState());
    }

    @Test
    public void closeDoorTest(){
        SmartHome smarthome = new SmartHome();
        Door door = new Door(true, String.valueOf(3));
        ArrayList<Door> doors = new ArrayList<>();
        ArrayList<Light> lights = new ArrayList<Light>();
        doors.add(door);
        String name ="Hall";
        Room room = new Room(lights, doors, name);
        smarthome.addRoom(room);
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, "3");
        DoorEventHandler dooreventhandler = new DoorEventHandler();
        dooreventhandler.handle(smarthome,event);
        assertFalse(door.getState());

    }

}