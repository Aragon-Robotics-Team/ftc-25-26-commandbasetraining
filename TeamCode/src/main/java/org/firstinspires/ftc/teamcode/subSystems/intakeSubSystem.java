package org.firstinspires.ftc.teamcode.subSystems;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.seattlesolvers.solverslib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.commands.intakePiece;


public class intakeSubSystem extends SubsystemBase { //intake subsystem setup

    enum PivotState {
        INTAKING, TRANSFER, TUCKED

    }

    enum ExtendoState {
        EXTENDED, TRANSFER, TUCKED
    }

    enum IntakeState {
        FORWARD, REVERSE, STOP
    }

    public PivotState pivotState  = PivotState.TUCKED;
    private DcMotor extendo;
    private Servo intakeWrist;
    private DcMotor flyWheel;
    //methods: setPivot, setExtendoTarget, setIntake

    public intakeSubSystem(final HardwareMap hMap,final String name) {
        intakeWrist = hMap.get(Servo.class, name); //do not to specify run using when servo
        flyWheel = hMap.get(DcMotor.class, name);
        flyWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER); // make sure to specify run mode when using DCMOTOR
        extendo = hMap.get(DcMotor.class, name);
        extendo.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    /*
    public void intakeFlyWheel() {
        flyWheel.setPower(1.0); //replace with constant
    }

    public void wristDown() {
        intakeWrist.setPosition(1.0); //replace with constant
    }

    public void wristUp() {
        intakeWrist.setPosition(0.0); //replace with constant
    }

     */


    public void setPivot(PivotState state) {
        switch (state) {
            case TUCKED:
                intakeWrist.setPosition(0.0); //replace with constant UP
                break;
            case TRANSFER:
                intakeWrist.setPosition(0.0); //replace with constant UP
                break;
            case INTAKING:
                intakeWrist.setPosition(1.0); //replace with constant DOWN
                break;

        }

    }

    public void setExtendoTarget(ExtendoState state) {
        switch (state) {
            case TUCKED:
                extendo.setTargetPosition(1); //replace with PID + constants
                break;
            case TRANSFER:
                // add possible logic like IF already tucked then you don't need to change transfer
                extendo.setTargetPosition(1); //replace with PID + constants
                break;
            case EXTENDED:
                extendo.setTargetPosition(1); //replace with PID + constants
                break;
        }
    }

    public void setIntake(IntakeState state) {
        switch (state) {
            case STOP:
                flyWheel.setTargetPosition(0); //stopped
                break;
            case REVERSE:
                flyWheel.setTargetPosition(0); //replace with constant or the # of rotations
                break;
            case FORWARD:
                flyWheel.setTargetPosition(0); //replace with constant or the # of rotations
                break;
        }
    }

}
