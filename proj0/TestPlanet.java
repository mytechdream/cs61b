import java.math.*;

public class TestPlanet {

    public static void main(String[] args) {
        checkUpdate();
    }

    private static void checkEquals(double expected, double actual, String label, double eps) {
        if (Math.abs(expected - actual) <= eps * Math.max(expected, actual)) {
            System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
        }
    }

    private static void checkUpdate() {
        System.out.println("Checking update...");

        Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");

        Planet p2 = new Planet(3.0, 2.0, 3.0, 4.0, 5.0, "jupiter.gif");
        double force1 = p1.calcForceExertedBy(p2);
        double force2 = p2.calcForceExertedBy(p1);
        checkEquals(force1, force2, "pairwise force", 0.01);

    }
}
