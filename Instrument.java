/**
 * Created by apple on 16/04/2017.
 */
public abstract class Instrument {
    private String musicianName;

    public Instrument(String musicianName){
        this.musicianName = musicianName;
    }

    public String getMusicianName() {
        return musicianName;
    }

    public abstract void play(String song);
}
