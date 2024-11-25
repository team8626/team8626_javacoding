import Example4.Robot;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // Instantiate the Robot class
        Robot myRobot = new Robot("R2D2");
        myRobot.introduce();

        // Run the robot...
        myRobot.run();
    }
}