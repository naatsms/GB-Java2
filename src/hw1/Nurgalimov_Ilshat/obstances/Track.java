package obstances;
import animals.*;
/**
 * Write a description of class Track here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Track implements Let {
    private int length;

    public Track(int length) {
        this.length = length;
    }
    @Override
    public boolean doIt(Animal animal) {
        return animal.run(length);
    }
    public int getLength(){
        return length;
    }
}