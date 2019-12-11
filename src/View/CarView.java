package View;

import Controller.CarController;
import Model.IVehicle;

import static Model.CarModel.GAME_WIDTH;
import static Model.CarModel.GAME_HEIGHT;

import javax.swing.*;
import java.awt.*;


/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame implements AnimateListener {

    CarController carController;

    DrawPanel drawPanel = new DrawPanel(this, GAME_WIDTH, GAME_HEIGHT - 240);
    ExtraView extraView = new ExtraView(this);

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 50;
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    Assets assets = new Assets();

    // Constructor
    public CarView(String framename) {
        initComponents(framename);
    }

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        drawPanel.setBackground(Color.LIGHT_GRAY);
        this.add(drawPanel);

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(50, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(e -> {
            gasAmount = (int) ((JSpinner) e.getSource()).getValue();
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2, 4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((GAME_WIDTH / 2) + 4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.GRAY);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(GAME_WIDTH / 5 - 15, 200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.red);
        stopButton.setPreferredSize(new Dimension(GAME_WIDTH / 5 - 15, 200));
        this.add(stopButton);

        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary

        gasButton.addActionListener(e -> carController.gas(gasAmount));

        //Full brake
        brakeButton.addActionListener(e -> carController.brake(gasAmount));

        turboOnButton.addActionListener(e -> carController.turboOn());

        turboOffButton.addActionListener(e -> carController.turboOff());

        liftBedButton.addActionListener(e -> carController.liftBed());

        lowerBedButton.addActionListener(e -> carController.lowerBed());

        startButton.addActionListener(e -> carController.startEngine());

        stopButton.addActionListener(e -> carController.stopEngine());

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        // Make the frame visible

        extraView.createExtraGui();

        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void setCarController(CarController carController) {
        this.carController = carController;
    }

    @Override
    public void onUpdate() {

        extraView.resetText();
        for (IVehicle vehicle : carController.getVehicles()) {
            extraView.setSpeed(vehicle);
        }
        extraView.setText();
        repaint();
    }

    public void addVehicle(IVehicle vehicle, String imagePath) {
        assets.bind(vehicle, imagePath);
    }

}