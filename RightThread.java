/**
 * Created by apple on 19/03/2017.
 */
public class RightThread extends Thread /*TODO: What should this extend?*/ {
    public void run() {
        //TODO: Use LeftThread as template to print "Right" and yield for left thread
        //Make sure this process repeats 10 times like in the LeftThread
        for (int i = 0; i < 10; i++) {
            Thread.yield();
            System.out.println("Right");
        }
    }
}
