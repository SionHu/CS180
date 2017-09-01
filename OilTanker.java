import static java.lang.Math.PI;

/**
 * Created by apple on 26/02/2017.
 */
public class OilTanker implements Vehicle {
    public String name(){
        return "Oil Tanker";
    }

    public int maxPassengers(){
        return 30;
    }

    public int maxSpeed(){
        return 20;
    }

    public int numWheels(){
        return 0;
    }

    public String startEngine(){
        return "Brum Brum!";
    }

    public boolean canFly(){
        return false;
    }

    double maxOilCarried(double radius, double height){
        return  PI * Math.pow(radius, 2) * height;
    }
}
