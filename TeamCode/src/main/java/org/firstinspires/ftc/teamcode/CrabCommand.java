package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;
import com.seattlesolvers.solverslib.command.CommandBase;

public class CrabCommand extends CommandBase {
    enum commandState {
        OPEN, CLOSE
    }
    public commandState state = commandState.OPEN;
    private final BraydenSubSystem claw;
    private ElapsedTime time = new ElapsedTime();
    private ElapsedTime helpme = new ElapsedTime();
    public CrabCommand(BraydenSubSystem subSystem) {
        claw = subSystem;
        //add requirements
    }

    @Override
    public void initialize() {
        claw.clawOpen();
        time.reset();
        helpme.reset();
    }

    @Override
    public void execute() {
        switch (state) {
            case OPEN:
                if (time.time() >= 0.4) {
                    state = commandState.CLOSE;
                    claw.clawClose();
                    time.reset();
                }
                break;
            case CLOSE:
                if (time.time() >= 0.4) {
                    state = commandState.OPEN;
                    claw.clawOpen();
                    time.reset();
                }
                break;
        }
    }

    @Override
    public boolean isFinished() {
        if(helpme.time() < 5) {
            return false;
        }
        return true;
    }

    @Override
    public void end(boolean interrupted) {

    }
}