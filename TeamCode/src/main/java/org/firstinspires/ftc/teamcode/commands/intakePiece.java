package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.util.ElapsedTime;
import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.old.CrabCommand;
import org.firstinspires.ftc.teamcode.subSystems.intakeSubSystem;

public class intakePiece extends CommandBase {
    //private final intakeSubSystem flyWheel;
    //private final intakeSubSystem intakeWrist;
    private final intakeSubSystem intake;
    private static ElapsedTime time = new ElapsedTime();

    public intakePiece(intakeSubSystem subSystem) {
        //flyWheel = subSystem;
        //intakeWrist = subSystem;
        intake = subSystem;
    }

    @Override
    public void initialize() { //what state do you want to initially start with (like setting motors or opening claws)
        intake.wristUp();
        time.reset();
    }

    @Override
    public void execute() {
        intake.wristDown();
        time.reset();
        switch (intakeSubSystem.state) {

        }
        intake.intakeFlyWheel();


    }

    @Override
    public boolean isFinished() {
        return true;
    }

}
