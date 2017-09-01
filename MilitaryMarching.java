/**
 * Created by apple on 19/03/2017.
 */
public class MilitaryMarching {
    public static void main(String[] args){
        //TODO: Create left and right thread objects
        LeftThread leftThread = new LeftThread();
        RightThread rightThread = new RightThread();
        //TODO: Start left and right thread objects
        leftThread.start();
        rightThread.start();
        try {
            //TODO: Join left and right thread objects
            leftThread.join();
            rightThread.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
