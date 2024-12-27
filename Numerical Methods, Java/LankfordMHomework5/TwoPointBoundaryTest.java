import static java.lang.Math.*;
import static java.lang.Math.abs;

public class TwoPointBoundaryTest {
    public static void main(String[] args) {

        //Variable declarations--------------------------------------------------------------------
        double stepSize = .025;
        double numSteps = 40;
        double t = 0.0;

        double x0 = 0.7;
        double x1 = 1.0;
        double fxn;
        double fxnm1;
        double newX;

        //Coefficients-----------------------------------------------------------------------------
        // a = {a1, a2, a3}
        double[] a = {(1.0 / 5.0), (3.0 / 5.0), 1.0};

        //b = {b10, b20, b21, b30, b31, b32}
        double[] b = {(1.0 / 5.0), -(2.0 / 5.0), (1.0), (23.0 / 13.0), -(30.0 / 13.0), (20.0 / 13.0)};

        //c = {c0, c1, c2, c3}
        double[] c = {(1.0 / 12.0), (25.0 / 96.0), (25.0 / 48.0), (13.0 / 96.0)};


        //Call Runge Kutta method for while condition
        TwoPointBoundary tpb1 = new TwoPointBoundary(numSteps, stepSize, x0, t, a, b, c, 0);
        double rungeKuttaS1 = tpb1.rungeKutta();

        fxn = x0 + rungeKuttaS1 - 3.0;

        //Print out top lines of the table
        System.out.printf("%20s%20s%20s\n", "x0", "x1", "x0 + x1 - 3.0");
        System.out.printf("%20.9e%20.9e%20.9e\n", x0, x1, x0 +x1 - 3.0);

        while ((abs(fxn) > pow(10, -4))) {

            //Call Runge Kutta method for fxn
            tpb1 = new TwoPointBoundary(numSteps, stepSize, x0, t, a, b, c, 0);
            rungeKuttaS1 = tpb1.rungeKutta();

            fxn = x0 + rungeKuttaS1 - 3.0;

            //Call Runge Kutta method for fxnm1
            tpb1 = new TwoPointBoundary(numSteps, stepSize, x1, t, a, b, c, 0);
            double rungeKuttaS2 = tpb1.rungeKutta();

            fxnm1 = x1 + rungeKuttaS2 - 3.0;

            //Calculate new x
            newX = x0 - (fxn * ((x0 - x1) / (fxn - fxnm1)));

            //Assign new values to x1 and x0
            x1 = x0;
            x0 = newX;

            //Print out values of x0, x1, and x0+x1-3
            System.out.printf("%20.9e%20.9e%20.9e\n", x0, x1, x0 + x1 - 3.0);
        }

        //Call Runge Kutta method to print out final values of t and x
        System.out.print("\n");
        tpb1 = new TwoPointBoundary(numSteps, stepSize, x0, t, a, b, c, 1);
        rungeKuttaS1 = tpb1.rungeKutta();
    }
}