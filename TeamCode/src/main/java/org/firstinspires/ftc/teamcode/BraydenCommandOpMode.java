package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.robot.Robot;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.button.Button;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;
@TeleOp(name = "TestTeleop917")
public class BraydenCommandOpMode extends CommandOpMode {
    public GamepadEx driver1;

    BraydenSubSystem claw;

    @Override
    public void initialize() {
        super.reset();
        claw = new BraydenSubSystem(hardwareMap, "claw");
        driver1 = new GamepadEx(gamepad1); //linking gampad1 using gamepadEx wrapper
        Button clawCloseButton = driver1.getGamepadButton(GamepadKeys.Button.A);
        clawCloseButton.whenPressed(new ClawClose(claw));

        Button crabButton = driver1.getGamepadButton(GamepadKeys.Button.B);
        crabButton.whenPressed(new CrabCommand(claw));



    }

    @Override
    public void run() {
        super.run();
    }


}
