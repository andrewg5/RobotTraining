package frc.robot.subsystems.Swerve;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.Swerve.SwerveIO.SwerveIOData;

public class Swerve extends SubsystemBase{
    private SwerveIOData[] data = new SwerveIOData[4];

    public SwerveIO[] io = new SwerveIO[4];

    public Swerve(){
        for (int i = 0; i < 4; i++){
            io[i] = new SwerveIOSim(i);
            data[i] = new SwerveIOData();
          }
    }

    public double getPosition(int index){
        return data[index].positionRads; 
    }

    public void setMotorVoltage(double speed, int index) {
        io[index].setVoltage(speed);
      }
    
      public void stop(int index) {
        io[index].setVoltage(0);
      }

    @Override
    public void periodic() {
        for (int i = 0; i < 4; i++){
            io[i].updateData(data[i]);
            SmartDashboard.putNumber("positionDeg: " + i, data[i].positionRads * 180/Math.PI);
        }

    }
}
