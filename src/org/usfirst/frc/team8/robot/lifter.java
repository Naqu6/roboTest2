package org.usfirst.frc.team8.robot;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;

public class lifter {
	private Victor lifterVictor1;
	private Victor lifterVictor2;

	private PIDController lifterPIDController1;
	private PIDController lifterPIDController2;

	private Encoder lifterEncoder;
	enum State{
		TELEOP,
		PID_CONTROL
	};

	private State lifterState;

	public void setLifter(float value) {
		if (lifterState == State.PID_CONTROL) {
			if ((lifterEncoder.getStopped() == true) && (getLifterError())) {
				lifterState = State.TELEOP;
			}
		} else {
			setLifterVictors(value);
			lifterState = State.PID_CONTROL;
		}
	}
	private boolean getLifterError() {
		int lifter1Error = (int) lifterPIDController1.getError();
		int lifter2Error = (int) lifterPIDController2.getError();
		if (Math.max(lifter1Error,lifter2Error) == 0) {
			return true;
		} else {
			return false;
		}
	}
	private void setLifterVictors(float value) {
		lifterVictor2.set(value);
		lifterVictor1.set(value);
	}
}
