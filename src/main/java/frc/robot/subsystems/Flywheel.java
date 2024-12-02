package frc.robot.subsystems;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Flywheel extends SubsystemBase{
    private double pos = 0;

    private FlywheelSim simSystem = new FlywheelSim(DCMotor.getNEO(1), 6.75, 0.04);

    public Flywheel(){

    }

    public void setVoltage(double voltage){
        if(voltage > 12){
            voltage = 12;
        } else if( voltage < -12){
            voltage = -12;
        }


        simSystem.setInputVoltage(voltage);
        SmartDashboard.putNumber("voltage applied", voltage);
    }

    public double getPosition(){
        return pos;
    }

    @Override
    public void periodic() {
        simSystem.update(0.02);
        pos += simSystem.getAngularVelocityRadPerSec()*0.02;
        SmartDashboard.putNumber("pos degree:", pos / (2*Math.PI) * 360);
        SmartDashboard.putNumber("velocity degrees per second", simSystem.getAngularVelocityRadPerSec() / (2*Math.PI) * 360);
    }
}
