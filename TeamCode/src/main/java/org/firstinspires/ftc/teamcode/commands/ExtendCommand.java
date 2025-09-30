package org.firstinspires.ftc.teamcode.commands;

//import com.seattlesolvers.solverslib.command.CommandBase;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.SequentialCommandGroup;
import com.seattlesolvers.solverslib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subSystems.IntakeSubSystem;

public class ExtendCommand extends SequentialCommandGroup {
    public ExtendCommand(IntakeSubSystem intake) {
        addCommands(
                new InstantCommand(() -> intake.setExtendoTarget(Constants.EXTENDO_MAX)),
                new WaitCommand(300),
                new InstantCommand(() -> intake.setPivot(IntakeSubSystem.PivotState.INTAKING))
        );
    }

}