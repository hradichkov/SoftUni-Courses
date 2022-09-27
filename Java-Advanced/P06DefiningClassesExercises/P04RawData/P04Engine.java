package P06DefiningClassesExercises.P04RawData;

public class P04Engine {
    private  int speed;
    private int power;

    public P04Engine(int speed, int power) {
        this.speed = speed;
        this.power = power;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
