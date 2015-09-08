package br.edu.ifc.blu;

import robocode.*;
import robocode.Robot;

import java.awt.*;

public class LucianoRobot extends Robot {
    @Override
    public void run() {
        setColors(Color.BLUE, Color.BLACK, Color.blue, Color.RED, Color.CYAN);
        back(1000);
        setDebugProperty("Teste", Double.toString(getX()));
        setDebugProperty("Teste", Double.toString(getHeading()));
        setDebugProperty("Teste", Double.toString(getBattleFieldHeight()));

        while (getY() != getBattleFieldHeight()) {
            findEnemy();
        }
    }

    private void findEnemy() {
        turnGunLeft(360);
    }

    @Override
    public void onBulletMissed(BulletMissedEvent event) {
        ahead(100);
        turnRight(40);
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        if ( ! isFriend(event)) {
            setDebugProperty("Nome", event.getName());
            fire(100);
        }

    }

    private boolean isFriend(ScannedRobotEvent event) {
        return event.getName().equals("Luciano1Robot") || event.getName().equals("Luciano2Robot") || event.getName().equals("Luciano3Robot");
    }

    @Override
    public void onBulletHitBullet(BulletHitBulletEvent event) {
        turnRight(90);
        ahead(100);
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
        for (int i = 0; i < 3; i++) {
            bigShoot(event.getBearing());
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

}