import Controller.CarController;
import Model.CarModel;
import View.CarView;

public class Main {

    public static void main(String[] args) {
        // Instance of this class
        CarView carView = new CarView("LAB2");
        CarModel carModel = new CarModel();
        carModel.addListener(carView);
        CarController cc = new CarController(carModel, carView);
        carModel.startTimer();
    }

}
