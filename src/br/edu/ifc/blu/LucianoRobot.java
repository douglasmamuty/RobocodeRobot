package br.edu.ifc.blu;

import robocode.*;
import robocode.Robot;

import java.awt.*;

public class LucianoRobot extends Robot {

    @Override
    public void run() {
        setColors(Color.BLUE, Color.BLACK, Color.blue, Color.RED, Color.CYAN);
        back(1000);

        while (getY() != getBattleFieldHeight()) {
            findEnemy();
        }
    }

    private void findEnemy() {
        ahead(10);
        turnLeft(10);
        turnGunLeft(360);
    }

    @Override
    public void onBulletMissed(BulletMissedEvent event) {
        ahead(100);
        turnRight(40);
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        if ( ! isFriend(event.getName())) {
            bigShoot(event.getBearing());
        }
    }

    private boolean isFriend(String robotName) {
        setDebugProperty("Name enemy: ", robotName);
        return robotName.startsWith("br")
                || robotName.startsWith("Luciano");
    }

    @Override
    public void onBulletHitBullet(BulletHitBulletEvent event) {
        turnRight(90);
        ahead(100);
        turnLeft(90);
    }

    @Override
    public void onWin(WinEvent event) {
        turnLeft(40);
        turnRight(30);
        turnLeft(40);
        turnRight(10);
        turnLeft(40);

    }

    @Override
    public void onHitRobot(HitRobotEvent event) {
        if ( ! isFriend(event.getName())) {
            for (int i = 0; i < 1; i++) {
                bigShoot(event.getBearing());
            }
        }

    }

    private void bigShoot(double initialPositionEnemy) {
        turnGunRight(fixCoordinators(getHeading() + initialPositionEnemy - getGunHeading()));
        fire(100);
    }

    private double fixCoordinators(double coordinate) {
        if ( ! ( coordinate > -180 && coordinate <= 180)) {
            while (coordinate <= -180) {
                coordinate += 360;
            }
            while (coordinate > 180) {
                coordinate -= 360;
            }
        }

        return coordinate;
    }

    @Override
    public void onHitByBullet(HitByBulletEvent event) {
        if (event.getName().equalsIgnoreCase("sample.Tracker")) {
            bigShoot(event.getBearing());
        }
    }
}