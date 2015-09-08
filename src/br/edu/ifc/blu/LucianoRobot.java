package br.edu.ifc.blu;

import robocode.BulletHitBulletEvent;
import robocode.BulletMissedEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

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
        if ( ! isFrindy(event)) {
            setDebugProperty("Nome", event.getName());
            fire(100);
        }

    }

    private boolean isFrindy(ScannedRobotEvent event) {
        return event.getName().equals("Luciano1Robot") || event.getName().equals("Luciano2Robot") || event.getName().equals("Luciano3Robot");
    }

    @Override
    public void onBulletHitBullet(BulletHitBulletEvent event) {
        turnRight(90);
        ahead(100);
    }


}