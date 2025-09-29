package org.firstinspires.ftc.teamcode.commands;

import com.seattlesolvers.solverslib.command.SequentialCommandGroup;

import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.subSystems.DepositSubsystem;

public class DepositCommand extends SequentialCommandGroup {
    public DepositCommand(DepositSubsystem depositSubsystem) {
        addCommands(
                new InstantCommand(() -> depositSubsystem.setPivot(DepositSubsystem.SubsystemState.BUCKET)),
                new WaitCommand(500),
                new InstantCommand(depositSubsystem::clawOpen),
                new WaitCommand(250),
                new InstantCommand(depositSubsystem::clawClose),
                new InstantCommand(() -> depositSubsystem.setPivot(DepositSubsystem.SubsystemState.NEUTRAL))
        );
        addRequirements(depositSubsystem);
    }
}
