package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;
import com.seattlesolvers.solverslib.command.CommandBase;

public class CrabCommand extends CommandBase {
    enum commandState {
        OPEN, CLOSE
    }
    public commandState state = commandState.OPEN;
    private final BraydenSubSystem claw;
    private static ElapsedTime time = new ElapsedTime();
    public CrabCommand(BraydenSubSystem subSystem) {
        claw = subSystem;
        //add requirements
    }

    @Override
    public void initialize() {
        claw.clawOpen();
        time.reset();
    }

    @Override
    public void execute() {
        switch (state) {
            case OPEN:
                if (time.time() == 1.0) {
                    state = commandState.CLOSE;
                    time.reset();
                }
                break;
            case CLOSE:
                if (time.time() > 1.0) {
                    state = commandState.OPEN;
                    time.reset();
                }
                break;
        }
    }

    @Override
    public boolean isFinished() {
        if (time.time() < 10) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void end(boolean interrupted) {

    }
}