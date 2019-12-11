package Controller;

import Model.*;
import View.CarView;

import java.util.List;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {

    private CarView carView;
    private CarModel carModel;

    public CarController(CarModel carModel, CarView carView) {
        this.carView = carView;
        carView.setCarController(this);
        this.carModel = carModel;
    }

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (IVehicle car : carModel.getVehicles()) {
            car.gas(gas);
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (IVehicle car : carModel.getVehicles()) {
            car.brake(brake);
        }
    }

    public void turboOn() {
        for (IVehicle car : carModel.getVehicles()) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    public void turboOff() {
        for (IVehicle car : carModel.getVehicles()) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    public void liftBed() {
        for (IVehicle car : carModel.getVehicles()) {
            if (car instanceof Scania) {
                ((Scania) car).raiseFlatbed();
            }
        }
    }

    public void lowerBed() {
        for (IVehicle car : carModel.getVehicles()) {
            if (car instanceof Scania) {
                ((Scania) car).lowerFlatbed();
            }
        }
    }

    public void startEngine() {
        for (IVehicle car : carModel.getVehicles()) {
            car.startEngine();
        }
    }

    public void stopEngine() {
        for (IVehicle car : carModel.getVehicles()) {
            car.stopEngine();
        }
    }

    public List<IVehicle> getVehicles() {
        return carModel.getVehicles();
    }

    public void addVehicle() {
        carModel.addVehicle();
        bindVehicles();
    }

    public void bindVehicles() {
        for (IVehicle vehicle : carModel.getVehicles()) {
            switch (vehicle.getModelName()) {
                case ("Volvo240"):
                    carView.addVehicle(vehicle, "Volvo240.jpg");
                    break;
                case ("Saab95"):
                    carView.addVehicle(vehicle, "Saab95.jpg");
                    break;
                case ("Scania"):
                    carView.addVehicle(vehicle, "Scania.jpg");
                    break;
                default:
            }
        }
    }

}
