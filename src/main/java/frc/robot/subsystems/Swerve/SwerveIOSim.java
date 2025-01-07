package frc.robot.subsystems.Swerve;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SwerveIOSim implements SwerveIO {
  private final FlywheelSim simSystem = new FlywheelSim(DCMotor.getNEO(1), 6.75, 0.04);
  int index;

  public SwerveIOSim(int index){
    this.index = index;
  }


  @Override
  public void updateData(SwerveIOData data) {
    simSystem.update(0.02);

    data.positionRads += simSystem.getAngularVelocityRadPerSec()*0.02;

    //SmartDashboard.putNumber(index + "pos degree:", data.positionRads / (2*Math.PI) * 360);
    //SmartDashboard.putNumber(index + "velocity degrees per second", simSystem.getAngularVelocityRadPerSec() / (2*Math.PI) * 360);
  }

  @Override
  public void setVoltage(double voltage){
    if(voltage > 12){
        voltage = 12;
    } else if( voltage < -12){
        voltage = -12;
    }


    simSystem.setInputVoltage(voltage);
    SmartDashboard.putNumber("voltage applied" + index, voltage);
  }

  @Override
  public double getPos(SwerveIOData data){
    return data.positionRads;
  }

  @Override
  public void setIndex(int i){
    index = i;
  }
}
