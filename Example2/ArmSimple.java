package Example2;

public class ArmSimple {
    private double shoulderAngle;
    private double armLength;

    // Constructor
    public ArmSimple(double armLength) {
        this.shoulderAngle = 0.0;
        this.armLength = armLength;
    }

    // Method to set the height of the top of the arm
    public void setHeight(double height) {
        height = Math.max(Math.min(height, armLength), 0); // Clamp height between 0 and armLength
        this.shoulderAngle = Math.toDegrees(Math.asin(height / armLength));
        System.out.printf("Angle set to %.1f deg\n", this.shoulderAngle);
    }

    // Method to get the height of the top of the arm
    public double getHeight() {
        return armLength * Math.sin(Math.toRadians(shoulderAngle));
    }

    // Method to get the reach of the top of the arm
    public double getReach() {
        return armLength * Math.cos(Math.toRadians(shoulderAngle));
    }
}