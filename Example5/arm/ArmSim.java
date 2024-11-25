package Example5.arm;

import Example5.CS_SubsystemBase;

// public class SimpleArm {
public class ArmSim extends CS_SubsystemBase implements ArmIO{
    private double shoulderAngle;
    private double armLength;

    // Constructor
    public ArmSim(double armLength) {
        // Implicit call to super() here
        this.shoulderAngle = 0.0;
        this.armLength = armLength;
        this.println("Runniong Simulation");
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

}