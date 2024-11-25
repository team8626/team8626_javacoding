package Example1;
import java.io.Console;

public class Robot {
    private String name;
    private DriveBase driveBase;

    // Constructor
    public Robot(String name) {
        this.name = name;
        this.driveBase = new DriveBase();

        System.out.println("Robot has been created");
    }

    // Method to introduce the robot
    public void introduce() {
        System.out.println("Hello, I am " + name + ", class " + this.getClass().getSimpleName().toUpperCase());
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
                    break;
                default:
                    System.out.println("--- Invalid input");
                    break;
            }
        }

    }

}