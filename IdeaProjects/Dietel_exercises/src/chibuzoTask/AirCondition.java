package chibuzoTask;

public class AirCondition {
    private boolean isOn;
    private int temperature ;

    public AirCondition(boolean isOn, int temperature) {
        this.isOn = isOn;
        this.temperature = temperature;

    }

    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }

    public boolean getIsOn() {
        return this.isOn;
    }


    public void increaseTemperature() {
        if (temperature < 30) {
            temperature += 1;
        }

    }
    public void decreaseTemperature() {
        if (temperature > 16) {
            temperature -= 1;
        }
    }
    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;

    }


}
