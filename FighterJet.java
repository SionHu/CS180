/**
 * Created by apple on 26/02/2017.
 */
public class FighterJet implements Vehicle {
    public String name(){
        return "F-15";
    }

    public int maxPassengers(){
        return 2;
    }

    public int maxSpeed(){
        return 1875;
    }

    public int numWheels(){
        return 3;
    }

    public String startEngine(){
        return "Whoosh!";
    }

    public boolean canFly(){
        return true;
    }

    String sonicBoom(int currentSpeed){
        if (currentSpeed > 761){
            return "BOOM!!";
        }else return "Whoosh!";
    }
}
