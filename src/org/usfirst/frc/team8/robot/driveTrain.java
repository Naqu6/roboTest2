package org.usfirst.frc.team8.robot;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;

public class driveTrain {
	private Victor leftVic1 = new Victor(1);
	private Victor leftVic2 = new Victor(2);
	
	private Victor rightVic1 = new Victor(3);
	private Victor rightVic2 = new Victor(4);


	private Encoder leftEncoder = new Encoder(1,2);
	private Encoder rightEncoder = new Encoder(3,4);

	private PIDController leftPIDController1;
	private PIDController leftPIDController2;

	private PIDController rightPIDController1;
	private PIDController rightPIDController2;
	
	public void driveDistance(float distance) {
		leftPIDController1.setSetpoint(distance);
		leftPIDController2.setSetpoint(distance);

		rightPIDController1.setSetpoint(distance);
		rightPIDController2.setSetpoint(distance);
	}

	
	public void setSpeed(float rotateSpeed,float moveSpeed) {
		setLeft(-(moveSpeed - rotateSpeed));
		setRight(moveSpeed + rotateSpeed);
	}
	
	private void setLeft(float speed)
	{
		leftVic1.set(speed);
		leftVic2.set(speed);

	}
	private void setRight(float speed)
	{
		rightVic1.set(speed);
		rightVic2.set(speed);

	}



}
