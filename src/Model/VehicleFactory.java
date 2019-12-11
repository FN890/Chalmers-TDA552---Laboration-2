package Model;

import java.awt.*;
import java.util.Random;

public class VehicleFactory {

    private static Random random = new Random();

    public static IVehicle createVolvo240(Point point) {
        return new Volvo240(new Point(point));
    }

    public static IVehicle createSaab95(Point point) {
        return new Saab95(new Point(point));
    }

    public static IVehicle createScania(Point point) {
        return new Scania(new Point(point));
    }

    public static IVehicle createRandomVehicle(Point point) {
        int i = random.nextInt(3);
        switch (i) {
            case 0:
                return createSaab95(point);
            case 1:
                return createVolvo240(point);
            case 2:
                return createScania(point);
            default:
                break;
        }
        return createVolvo240(point);
    }
}
