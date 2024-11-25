package Example3;

// public class DriveBase {
public class DriveBase extends CS_SubsystemBase {
    private double leftSpeed;
    private double rightSpeed;

    // Constructor
    public DriveBase() {
        // Implicit call to super() here
        this.leftSpeed = 0.0;
        this.rightSpeed = 0.0;
    }

    // Method to set the speed of the left and right motors
    public void setSpeed(double leftSpeed, double rightSpeed) {
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
        // System.out.println("Left speed set to: " + leftSpeed);
        // System.out.println("Right speed set to: " + rightSpeed);
        this.println("Left speed set to: " + leftSpeed);
        this.println("Right speed set to: " + rightSpeed);
    }

    // // Method to set the speed 
    public void setSpeed(double speed) {
        setSpeed(speed, speed);
    }

    // Method to stop the drive base
    public void stop() {
        setSpeed(0);
        // System.out.println("Drive base stopped.");
        this.println("Drive base stopped.");
    }

    // Method to get the current speed of the left motor
    public double getLeftSpeed() {
        return leftSpeed;
    }

    // Method to get the current speed of the right motor
    public double getRightSpeed() {
        return rightSpeed;
    }

    // Method to get the current speed of the robot
    public double getSpeed() {
        return (rightSpeed + leftSpeed) / 2;
    }
}