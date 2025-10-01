package org.firstinspires.ftc.teamcode.opModes;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.acmerobotics.dashboard.*;

@TeleOp(name = "Wrist Test TeleOp")
@Config
public class WristTestOpMode extends OpMode {
    Servo wrist;
    public static double targetPos = 0.5;
    @Override
    public void init() {
        wrist = hardwareMap.get(Servo.class, "wrist");
    }

    @Override
    public void loop() {
        wrist.setPosition(targetPos);
    }
}