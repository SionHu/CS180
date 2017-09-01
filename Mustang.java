/**
 * Created by apple on 26/02/2017.
 */
public class Mustang implements Vehicle{

    public String name(){
        return "Mustang";
    }

    public int maxPassengers(){
        return 4;
    }

    public int maxSpeed(){
        return 180;
    }

    public int numWheels(){
        return 4;
    }

    public String startEngine(){
        return "Vroom Vroom!";
    }

    public boolean canFly(){
        return false;
    }

}
