package br.edu.ifc.blu;

import robocode.*;
import robocode.Robot;

import java.awt.*;

public class Sentinel extends Robot {
    public void run() {
        // Initialization of the robot should be put here

        // After trying out your robot, try uncommenting the import at the top,
        // and the next line:


        setBodyColor(Color.black); //cor do corpo.
        setGunColor(Color.black); //cor da arma.
        setRadarColor(Color.black); //cor do radar.
        setScanColor(Color.black); //cor do scan.
        setBulletColor(Color.black); //cor da bala.

        // Robot main loop
        while(true) {
            // Replace the next 4 lines with any behavior you would like
            this.ahead(100);
            this.turnGunRight(180);
            this.back(100);
            this.turnGunRight(360);
        }
    }

    /**
     * Evento disparado quando o scan identifica um outro robô.
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        // Replace the next line with any behavior you would like
		/*if(e.getName() != "Sentinel"){
			if(e.getDistance() < 3.0){
				fireBullet(3);
			}else{
				fireBullet(0.1);
			}

		}*/
        if(e.getVelocity() == 0.0){
            this.fireBullet(3);
        }else{
            this.turnGunRight(360);
        }
    }
	/*public void dodge(Robot enemy){
		if(enemy.getRadarHeading() < 10){
			this.turnRight(90);
			this.ahead(100);
		}
	}*/



    /**
     * onHitByBullet: What to do when you're hit by a bullet
     */
    public void onHitByBullet(HitByBulletEvent e) {
        // Replace the next line with any behavior you would like
        this.fire(100);
        this.turnRight(90); //Gira 90º para a direita.
        this.ahead(100);

    }

    /**
     * onHitWall: What to do when you hit a wall
     */
    public void onHitWall(HitWallEvent e) {
        // Replace the next line with any behavior you would like
        this.back(20);
    }
}
