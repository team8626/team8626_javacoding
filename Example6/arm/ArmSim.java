package Example6.arm;

import Example6.CS_SubsystemBase;

// public class SimpleArm {
public class ArmSim extends CS_SubsystemBase implements ArmIO{
    private double shoulderAngle;
    private double armLength;

    // Constructor
    public ArmSim(double armLength) {
        // Implicit call to super() here
        this.shoulderAngle = 0.0;
        this.armLength = armLength;
        this.println("Running Simulation");
    }

    @Override
    public double getHeight() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHeight'");
    }

    @Override
    public double getReach() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReach'");
    }


    @Override
    public void setHeight(double targetHeight) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setHeight'");
    }

    @Override
    public void updateDashboard() {
        this.println(" updateDashboard() called");
    }
}