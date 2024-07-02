package airConditionTest;

import chibuzoTask.AirCondition;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AirConditionTest {
    @Test
    public void testAirCondition(){
        AirCondition estherAc = new AirCondition( false,  16);
        assertNotNull(estherAc);
    }
    @Test
    public void testThatAcIsOn(){
        //given that i have an Ac
        AirCondition estherAc = new AirCondition(false,  16);
        //and my Ac is off
        // when turn on
        estherAc.setIsOn(true);
        assertTrue(estherAc.getIsOn());

    }
    @Test
    public void testThatAcIsOff() {

        //given that i have an Ac
        AirCondition estherAc = new AirCondition(true,  16);
        estherAc.setIsOn(false);
        assertEquals(false, estherAc.getIsOn());

    }
    @Test
    public void testDecreaseTemperature() {
        // given that i have an AC
        AirCondition estherAc = new AirCondition(true, 16);
        // when Ac is increased
        estherAc.setTemperature(20);
        estherAc.decreaseTemperature();
        assertEquals(19,estherAc.getTemperature());

    }
    @Test
    public void testIncreaseTemperature() {
        AirCondition estherAc = new AirCondition(true, 16);
        estherAc.setTemperature(16);
        estherAc.increaseTemperature();
        assertEquals(17, estherAc.getTemperature());
    }


}