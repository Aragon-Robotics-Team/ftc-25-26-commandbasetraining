package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.seattlesolvers.solverslib.command.SubsystemBase;

public class BraydenSubSystem extends SubsystemBase {
    private final Servo clawServo;
    public BraydenSubSystem(final HardwareMap hMap, final String name) {
        clawServo = hMap.get(Servo.class, name);
    }

    public void clawOpen(){
        clawServo.setPosition(1.0);
    }

    public void clawClose() {
        clawServo.setPosition(0.0);
    }


}
