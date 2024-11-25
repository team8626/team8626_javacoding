package Example7.arm;

import Example7.CS_SubsystemBase;

// public class SimpleArm {
public class ArmSim extends CS_SubsystemBase implements ArmIO{
    private double shoulderAngle;
    private double armLength;
    private double currentHeight;
    private double currentReach;

    // Constructor
    public ArmSim(double armLength) {
        // Implicit call to super() here
        this.shoulderAngle = 99.00;
        this.armLength = armLength;
        this.println("Running Simulation");
    }

    @Override
    public double getHeight() {
        return currentHeight;
    }

    @Override
    public double getReach() {
        return currentReach;
    }

    @Override
    public void setHeight(double targetHeight) {
        // TODO Auto-generated method stub
        currentReach = 99.99;
        currentHeight = 99.99;
        throw new UnsupportedOperationException("Unimplemented method 'setHeight'");
    }

    @Override
    public void updateDashboard() {
        this.printf("Arm Length: %.1fin", armLength);
        this.printf("Shoulder Angle: %.1fdeg", shoulderAngle);
        this.printf("CurrentHeight: %.1fin", currentHeight);
        this.printf("CurrentReach: %.1fin", currentReach);
    }
}