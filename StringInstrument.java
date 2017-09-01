/**
 * Created by apple on 16/04/2017.
 */
public abstract class StringInstrument extends Instrument{
    private int numStrings;

    public StringInstrument(String musicianNmae, int numStrings){
        super(musicianNmae);
        this.numStrings = numStrings;
    }

    public int getNumStrings() {
        return numStrings;
    }
}
