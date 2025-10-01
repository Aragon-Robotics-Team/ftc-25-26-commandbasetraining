package org.firstinspires.ftc.teamcode.opModes;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.commands.BucketCommand;
import org.firstinspires.ftc.teamcode.commands.TransferCommand;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;
import org.firstinspires.ftc.teamcode.subSystems.DepositSubsystem;
import org.firstinspires.ftc.teamcode.subSystems.IntakeSubSystem;

@TeleOp(name = "Outreach Teleop")
public class OutreachOpMode extends CommandOpMode {
    private Follower follower;
    public static Pose startingPose = new Pose(0,0,0);





    public GamepadEx driver1 = new GamepadEx(gamepad1);;
    DepositSubsystem deposit;
    IntakeSubSystem intake;

    @Override
    public void initialize () {

        super.reset();

        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(startingPose == null ? new Pose() : startingPose);
        follower.update();


        deposit = new DepositSubsystem(hardwareMap);
        intake = new IntakeSubSystem(hardwareMap);
        driver1.getGamepadButton(GamepadKeys.Button.A).whenPressed(new BucketCommand(deposit));
        driver1.getGamepadButton(GamepadKeys.Button.B).whenPressed(new TransferCommand(intake, deposit));
        driver1.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenPressed(new InstantCommand(() -> deposit.clawOpen()));
        driver1.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenPressed(new InstantCommand(() -> deposit.clawClose()));
    }


    @Override
    public void run() {
        follower.setTeleOpDrive(driver1.getLeftY(), driver1.getLeftX(), driver1.getRightX(), true);
        follower.update();
        super.run();
    }
}
