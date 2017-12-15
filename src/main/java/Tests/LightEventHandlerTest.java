package Tests;

import org.junit.Test;
import ru.sbt.mipt.oop.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LightEventHandlerTest {
    @Test
    public void testLighton(){
        SmartHome smarthome = new SmartHome();
        Door door = new Door(true, String.valueOf(1));
        ArrayList<Door> doors = new ArrayList<>();
        ArrayList<Light> lights = new ArrayList<Light>();
        Light light1 = new Light( String.valueOf(5),false);
        Light light2 = new Light( String.valueOf(4),true);
        lights.add(light1);
        lights.add(light2);
        doors.add(door);
        String name ="hall";
        Room room = new Room(lights, doors, name);

        smarthome.addRoom(room);
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ON, "5");
        LightEventHandler lighteventhandler = new LightEventHandler();
        lighteventhandler.handle(smarthome,event);
        assertTrue(light1.isOn());

    }
    @Test
    public void testLightoff(){
        SmartHome smarthome = new SmartHome();
        Door door = new Door(true, String.valueOf(1));
        ArrayList<Door> doors = new ArrayList<>();
        ArrayList<Light> lights = new ArrayList<Light>();
        Light light1 = new Light( String.valueOf(5),false);
        Light light2 = new Light( String.valueOf(4),true);
        lights.add(light1);
        lights.add(light2);
        doors.add(door);
        String name ="hall";
        Room room = new Room(lights, doors, name);

        smarthome.addRoom(room);
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_OFF, "4");
        LightEventHandler lighteventhandler = new LightEventHandler();
        lighteventhandler.handle(smarthome,event);
        assertFalse(light2.isOn());

    }

}