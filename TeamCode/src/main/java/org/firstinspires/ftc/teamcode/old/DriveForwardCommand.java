package org.firstinspires.ftc.teamcode.old;
import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subSystems.DriveSubsystem;

public class DriveForwardCommand extends CommandBase {
    private final DriveSubsystem driveSubsystem;
    public DriveForwardCommand(DriveSubsystem subsystem) {
        driveSubsystem = subsystem;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize() {
        double y = 1; // Remember, Y stick is reversed!
        double x = 0;
        double rx = 0;
        driveSubsystem.setDriveVectors(x, y, rx);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
