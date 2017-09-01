/**
 * Created by apple on 16/04/2017.
 */
public abstract class WoodwindInstrument extends Instrument{
    private WoodwindType type;

    public WoodwindInstrument(String musicianName, WoodwindType type){
        super(musicianName);
        this.type = type;
    }

    public String getType() {
        if (type.equals(WoodwindType.FLUTE)){
            return "FLUTE";
        }else if (type.equals(WoodwindType.REED)){
            return "REED";
        }else return null;
    }


}
