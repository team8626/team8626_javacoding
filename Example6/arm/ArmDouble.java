package Example6.arm;

import Example6.CS_SubsystemBase;

// public class DualArm {
public class ArmDouble extends CS_SubsystemBase implements ArmIO{
        private double shoulderAngle;
    private double elbowAngle;
    private double armLength;
    private double forearmLength;

    // Constructor
    public ArmDouble(double upperArmLength, double forearmLength) {
        super();
        this.shoulderAngle = 0.0;
        this.elbowAngle = 0.0;
        this.armLength = upperArmLength;
        this.forearmLength = forearmLength;
        this.printf("New Arm: Upperarm- %.1f in, Forearm- %.1f in, \n", this.armLength, this.forearmLength);
    }

    // Method to get the height of the top of the arm
    public double getHeight() {
        // Calculate the height using the sine of the angles
        double elbowHeight = armLength * Math.sin(Math.toRadians(shoulderAngle));
        double wristHeight = forearmLength * Math.sin(Math.toRadians(shoulderAngle + elbowAngle));
        return elbowHeight + wristHeight;
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
        this.printf("Angles set: Shoulder= %.2f def, Elbow=: %.2f deg\n", this.shoulderAngle, this.elbowAngle);
    }
    
    // Method to get the height of the top of the arm
    public double getReach() {
        double upperaemReach = armLength * Math.cos(Math.toRadians(shoulderAngle));
        double forearmExtraReach = forearmLength * Math.cos(Math.toRadians(shoulderAngle + elbowAngle));
        return upperaemReach + forearmExtraReach;
    }

    @Override
    public void updateDashboard() {
        this.println(" updateDashboard() called");
    }
}