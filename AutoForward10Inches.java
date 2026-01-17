ackage org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Autonomous(name = "DecryptersSoloRun2 (Blocks to Java)")
public class DecryptersSoloRun2 extends LinearOpMode {

  private DcMotor left_drive;
  private DcMotor right_drive;
  private DcMotor launcher;
  private CRServo rightfeeder;
  private CRServo leftfeeder;

  /**
   * This sample contains the bare minimum Blocks for any regular OpMode. The 3 blue
   * Comment Blocks show where to place Initialization code (runs once, after touching the
   * DS INIT button, and before touching the DS Start arrow), Run code (runs once, after
   * touching Start), and Loop code (runs repeatedly while the OpMode is active, namely not
   * Stopped).
   */
  @Override
  public void runOpMode() {
    left_drive = hardwareMap.get(DcMotor.class, "left_drive");
    right_drive = hardwareMap.get(DcMotor.class, "right_drive");
    launcher = hardwareMap.get(DcMotor.class, "launcher");
    rightfeeder = hardwareMap.get(CRServo.class, "rightfeeder");
    leftfeeder = hardwareMap.get(CRServo.class, "leftfeeder");

    waitForStart();
    if (opModeIsActive()) {
      left_drive.setPower(0.5);
      right_drive.setPower(-0.5);
      sleep(1450);
      left_drive.setPower(0);
      right_drive.setPower(0);
      sleep(500);
      launcher.setPower(0.63);
      sleep(4000);
      telemetry.addData("Launcher speed", ((DcMotorEx) launcher).getVelocity());
      telemetry.update();
      for (int count = 0; count < 3; count++) {
        rightfeeder.setPower(-1);
        leftfeeder.setPower(1);
        sleep(500);
        leftfeeder.setPower(0);
        rightfeeder.setPower(0);
        telemetry.addData("Launcher speed", ((DcMotorEx) launcher).getVelocity());
        telemetry.update();
        sleep(2000);
      }
      sleep(500);
      left_drive.setPower(0.5);
      right_drive.setPower(-0.5);
      sleep(2000);
      left_drive.setPower(0);
      right_drive.setPower(0);
    }
  }
}
