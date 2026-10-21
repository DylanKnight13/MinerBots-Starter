package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class DEV_Tele_1 extends OpMode {
    DcMotor leftDrive;
    DcMotor rightDrive;
    DcMotor intake;
    DcMotor launcher;
    CRServo windmill;
    CRServo leftIntake;
    CRServo rightIntake;
    @Override
    //INIT HERE
    public void init(){
        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        intake = hardwareMap.get(DcMotor.class, "intake");
        launcher = hardwareMap.get(DcMotor.class, "launcher");
        windmill = hardwareMap.get(CRServo.class, "windmill");
        leftIntake = hardwareMap.get(CRServo.class, "left_intake_servo");
        rightIntake = hardwareMap.get(CRServo.class, "right_intake_servo");
        intake.setDirection(DcMotor.Direction.REVERSE);
        leftIntake.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    //LOOP HERE
    public void loop(){
        //drive system
        double leftPower = -gamepad1.left_stick_y;
        double rightPower = gamepad1.right_stick_y;

        // Send calculated power to the two motors
        leftDrive.setPower(leftPower);
        rightDrive.setPower(rightPower);

        //launcher control
        if(gamepad1.right_trigger > 0.001){
            launcher.setPower(1);
            windmill.setPower(0.5);
        }
        else{
            launcher.setPower(0);
            windmill.setPower(0);
        }
        //intake
        if(gamepad1.left_trigger > 0.001){
            intake.setPower(1);
            rightIntake.setPower(1);
            leftIntake.setPower(1);
        }
        else{
            intake.setPower(0);
            rightIntake.setPower(0);
            leftIntake.setPower(0);
        }
    }
}
