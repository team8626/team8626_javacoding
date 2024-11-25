package Example7.arm;

import Example7.CS_SubsystemBase;

// public class DualArm {
public class ArmDouble extends CS_SubsystemBase implements ArmIO{
    private double shoulderAngle;
    private double elbowAngle;
    private double armLength;
    private double forearmLength;
    private double currentHeight;
    private double currentReach;

    // Constructor
    public ArmDouble(double upperArmLength, double forearmLength) {
        super();
        this.shoulderAngle = 0.0;
        this.elbowAngle = 0.0;
        this.armLength = upperArmLength;
        this.forearmLength = forearmLength;
        this.printf("New Arm: Upperarm- %.1f in, Forearm- %.1f in, \n", this.armLength, this.forearmLength);
    }

    // Method to maximize the reach
    public void setHeight(double targetHeight) {
        if (targetHeight <= armLength) {
            // Keep the forearm flat and adjust the shoulder angle
            this.shoulderAngle = Math.toDegrees(Math.asin(targetHeight / armLength));
            this.elbowAngle = -this.shoulderAngle;
        } else if (targetHeight <= armLength + forearmLength) {
            // Set the shoulder angle to 90 degrees and adjust the elbow angle
            this.shoulderAngle = 90.0;
            double remainingHeight = targetHeight - armLength;
            this.elbowAngle = Math.toDegrees(Math.asin(remainingHeight / forearmLength)) - 90;
        } else {
            this.println("Cannot got higher!");
        }

        currentReach = armLength * Math.cos(Math.toRadians(shoulderAngle))
                        + forearmLength * Math.cos(Math.toRadians(shoulderAngle + elbowAngle));

        currentHeight = armLength * Math.sin(Math.toRadians(shoulderAngle))
                        + forearmLength * Math.sin(Math.toRadians(shoulderAngle + elbowAngle));
        
        this.printf("Angles set: Shoulder= %.2f def, Elbow=: %.2f deg\n", this.shoulderAngle, this.elbowAngle);
    }
    
    // Method to get the height of the top of the arm
    public double getReach() {
        return currentReach;
    }

    // Method to get the height of the top of the arm
    public double getHeight() {
        return currentHeight;
    }
    
    @Override
    public void updateDashboard() {
        this.printf("UpperArm Length: %.1fin", armLength);
        this.printf("ForeArm Length: %.1fin",  forearmLength);
        this.printf("Shoulder Angle: %.1fdeg", shoulderAngle);
        this.printf("Elbow Angle: %.1fdeg", elbowAngle);
        this.printf("CurrentHeight: %.1fin", currentHeight);
        this.printf("CurrentReach: %.1fin", currentReach);
    }
}