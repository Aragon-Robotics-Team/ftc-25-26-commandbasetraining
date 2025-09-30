package org.firstinspires.ftc.teamcode.opModes;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Claw Wrist TeleOp")
@Config
public class ClawWristTestOpMode extends OpMode {
    Servo bar;
    public static double targetPos = 0.000;
    @Override
    public void init() {
        bar = hardwareMap.get(Servo.class, "wrist");
    } //replace with claw wrist

    @Override
    public void loop() {
        bar.setPosition(targetPos);
    }
}