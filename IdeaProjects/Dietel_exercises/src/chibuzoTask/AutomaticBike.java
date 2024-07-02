package chibuzoTask;

public class AutomaticBike {

    private boolean isOn;
    private int speed;


//    public AutomaticBike(Boolean isOn, int speed){
//        this.isOn = isOn;
//        this.speed = speed;
//    }

    public void setIsOn(boolean isOff) {
        this.isOn = isOff;

    }

    public boolean getIsOn() {
        return isOn;
    }

    public void increaseSpeed() {
        int gear = 0;
        if (speed >= 0 && speed <= 20) {
            gear = 1;
            speed +=1;
        }
        if (speed >= 21 && speed <= 30) {
            gear = 2;
            speed +=2;
        }
        if (speed >= 31 && speed <= 40) {
            gear = 3;
            speed +=3;
        }
        if (speed > 40) {
            gear = 4;
            speed +=4;
        }

    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getSpeed() {
        return speed;
    }

    public void decreaseSpeed() {
        int gear = 0;
        if (speed >= 0 && speed <= 20) {
            gear = 1;
            speed -=1;

        }
        if (speed >= 21 && speed <= 30) {
            gear = 2;
            speed -=2;

        }
        if (speed >= 31 && speed <= 40) {
            gear = 3;
            speed -=3;

        }
        if (speed > 40) {
            gear = 4;
            speed -=4;
        }

    }
}