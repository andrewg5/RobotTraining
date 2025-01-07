package frc.robot.subsystems.Arm;

public interface ArmIO {
    public double positionRads = 0.0;


    /** Run to setpoint angle in radians */
    default void runSetpoint(double setpointRads, double feedforward) {}
  
    /** Run motors at volts */
    default void runVolts(double volts) {}
  
    /** Run motors at current */
    default void runCurrent(double amps) {}
  
    /** Set brake mode enabled */
    default void setBrakeMode(boolean enabled) {}
  
    /** Set PID values */
    default void setPID(double p, double i, double d) {}
  
    /** Stops motors */
    default void stop() {}
}
