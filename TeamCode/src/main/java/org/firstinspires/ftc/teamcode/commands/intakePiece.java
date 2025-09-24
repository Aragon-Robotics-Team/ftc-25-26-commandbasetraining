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
        //add requirements?????
    }

    @Override
    public void initialize() {
        //what state do you want to initially start with (like setting motors or opening claws)
        intake.setPivot(intakeSubSystem.PivotState.TUCKED);
        intake.setExtendoTarget(intakeSubSystem.ExtendoState.TUCKED);
        intake.setIntake(intakeSubSystem.IntakeState.STOP);
        time.reset();
    }

    @Override
    public void execute() {
        intake.setExtendoTarget(intakeSubSystem.ExtendoState.EXTENDED);
        intake.setPivot(intakeSubSystem.PivotState.INTAKING);

        time.reset();
        while(time.time() <= 1.0) {
            intake.setIntake(intakeSubSystem.IntakeState.FORWARD);
        }

        intake.setPivot(intakeSubSystem.PivotState.TRANSFER);
        intake.setExtendoTarget(intakeSubSystem.ExtendoState.TRANSFER);

        time.reset();
        while(time.time() <= 1.0) {
            intake.setIntake(intakeSubSystem.IntakeState.REVERSE);
        }

        intake.setPivot(intakeSubSystem.PivotState.TUCKED);
        intake.setExtendoTarget(intakeSubSystem.ExtendoState.TUCKED);
        intake.setIntake(intakeSubSystem.IntakeState.STOP);
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}
