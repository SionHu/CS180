/**
 * Created by apple on 16/04/2017.
 */
public class Saxophone extends WoodwindInstrument {
    public Saxophone(String musicianName){
        super(musicianName, WoodwindType.REED);
    }

    public void play(String song){
        System.out.println(getMusicianName() + " is playing " + song + " on a saxophone, a "+getType()+" type woodwind.");
    }

    public static void main(String[] args) {
        Instrument saxophone = new Saxophone("Sahil Pujari");
        saxophone.play("Saxophone Song");
    }
}
