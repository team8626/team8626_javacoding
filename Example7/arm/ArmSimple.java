package Example7.arm;

import Example7.CS_SubsystemBase;

// public class SimpleArm {
public class ArmSimple extends CS_SubsystemBase implements ArmIO{
    private double shoulderAngle;
    private double armLength;
    private double currentHeight;
    private double currentReach;

    // Constructor
    public ArmSimple(double armLength) {
        // Implicit call to super() here
        this.shoulderAngle = 0.0;
        this.armLength = armLength;
        this.printf("New Arm: %.1f in\n", this.armLength);
    }

    // Method to set the height1 of the top of the arm
    public void setHeight(double height) {
        height = Math.max(Math.min(height, armLength), 0); // Clamp height between 0 and armLength
        this.shoulderAngle = Math.toDegrees(Math.asin(height / armLength));
        this.printf("Angle set to %.1f deg\n", this.shoulderAngle);
        currentReach = armLength * Math.cos(Math.toRadians(shoulderAngle));
        currentHeight = armLength * Math.sin(Math.toRadians(shoulderAngle));
    }

    // Method to get the height of the top of the arm
    public double getHeight() {
        return currentHeight;
    }

    // Method to get the reach of the top of the arm
    public double getReach() {
        return currentReach;
    }

    @Override
    public void updateDashboard() {
        this.printf("Arm Length: %.1fin", armLength);
        this.printf("Shoulder Angle: %.1fdeg", shoulderAngle);
        this.printf("CurrentHeight: %.1fin", currentHeight);
        this.printf("CurrentReach: %.1fin", currentReach);
    }
}