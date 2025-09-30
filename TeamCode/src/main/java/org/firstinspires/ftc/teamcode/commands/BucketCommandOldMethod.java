package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.util.ElapsedTime;
import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subSystems.DepositSubsystem;

public class BucketCommandOldMethod extends CommandBase {
    enum commandState {
        UP, BUCKETPOS, OPEN, CLOSE, DOWN;
    }
    public commandState state = commandState.UP;
    private final DepositSubsystem depositSubsystem;
    private static ElapsedTime stopwatch = new ElapsedTime();

    public BucketCommandOldMethod(DepositSubsystem subsystem) {
        depositSubsystem = subsystem;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(depositSubsystem);
    }

    @Override
    public void initialize() {
        stopwatch.reset();
        state = commandState.UP;
    }

    @Override
    public void execute() {
        switch(state) {
            case UP:
                //placeholder code
                depositSubsystem.setPivot(DepositSubsystem.SubsystemState.WALL);
                if (stopwatch.time() > 3) {
                    state = commandState.BUCKETPOS;
                    stopwatch.reset();
                }
                break;
            case BUCKETPOS:
                //placeholder code
                depositSubsystem.setPivot(DepositSubsystem.SubsystemState.BUCKET);
                if (stopwatch.time() > 0.5) {
                    state = commandState.OPEN;
                    stopwatch.reset();
                }
                break;
            case OPEN:
                //placeholder code
                depositSubsystem.clawOpen();
                if (stopwatch.time() > 1) {
                    state = commandState.CLOSE;
                    stopwatch.reset();
                }
                break;
            case CLOSE:
                //placeholder code
                depositSubsystem.clawClose();
                if (stopwatch.time() > 1) {
                    state = commandState.DOWN;
                    stopwatch.reset();
                }
                break;
            case DOWN:
                //placeholder code
                depositSubsystem.setPivot(DepositSubsystem.SubsystemState.NEUTRAL);
                if (stopwatch.time() > 3) {
                    stopwatch.reset();
                }
        }
    }

    @Override
    public boolean isFinished() {
        if (stopwatch.time() > 1 && state == commandState.DOWN) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void end(boolean interrupted) {

    }
}
