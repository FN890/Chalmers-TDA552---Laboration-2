package Model;

import View.AnimateListener;
import View.Assets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarModel {

    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 800;
    private final int delay = 5;
    private Timer timer = new Timer(delay, new TimerListener());

    private final List<IVehicle> vehicles = new ArrayList<>();
    private final List<AnimateListener> animateListeners = new ArrayList<>();

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            for (IVehicle vehicle : vehicles) {

                withinBoundsHandler(vehicle, GAME_WIDTH - 100);
                vehicle.move();
            }
            notifyListeners();
        }
    }

    private void withinBoundsHandler(IVehicle vehicle, int width) {
        if (vehicle.getPosition().x > width) {
            vehicle.changeDirection();
        } else if (vehicle.getPosition().x < 0) {
            vehicle.changeDirection();
        }
    }

    public void addListener(AnimateListener l) {
        animateListeners.add(l);
    }

    private void notifyListeners() {
        animateListeners.forEach(AnimateListener::onUpdate);
    }

    public void startTimer() {
        timer.start();
    }

    public List<IVehicle> getVehicles() {
        return vehicles;
    }

    private int getXPos() {
        if (vehicles.size() % 4 == 0) {
            return 150 * (vehicles.size() / 4 + 1);
        }
        return (int) (150 * (Math.ceil((vehicles.size() + 1) / 4.0)));
    }

    private int getYPos() {
        return 100 * ((vehicles.size() % 4) + 1);
    }

    public void addVehicle() {
        if (vehicles.size() < 10) {
            vehicles.add(VehicleFactory.createRandomVehicle(new Point(getXPos(), getYPos())));
        }
    }

    public void removeVehicle() {
        if (!vehicles.isEmpty()){
            vehicles.remove(vehicles.size() -1);
        }
    }

}
