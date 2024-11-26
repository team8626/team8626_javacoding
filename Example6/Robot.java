package Example6;

import java.io.Console;

import Example6.arm.ArmDouble;
import Example6.arm.ArmIO;
import Example6.arm.ArmSim;
import Example6.arm.ArmSimple;

public class Robot {
    private String name;
    private DriveBase driveBase;
    private ArmIO arm;
    private Dashboard dashboard;

    public enum RobotType {
        KITBOT, DEVBOT, COMPBOT, SIMBOT;
    }

    // Change this to the desired robot type
    public static final RobotType myRobotType = RobotType.COMPBOT;

    // Constructor
    public Robot(String name) {
        this.name = name;
        this.dashboard = new Dashboard();

        this.driveBase = new DriveBase();
        switch (myRobotType) {
            case KITBOT:
                this.arm = new ArmSimple(20 /* in */);
                break;
            case DEVBOT:
                this.arm = new ArmDouble(20 /* in */, 10 /* in */);
                break;
            case COMPBOT:
                this.arm = new ArmDouble(20 /* in */, 10 /* in */);
                break;
            case SIMBOT:
                this.arm = new ArmSim(20 /* in */);
                break;
            default:
                throw new IllegalArgumentException("Invalid robot type: " + myRobotType);
        }
        System.out.println("Robot has been created");
    }

    // Method to introduce the robot
    public void introduce() {
        System.out.println("Hello, I am " + name + ", class " + this.getClass().getSimpleName().toUpperCase());
    }

    public void periodic() {
        // Periodic function logic
        // System.out.println("Periodic function called");
        dashboard.periodic();
    }

    public void run(){
        // Get the system console
        Console console = System.console();
        if (console == null) {
            System.err.println("No console available");
            return;
        }

        while (true) {
            char[] inputChars = console.readPassword(); // Read input
            if (inputChars.length == 0) {
                continue; // Skip processing if input is empty
            }
            char input = inputChars[0]; // Read a single character

            switch (input) {
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                    driveBase.setSpeed(Character.getNumericValue(input), Character.getNumericValue(input));
                    break;
                case '-':
                    driveBase.stop();
                    break;
                case 'q':
                    System.out.println("--- Exiting...");
                    System.exit(0); // Stop program execution
                case 'w':
                    arm.setHeight(arm.getHeight() + 1);
                    System.out.printf("--- (+) Height: %.1f in, Reach: %.1f\n", arm.getHeight(), arm.getReach());
                    break;
                case 's':
                    arm.setHeight(arm.getHeight() - 1);
                    System.out.printf("--- (-) Height: %.1f in, Reach: %.1f\n", arm.getHeight(), arm.getReach());
                  break;   
                default:
                    System.out.println("--- Invalid input");
                    break;
            }
        }
    }
}