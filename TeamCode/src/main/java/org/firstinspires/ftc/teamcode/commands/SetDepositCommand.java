package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.util.ElapsedTime;
import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.old.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subSystems.DepositSubsystem;

public class SetDepositCommand extends CommandBase {
    private final DepositSubsystem depositSubsystem;

    public SetDepositCommand(DepositSubsystem subsystem) {
        depositSubsystem = subsystem;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(depositSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
