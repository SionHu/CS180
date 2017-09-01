/**
 * Created by apple on 19/03/2017.
 */
public class LeftThread extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            //TODO: Print "Left"
            System.out.println("Left");
            //TODO: Print "Left"
            System.out.println("Left");
            //TODO: Yield and allow right thread an opportunity to take over
            Thread.yield();
            //TODO: Print "Left"
            System.out.println("Left");
        }
    }
}
