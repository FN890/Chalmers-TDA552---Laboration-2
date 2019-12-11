package View;

import Controller.CarController;
import Model.IVehicle;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class ExtraView {

    private final CarView carView;
    private final StringBuilder stringBuilder = new StringBuilder();
    private final JTextPane speedPane = new JTextPane();

    public ExtraView(CarView carView) {
        this.carView = carView;
    }

    void createExtraGui() {

        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);

        speedPane.setEditable(false);
        StyledDocument speedPaneDoc = speedPane.getStyledDocument();
        speedPaneDoc.setParagraphAttributes(0, speedPaneDoc.getLength(), center, false);
        JScrollPane speedPaneScroll = new JScrollPane(speedPane);

        JButton addRandomCar = new JButton("Add a Random Car");
        JButton removeLatestCar = new JButton("Remove latest added Car");

        JFrame frame = new JFrame("Extra View");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.setResizable(false);

        frame.getContentPane().add(removeLatestCar, BorderLayout.PAGE_START);
        frame.getContentPane().add(addRandomCar, BorderLayout.PAGE_END);
        frame.getContentPane().add(speedPaneScroll, BorderLayout.CENTER);
        frame.setVisible(true);

        addRandomCar.addActionListener(e -> carView.carController.addVehicle());
        removeLatestCar.addActionListener(e -> carView.carController.removeVehicle());

    }

    void setSpeed(IVehicle iVehicle) {
        stringBuilder.append(iVehicle.getModelName()).append(": ").append(iVehicle.getCurrentSpeed()).append("\n");
    }

    public void setText() {
        stringBuilder.append("\n");
        speedPane.setText(stringBuilder.toString());
    }

    public void resetText() {
        stringBuilder.setLength(0);
        stringBuilder.append("\nCar Speed:\n\n\n");
    }
}
