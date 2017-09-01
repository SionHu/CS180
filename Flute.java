import java.io.File;

/**
 * Created by apple on 16/04/2017.
 */
public class Flute extends WoodwindInstrument{
    public Flute(String musicianName){
        super(musicianName, WoodwindType.FLUTE);
    }

    public void play(String song){
        System.out.println(getMusicianName() + " is playing " + song + " on a flute, a "+ getType() +" type woodwind.");
    }

    public static void main(String[] args) {
        Instrument flute = new Flute("Tori Shurman");
        flute.play("Flute Song");
    }
}
