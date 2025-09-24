package org.firstinspires.ftc.teamcode.commands;

import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.SequentialCommandGroup;
import com.seattlesolvers.solverslib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.subSystems.intakeSubSystem;

public class instantIntakePiece extends SequentialCommandGroup {
    public instantIntakePiece(intakeSubSystem intake) {
        addCommands(
                //extend
                new InstantCommand(() -> intake.setExtendoTarget(intakeSubSystem.ExtendoState.EXTENDED)),
                new InstantCommand(() -> intake.setPivot(intakeSubSystem.PivotState.INTAKING)),

                //intake
                new InstantCommand(() -> intake.setIntake(intakeSubSystem.IntakeState.FORWARD)),
                new WaitCommand(500),
                new InstantCommand(() -> intake.setIntake(intakeSubSystem.IntakeState.STOP)),

                //retract
                new InstantCommand(() -> intake.setPivot(intakeSubSystem.PivotState.TRANSFER)),
                new InstantCommand(() -> intake.setExtendoTarget(intakeSubSystem.ExtendoState.TRANSFER)),

                //transfer
                new InstantCommand(() -> intake.setIntake(intakeSubSystem.IntakeState.REVERSE)),
                new WaitCommand(500),
                new InstantCommand(() -> intake.setIntake(intakeSubSystem.IntakeState.STOP))
        );

    }
}
