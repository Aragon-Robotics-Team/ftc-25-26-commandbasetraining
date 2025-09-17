package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.robot.Robot;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.button.Button;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

public class BraydenCommandOpMode extends CommandOpMode {
    public GamepadEx driver1;
    BraydenSubSystem claw = new BraydenSubSystem(hardwareMap, "claw");

    @Override
    public void initialize() {
        super.reset();
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
