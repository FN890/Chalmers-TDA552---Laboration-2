package View;

import Controller.CarController;
import Model.IVehicle;

import javax.swing.*;
import java.awt.*;

public class ExtraGui {

    private final CarView carView;
    private final StringBuilder stringBuilder = new StringBuilder();
    private final JLabel labelSpeed = new JLabel("<html>Speed of Cars: <br>");

    public ExtraGui(CarView carView) {
        this.carView = carView;
    }

    void createExtraGui() {

        JFrame frame = new JFrame("Extra GUI");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        JButton addRandomCar = new JButton("Add a Random Car");
        frame.getContentPane().add(addRandomCar);
        frame.getContentPane().add(labelSpeed);
        frame.setVisible(true);

        addRandomCar.addActionListener(e -> carView.carController.addVehicle());

    }

    void setSpeed(IVehicle iVehicle) {
        stringBuilder.append(iVehicle.getModelName()).append(": ").append(iVehicle.getCurrentSpeed()).append("<br>");
    }

    public void setText() {
        stringBuilder.append("</html>");
        labelSpeed.setText(stringBuilder.toString());
    }

    public void resetText() {
        stringBuilder.setLength(0);
        stringBuilder.append("<html> <h1>Car Speed:</h1><br> <br>");
    }
}
