package br.edu.ifc.blu;

import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import robocode.HitByBulletEvent;
import robocode.*;
import java.awt.*;

/**
 * Created by luciano on 08/09/15.
 */
public class RobotSample1 extends Robot {

        /**
         * run: Copia's default behavior
         */
        public void run() {
            //Definem as cores do robô
            setBodyColor(Color.black);
            setGunColor(Color.black);
            setRadarColor(Color.red);
            setScanColor(Color.red);
            //setBulletColor(Color.writh);

            while(true){
                turnRadarRight(360);
                ///ahead(100);
                //turnGunRight(360);
                //back(100);

            }
        }
        //Detecta os outros robôs
        public void onScannedRobot(ScannedRobotEvent e) {
            double Distancia = e.getBearing();
            double Coordenadas = getHeading() + e.getBearing() - getGunHeading();
            double PontoQuarenta = (e.getEnergy() / 4) + 0.1;

            if ( ! (Coordenadas > -180 && Coordenadas <= 180)) {
                while (Coordenadas <= -180) {
                    Coordenadas += 360;
                }
                while (Coordenadas > 180) {
                    Coordenadas -= 360;
                }
            }

            turnGunRight(Coordenadas);

            if (Distancia > 200 || getEnergy() < 15 || e.getEnergy() > getEnergy()){
                fire(1);
            } else if (Distancia > 50 ) {
                fire(2);
            } else {
                fire(PontoQuarenta);
            }
        }

        //quando o seu robo colide com outro robo
        public void onHitRobot(HitRobotEvent e) {
            tiroFatal(e.getBearing(), e.getEnergy(), getEnergy());

        }
        //Quando seu roboô leva um tiro
        public void onHitByBullet(HitByBulletEvent e) {
            turnLeft(90);
            back(100);
        }
        //Fornece as coordenadas para o ajuste do canhão.

        //É chamado quando o robô bate na parede,
        public void onHitWall(HitWallEvent e) {
            turnLeft(90);
            ahead(200);
        }
        //Dança da vitória
        public void onWin (WinEvent e) {
            turnRight(72000);
        }

        public void tiroFatal (double PosIni, double energiaIni, double minhaEnergia) {
            double Distancia = PosIni;
            double Coordenadas = getHeading() + PosIni - getGunHeading();
            double PontoQuarenta = (energiaIni / 4) + .1;
            if (!(Coordenadas > -180 && Coordenadas <= 180)) {
                while (Coordenadas <= -180) {
                    Coordenadas += 360;
                }
                while (Coordenadas > 180) {
                    Coordenadas -= 360;
                }
            }
            turnGunRight(Coordenadas);
            fire(PontoQuarenta);

        }
}
