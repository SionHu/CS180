/**
 * Created by apple on 16/04/2017.
 */
public class Piano extends StringInstrument {
    private String key;

    public Piano(String musicianName, int numStrings, String key){
        super(musicianName, numStrings);
        this.key = key;
    }

    public void play(String song){
        System.out.println(getMusicianName() + " is playing " + song + " on a " + getNumStrings() + " string piano in the key of " + this.key + ".");
    }

    public String getKey(){return key;}

    public static void main(String[] args) {
        Instrument piano = new Piano("Sahil Pujari", 280, "C");
        piano.play("Piano Sonata");
    }
}
