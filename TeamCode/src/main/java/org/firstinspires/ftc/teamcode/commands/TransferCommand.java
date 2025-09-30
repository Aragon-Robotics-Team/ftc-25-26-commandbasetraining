package org.firstinspires.ftc.teamcode.commands;

import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.SequentialCommandGroup;
import com.seattlesolvers.solverslib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.subSystems.IntakeSubSystem;
import org.firstinspires.ftc.teamcode.subSystems.DepositSubsystem;

public class TransferCommand extends SequentialCommandGroup {
    public TransferCommand(IntakeSubSystem intakeSubsystem, DepositSubsystem depositSubsystem) {
        //retract extendo and intakeWrist to tRansfer
        //bar and wrist to trasnfer
        //close claw
        //bar and wrist to neutral
        //intakewrist to in


        addCommands(
                new InstantCommand(() -> intakeSubsystem.setPivot(IntakeSubSystem.PivotState.TRANSFER)),
                new WaitCommand(200),
                new InstantCommand(() -> depositSubsystem.setPivot(DepositSubsystem.SubsystemState.TRANSFER)),
                new WaitCommand(200),
                new InstantCommand(depositSubsystem::clawClose),
                new WaitCommand(200),
                new InstantCommand(() -> depositSubsystem.setPivot(DepositSubsystem.SubsystemState.NEUTRAL)),
                new WaitCommand(200),
                new InstantCommand(() -> intakeSubsystem.setPivot(IntakeSubSystem.PivotState.TUCKED))
        );
        addRequirements(depositSubsystem);
    }
}
