package frc.robot.subsystems.Swerve;

public interface SwerveIO {
    class SwerveIOData {
        public double positionRads;
        int index;
    }

    default void updateData(SwerveIOData data){}

    default void setVoltage(double volts){}

    default double getPos(SwerveIOData data){
        return data.positionRads;
    }

    default void setIndex(int i){}

    default void stop(){}

}

