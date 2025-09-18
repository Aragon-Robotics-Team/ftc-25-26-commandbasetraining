package org.firstinspires.ftc.teamcode;

import com.seattlesolvers.solverslib.command.CommandBase;

public class ClawClose extends CommandBase {
    private final BraydenSubSystem claw;

    public ClawClose(BraydenSubSystem subSystem) {
        claw = subSystem;

    }

    @Override
    public void initialize() {
        claw.clawOpen();
    }

    @Override
    public void execute() {
        claw.clawClose();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
