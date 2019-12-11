package View;

import Model.*;

import java.awt.*;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

/*
S-Single Responsibility Principle

    Model.Loadable - Only focus to add and remove items from list.

O-Open Closed Principle

    Model.AbstractVehicle - Can extend and add methods for specific subclasses.

L-Liskovs Substitutions Principle

    Model.Volvo240/Model.Saab95 and Model.Scania can do just as much as Model.AbstractVehicle

I-Interface Segregation Principle

    Model.ILoadable and Model.IMovable does different things.
    So we can use Model.ILoadable in Garage and not Model.IMovable because
    garage should not move.

D-Dependancy Inversion Principle

    We use as wide variable as possible to store objects.
    ex, List<Model.AbstractVehicle> instead of ArrayList<Volvo250>
    and return Model.AbstractVehicle.


Refactor Plan

    Apply decomposition on View.DrawPanel to implement better SoC
    Fix HashMap to bind Model.AbstractVehicle with BufferedImage
    Check references between View.CarView, Controller.CarController, CarModel.
    Implement MVC design pattern.
    Implement Factory design pattern.
    AbstractVehicleFactory

 */


class DrawPanel extends JPanel {

    CarView carView;

    // Initializes the panel and reads the images
    DrawPanel(CarView carView, int x, int y) {
        this.carView = carView;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        // Print an error message in case file is not found with a try/catch block

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (IVehicle vehicle : carView.carController.getVehicles()){
            g.drawImage(carView.assets.get(vehicle), vehicle.getPosition().x, vehicle.getPosition().y, null);
        }
    }
}
