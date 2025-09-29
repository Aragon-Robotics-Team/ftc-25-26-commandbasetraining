package org.firstinspires.ftc.teamcode.opModes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.commands.DepositCommand;
import org.firstinspires.ftc.teamcode.commands.intakePieceCommand;
import org.firstinspires.ftc.teamcode.subSystems.DepositSubsystem;
import org.firstinspires.ftc.teamcode.subSystems.intakeSubSystem;

@TeleOp(name = "Outreach Teleop")
public class OutreachOpMode extends CommandOpMode {
    public GamepadEx gamePad2;
    DepositSubsystem deposit;
    intakeSubSystem intake;

    @Override
    public void initialize () {
        super.reset();
        //assigning gamepad
        gamePad2 = new GamepadEx(gamepad2);

        //deposit
        deposit = new DepositSubsystem(hardwareMap, "deposit");
        gamePad2.getGamepadButton(GamepadKeys.Button.A).whenPressed(new DepositCommand(deposit));

        //intake
        intake = new intakeSubSystem(hardwareMap, "intake");
        gamePad2.getGamepadButton(GamepadKeys.Button.B).whenPressed(new intakePieceCommand(intake));

    }

    @Override
    public void run() {
        super.run();
    }
}
