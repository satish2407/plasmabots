package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Auto Forward 10 Inches", group="Autonomous")
public class AutoForward10Inches extends LinearOpMode {

    // Declare OpMode members for configured hardware
    private DcMotor left_drive = null;
    private DcMotor right_drive = null;

    // Drive speed constant
    static final double DRIVE_SPEED = 0.4;

    @Override
    public void runOpMode() {
        // Initialize the hardware variables
        left_drive = hardwareMap.get(DcMotor.class, "left_drive");
        right_drive = hardwareMap.get(DcMotor.class, "right_drive");

        // Set motor directions
        left_drive.setDirection(DcMotor.Direction.FORWARD);
        right_drive.setDirection(DcMotor.Direction.REVERSE);

        // Set motors to run without encoders for time-based driving
        left_drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        right_drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "Initialized");
        telemetry.addData("Action", "Ready to drive forward 10 inches");
        telemetry.update();

        waitForStart();

        // Run autonomous sequence
        if (opModeIsActive()) {
            // Drive forward for 2 seconds
            left_drive.setPower(DRIVE_SPEED);
            right_drive.setPower(DRIVE_SPEED);

            sleep(2000);  // Drive for 2 seconds

            // Stop motors
            left_drive.setPower(0);
            right_drive.setPower(0);

            // Display completion message
            telemetry.addData("Status", "Complete");
            telemetry.addData("Path", "Drove forward for 2 seconds");
            telemetry.update();
            sleep(1000);
        }
    }
}
