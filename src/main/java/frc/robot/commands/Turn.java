package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;

public class Turn extends Command {
    private double setPointRad;
    private double kP = 0.29;


    public Turn(double setPointRad){
        this.setPointRad = setPointRad;
        addRequirements(Robot.swerve);
    }

    @Override
    public void initialize() {
        //SmartDashboard.putNumber("kP", kP);
    }
 
    @Override
    public void execute() {
        for(int i = 0; i< 4; i++){
            double error = setPointRad - Robot.swerve.getPosition(i);
            double proportionOutput = error * kP;
            Robot.swerve.setMotorVoltage(proportionOutput, i);
            SmartDashboard.putNumber("error", error / (2 * Math.PI) * 360);
        }
        
        


    }

    @Override
    public void end(boolean interrupted) {
        for (int i = 0; i < 4; i++) {
            Robot.swerve.setMotorVoltage(0, i);
        
        }
    }
}
