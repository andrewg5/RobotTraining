package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Wheel extends SubsystemBase {
    private final CANSparkMax motor = new CANSparkMax(3, MotorType.kBrushless);
    //private final frc.robot.commands.Drive drive = new frc.robot.commands.Drive(this);

    public Wheel() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void setMotorVoltage(Double voltage){
    motor.set(voltage);
  } 

  public void stop(){
    motor.set(0);
  }
}
