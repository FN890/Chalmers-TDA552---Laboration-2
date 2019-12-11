package Model;

import java.awt.*;

public abstract class AbstractVehicle implements IVehicle {

    /**
     * Number of doors on the vehicle.
     */
    int nrDoors;
    /**
     * Engine power of the vehicle.
     */
    double enginePower;
    /**
     * The current speed of the vehicle.
     */
    double currentSpeed;
    /**
     * Color of the vehicle.
     */
    Color color;
    /**
     * The vehicle model name
     */
    String modelName;
    /**
     * position of vehicle.
     */
    Point position;
    /**
     * Current direction of the vehicle.
     */
    int direction;
    /**
     * Weight of vehicle (KG)
     */
    int weight;

    /**
     * Is the car already loaded.
     */
    boolean isLoaded;

    /**
     * IS the car started
     */
    boolean isStarted;

    private int width;

    public int getWidth(){
        return width;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    @Override
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    @Override
    public Point getPosition(){
        return new Point(position);
    }

    /**
     * Starts the engine
     */
    @Override
    public void startEngine() {
        //currentSpeed = 0.1;
        isStarted = true;
    }

    /**
     * Stops the engine
     */
    @Override
    public void stopEngine() {
        currentSpeed = 0;
        isStarted = false;
    }

    /**
     * @return Returns the current speedfactor
     */
    abstract double speedFactor();


    /**
     * @param amount Factor for incrementing speed.
     */
    void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    /**
     * @param amount Factor for decrementing speed.
     */
    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    @Override
    public String getModelName(){
        return modelName;
    }

    /**
     * @param amount Gas factor, must be [0,1]
     */
    @Override
    public void gas(double amount) {
        if (amount >= 0 && amount <= 1 && !isLoaded && isStarted) {
            incrementSpeed(amount);
        }
    }

    /**
     * @param amount Brake factor, must be [0,1]
     */
    @Override
    public void brake(double amount) {
        if (amount >= 0 && amount <= 1)
            decrementSpeed(amount);
    }


    @Override
    public void move() {
        switch (direction) {
            case 0:
                position.x += currentSpeed;
                break;
            case 1:
                position.y += currentSpeed;
                break;
            case 2:
                position.x -= currentSpeed;
                break;
            case 3:
                position.y -= currentSpeed;
                break;
        }
    }


    @Override
    public void turnLeft() {
        direction = ((((direction - 1) % 4) + 4) % 4);
    }


    @Override
    public void turnRight() {
        direction = (direction + 1) % 4;
    }

    @Override
    public void changeDirection(){
        direction = (direction + 2) % 4;
    }
}
