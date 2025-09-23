package org.firstinspires.ftc.teamcode;

public class Constants {
    private Constants(){}

    //bar
    public final static double BAR_TRANSFER = 0.80;
    public final static double BAR_AUTOINIT = 0.723;
    public final static double BAR_WALL = 0.95;
    public final static double BAR_BUCKET = 0.25;
    public final static double BAR_CLIP = 0;
    public final static double BAR_NEUTRAL = 0.6;

    //wrist
    public final static double WRIST_TRANSFER = 0.10;
    public final static double WRIST_AUTOINIT = 0;
    public final static double WRIST_WALL = 0.29;
    public final static double WRIST_BUCKET = 0.77;
    public final static double WRIST_CLIP = 1;
    public final static double WRIST_NEUTRAL = 0.2;
    
    //claw
    public final static double CLAW_OPEN = 0.55;
    public final static double CLAW_CLOSE = 0.78;
    public final static double CLAW_SUPEROPEN = 0.5;

    //extendo
    //pid values: p=0.010, i=0, d=0.00015, f=0;
    public final static int EXTENDO_MAX = 2000;
    public final static int EXTENDO_MIN = -250;
    public final static int EXTENDO_MED= 900;

    //led
    public final static double LED_RED = 0.279;
    public final static double LED_YELLOW = 0.35;
    public final static double LED_BLUE = 0.6;
    public final static double LED_WHITE = 1;
}
