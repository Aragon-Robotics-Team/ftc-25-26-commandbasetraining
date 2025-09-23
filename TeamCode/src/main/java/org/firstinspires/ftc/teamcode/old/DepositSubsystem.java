package org.firstinspires.ftc.teamcode.old;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants;

public class DepositSubsystem {
    // bar, wrist, claw

    private Servo bar;
    private Servo wrist;
    private Servo claw;

    enum subsystemState {
        TRANSFER, AUTOINIT, WALL, BUCKET, CLIP, NEUTRAL;
    }

    private subsystemState depositState = subsystemState.NEUTRAL;

    public DepositSubsystem(final HardwareMap hMap, final String name) {
        bar = hMap.get(Servo.class, "bar");
        wrist = hMap.get(Servo.class, "wrist");
        claw = hMap.get(Servo.class, "claw");
    }

    public void clawOpen() {
        claw.setPosition(Constants.CLAW_OPEN);
    }

    public void clawClose() {
        claw.setPosition(Constants.CLAW_CLOSE);
    }

    public void setPivot(subsystemState state) {
        switch (state) {
            case TRANSFER:
                bar.setPosition(Constants.BAR_TRANSFER);
                wrist.setPosition(Constants.WRIST_TRANSFER);
                break;
            case AUTOINIT:
                bar.setPosition(Constants.BAR_AUTOINIT);
                wrist.setPosition(Constants.WRIST_AUTOINIT);
                break;
            case WALL:
                bar.setPosition(Constants.BAR_WALL);
                wrist.setPosition(Constants.WRIST_WALL);
                break;
            case BUCKET:
                bar.setPosition(Constants.BAR_BUCKET);
                wrist.setPosition(Constants.WRIST_BUCKET);
                break;
            case CLIP:
                bar.setPosition(Constants.BAR_CLIP);
                wrist.setPosition(Constants.WRIST_CLIP);
                break;
            case NEUTRAL:
                bar.setPosition(Constants.BAR_NEUTRAL);
                wrist.setPosition(Constants.WRIST_NEUTRAL);
                break;
        }

        depositState = state;
    }
}
