package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;

public class Turn extends Command {
    private double setPointRad;
    private double kP = 0.29;
    public Turn(double setPointRad){
        this.setPointRad = setPointRad;
        addRequirements(Robot.flywheel);
    }

    @Override
    public void initialize() {
        SmartDashboard.putNumber("kP", kP);
    }

    @Override
    public void execute() {
        double error = setPointRad - Robot.flywheel.getPosition();
        double proportionOutput = error * kP;
        Robot.flywheel.setVoltage(proportionOutput);
        SmartDashboard.putNumber("error", error / (2 * Math.PI) * 360);


    }

    @Override
    public void end(boolean interrupted) {
        Robot.flywheel.setVoltage(0);
    }
}
