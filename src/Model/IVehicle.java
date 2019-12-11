package Model;

import java.awt.*;

public interface IVehicle extends IMovable{

    Point getPosition();

    void startEngine();

    void stopEngine();

    void gas(double amount);

    void brake(double amount);

    void changeDirection();

    String getModelName();

    double getCurrentSpeed();

}
