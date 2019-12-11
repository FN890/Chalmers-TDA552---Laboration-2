import Model.Saab95;
import Model.Volvo240;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    Saab95 saab95;
    Volvo240 volvo240;

    public VehicleTest(){
        saab95 = new Saab95(new Point(50, 50));
        volvo240 = new Volvo240(new Point(50, 50));
    }

    @org.junit.jupiter.api.Test
    void testSpeedFactor() {

    }

    @org.junit.jupiter.api.Test
    void testMove() {
    }

    @org.junit.jupiter.api.Test
    void testTurnLeft() {

    }

    @org.junit.jupiter.api.Test
    void testTurnRight() {

    }

    @org.junit.jupiter.api.Test
    void testGas(){

    }



    @org.junit.jupiter.api.Test
    void testBrake(){

    }
}