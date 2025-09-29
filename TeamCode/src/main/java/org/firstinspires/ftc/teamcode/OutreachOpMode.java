package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.commands.DepositCommand;
import org.firstinspires.ftc.teamcode.subSystems.DepositSubsystem;

@TeleOp(name = "Outreach Teleop")
public class OutreachOpMode extends CommandOpMode {
    public GamepadEx bucket;
    DepositSubsystem deposit;

    @Override
    public void initialize () {
        super.reset();
        deposit = new DepositSubsystem(hardwareMap, "deposit");
        bucket = new GamepadEx(gamepad1);
        bucket.getGamepadButton(GamepadKeys.Button.A).whenPressed(new DepositCommand(deposit));
    }

    @Override
    public void run() {
        super.run();
    }
}
