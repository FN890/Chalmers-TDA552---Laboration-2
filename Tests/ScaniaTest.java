import Model.Scania;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    private Scania scania;

    public ScaniaTest() {
        scania = new Scania(new Point(50, 50));
    }

    @Test
    void startEngine() {

    }

    @Test
    void gas() {

    }

    @Test
    void raiseFlatbed() {
        scania.startEngine();
        scania.gas(0.5);
        scania.raiseFlatbed();
        assertEquals(0, scania.getCurrentTilt());
        scania.brake(1);
        scania.raiseFlatbed();
        scania.raiseFlatbed();
        assertEquals(10, scania.getCurrentTilt());
        scania.raiseFlatbed();
        scania.raiseFlatbed();
        assertEquals(20, scania.getCurrentTilt());
    }

    @Test
    void lowerFlatBed() {
        scania.startEngine();
        scania.gas(0.5);
        scania.lowerFlatbed();
        assertEquals(0, scania.getCurrentTilt());
        scania.brake(1);
        scania.raiseFlatbed();
        scania.raiseFlatbed();
        scania.lowerFlatbed();
        assertEquals(5, scania.getCurrentTilt());
        scania.lowerFlatbed();
        assertEquals(0, scania.getCurrentTilt());
    }
}