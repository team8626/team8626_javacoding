package Example6;

import java.util.ArrayList;
import java.util.List;

public class Dashboard {

  private static List<CS_SubsystemBase> subsystems = new ArrayList<>();
  private static final double interval = 1000; //  1000ms
  private double m_oldTime = 0.0;

  /**
   * Registers a subsystem with the specified update interval.
   * 
   * @param subsystem The subsystem to register.
   */
  public static void registerSubsystem(CS_SubsystemBase subsystem) {
      subsystems.add(subsystem);
      System.out.println("[DASHBOARD] Registered " + subsystem.getClass().getName());
  }

  public void periodic() {
    double time = System.currentTimeMillis();
    if ((time - m_oldTime) > interval) {
      m_oldTime = time;
      for (CS_SubsystemBase s: subsystems){
        // System.out.println("[DASHBOARD] Updating " + s.getClass().getName());
        s.updateDashboard();
      }
    }
  }
}
