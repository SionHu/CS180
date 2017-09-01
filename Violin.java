/**
 * Created by apple on 16/04/2017.
 */
public class Violin extends StringInstrument {

    public Violin(String musicianName){
        super(musicianName, 4);
    }

    public void play(String song){
        System.out.println(getMusicianName() + " is playing " + song + " on a " + getNumStrings() + " string violin.");
    }

    public static void main(String[] args) {
        Instrument violin = new Violin("Tori Shurman");
        violin.play("Violin Song");
    }
}
