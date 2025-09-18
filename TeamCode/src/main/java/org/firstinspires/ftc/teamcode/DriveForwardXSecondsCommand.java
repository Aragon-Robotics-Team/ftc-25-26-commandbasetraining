package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.seattlesolvers.solverslib.command.CommandBase;

public class DriveForwardXSecondsCommand extends CommandBase {
    enum commandState {
        DRIVEFORWARD, TURN, DRIVEFORWARD2;
    }

    public commandState state = commandState.DRIVEFORWARD;

    private final DriveSubsystem driveSubsystem;
    private static ElapsedTime stopwatch = new ElapsedTime();
    public DriveForwardXSecondsCommand(DriveSubsystem subsystem) {
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

        stopwatch.reset();
    }

    @Override
    public void execute() {
        switch (state) {
            case DRIVEFORWARD:
                // placeholder code
                driveSubsystem.setDriveVectors(0,1,0);
                if (stopwatch.time() == 1) {
                    state = commandState.TURN;
                    stopwatch.reset();
                }
                break;
            case TURN:
                // placeholder code
                driveSubsystem.setDriveVectors(0,0,1);
                if (stopwatch.time() > 1.1) {
                    state = commandState.DRIVEFORWARD2;
                    stopwatch.reset();
                }
                break;
            case DRIVEFORWARD2:
                // placeholder code
                driveSubsystem.setDriveVectors(0,1,0);
                break;
        }
    }

    @Override
    public boolean isFinished() {
        if (stopwatch.time() > 1 && state == commandState.DRIVEFORWARD2) {
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public void end(boolean interrupted) {
        driveSubsystem.setDriveVectors(0,0,0);
    }
}
