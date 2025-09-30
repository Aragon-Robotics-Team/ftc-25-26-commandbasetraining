package org.firstinspires.ftc.teamcode.old;

import com.qualcomm.robotcore.util.ElapsedTime;
import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subSystems.IntakeSubSystem;

public class intakePiece extends CommandBase {

    //private final intakeSubSystem flyWheel;
    //private final intakeSubSystem intakeWrist;
    private final IntakeSubSystem intake;
    private static ElapsedTime time = new ElapsedTime();

    public intakePiece(IntakeSubSystem subSystem) {
        //flyWheel = subSystem;
        //intakeWrist = subSystem;
        intake = subSystem;
        //add requirements?????
    }

    @Override
    public void initialize() {
        //what state do you want to initially start with (like setting motors or opening claws)
        intake.setPivot(IntakeSubSystem.PivotState.TUCKED);
        intake.setExtendoTarget(Constants.EXTENDO_MIN);
        intake.setIntake(IntakeSubSystem.IntakeState.STOP);
        time.reset();
    }

    @Override
    public void execute() {
        //starts in tucked state then goes out does the thing and then it returns to tucked
        intake.setExtendoTarget(Constants.EXTENDO_MIN);
        intake.setPivot(IntakeSubSystem.PivotState.INTAKING);

        time.reset();
        while(time.time() <= 1.0) {
            intake.setIntake(IntakeSubSystem.IntakeState.FORWARD);
        }

        intake.setPivot(IntakeSubSystem.PivotState.TRANSFER);
        intake.setExtendoTarget(Constants.EXTENDO_MAX);

        time.reset();
        while(time.time() <= 1.0) {
            intake.setIntake(IntakeSubSystem.IntakeState.REVERSE);
        }

        intake.setPivot(IntakeSubSystem.PivotState.TUCKED);
        intake.setExtendoTarget(Constants.EXTENDO_MIN);
        intake.setIntake(IntakeSubSystem.IntakeState.STOP);
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}
