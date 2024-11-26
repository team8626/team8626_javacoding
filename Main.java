import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import Example1.Robot;

public class Main {
    public static void main(String[] args) {
        // Instantiate the Robot class
        Robot myRobot = new Robot("MyRobot");
        myRobot.introduce();

        // Create a ScheduledExecutorService to call the periodic function every 2 seconds
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            myRobot.periodic();
        }, 0, 200, TimeUnit.MILLISECONDS);

        // Run the robot...
        myRobot.run();
    }
}