package org.firstinspires.ftc.teamcode.old;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;
@TeleOp(name = "Drive Forward")
public class DriveOpmode extends CommandOpMode {
    public GamepadEx driver1;
    DriveSubsystem drive;

    @Override
    public void initialize () {
        super.reset();
        drive = new DriveSubsystem(hardwareMap, "drive");
        driver1 = new GamepadEx(gamepad1);
        driver1.getGamepadButton(GamepadKeys.Button.A).whenPressed(new DriveForwardCommand(drive));
        driver1 = new GamepadEx(gamepad1);
        driver1.getGamepadButton(GamepadKeys.Button.A).whenPressed(new DriveForwardCommand(drive));
    }

    @Override
    public void run() {
        super.run();
    }
}
