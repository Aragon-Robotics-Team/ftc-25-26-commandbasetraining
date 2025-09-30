package org.firstinspires.ftc.teamcode.opModes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.commands.BucketCommand;
import org.firstinspires.ftc.teamcode.commands.TransferCommand;
import org.firstinspires.ftc.teamcode.subSystems.DepositSubsystem;
import org.firstinspires.ftc.teamcode.subSystems.IntakeSubSystem;

@TeleOp(name = "Outreach Teleop")
public class OutreachOpMode extends CommandOpMode {
    public GamepadEx gamePad1;
    DepositSubsystem deposit;
    IntakeSubSystem intake;

    @Override
    public void initialize () {
        super.reset();
        deposit = new DepositSubsystem(hardwareMap, "deposit");
        intake = new IntakeSubSystem(hardwareMap, "intake");
        gamePad1 = new GamepadEx(gamepad1);
        gamePad1.getGamepadButton(GamepadKeys.Button.A).whenPressed(new BucketCommand(deposit));
        gamePad1.getGamepadButton(GamepadKeys.Button.B).whenPressed(new TransferCommand(intake));
        gamePad1.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenPressed(new InstantCommand(() -> deposit.clawOpen()));
        gamePad1.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenPressed(new InstantCommand(() -> deposit.clawClose()));
    }

    @Override
    public void run() {
        super.run();
    }
}
