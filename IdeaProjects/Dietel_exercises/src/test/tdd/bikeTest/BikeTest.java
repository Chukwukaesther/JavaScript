package bikeTest;

import chibuzoTask.AutomaticBike;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class BikeTest {

    @Test
    public void testAutomaticBike() {
        AutomaticBike bike = new AutomaticBike();
        assertNotNull(bike);
    }
    @Test
    public void testThatBikeIsOff() {
        AutomaticBike bike = new AutomaticBike();
        bike.setIsOn(false);
        assertEquals(false , bike.getIsOn());
    }

    @Test
    public void testThatBikeIsOn() {
        AutomaticBike bike = new AutomaticBike();
        bike.setIsOn(true);
        assertTrue(bike.getIsOn());
    }
    @Test
    public void testThatSpeedIncreaseAccelerate(){
        AutomaticBike bike = new AutomaticBike();
        bike.setSpeed(23);
        bike.increaseSpeed();
        assertEquals(25,bike.getSpeed());


    }
    @Test
    public void testThatSpeedCanDecelerate(){
        AutomaticBike bike = new AutomaticBike();
        bike.setSpeed(23);
        bike.decreaseSpeed();
        assertEquals(21,bike.getSpeed());
    }


}
