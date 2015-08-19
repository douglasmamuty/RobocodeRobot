package br.edu.ifc.blu;

import robocode.Robot;
import robocode.ScannedRobotEvent;

import java.awt.*;

/**
 * Created by luciano on 18/08/15.
 */
public class LucianoRobot extends Robot {
    @Override
    public void run() {
        setColors(Color.BLUE, Color.BLACK, Color.blue, Color.RED, Color.CYAN);



        back(1000);
        setDebugProperty("Teste", Double.toString(getX()));
        setDebugProperty("Teste", Double.toString(getHeading()));
        setDebugProperty("Teste", Double.toString(getBattleFieldHeight()));


        while (getY() != getBattleFieldHeight()) {
            turn
        }
        findEnemy();
    }

    private void findEnemy() {
        turnGunLeft(360);

    }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        fire(100);
    }
}
