// Programmer: Michael Lankford
//
// Course: CSCI 3321 Section #1
//
// Date: November 12, 2022
//
// Assignment: Number 4
//
// Environment: Windows 10 Version 21H2 for x64-based Systems
//
// Files Included: RungeKuttaTest.java
//
// Purpose: Create a program that will use the Runge Kutta method to solve the given initial value problem
//
// Input: stepSize - array that represents the decimal values that will increase t with each step
//        numSteps - array that represents the total number of steps each run
//        trueVal - the true solved value of the initial value problem
//        k0, k1, k2, k3 - k values that will be used to solve the initial value problem
//        a1, a2, a3 - a coefficients that hold generated values
//        b10, b20, b21, b30, b31, b32 -  b coefficients that hold generated values
//        c0, c1, c2, c3 - c coefficients that hold generated values
//        xVal - holds both the initial value of x and the subsequent changed values of x
//        t - holds both the initial value of t and the subsequent changed values of t
//        error - used to calculate the error for each run
//
// Preconditions: Coefficients and other values are input correctly
//
// Output: A row for the step size used followed by a column of t and x values then the calculated error at t=2
//
// Postconditions: Correct values are outputted accordingly
//
// Algorithm:
//      Import cos method
//      Import pow method
//      Import absolute value method
//
//      Initialize stepSize
//      Initialize numSteps
//      Initialize trueVal
//      Initialize k0, k1, k2, k3
//      Initialize a1, a2, a3
//      Initialize b10, b20, b21, b30, b31, b32
//      Initialize c0, c1, c2, c3
//
//      Begin Loop
//          Initialize xVal
//          Initialize t
//          Initialize error
//
//          Begin Loop
//              Compute k0 = h * 3x^2 * cos(5t)
//              Compute k1 = h * 3(x + (b10 * k0))^2 * cos(5(a1 * h))
//              Compute k2 = h * 3(x + (b20 * k0) + (b21 * k1))^2 * cos(5(a2 * h))
//              Compute k3 = h * 3(x + (b30 * k0) + (b31 * k1) + (b32 * k2))^2 * cos(5(a3 * h))
//              Compute new x value = previous x + ((c0 * k0) + (c1 * k1) + (c2 * k2) + (c3 * k3))
//              Add new h to t to increase step
//              Calculate error
//          End Loop
//      End Loop
//
// Conclusions: My conclusion after making this experiment was that as h decreased, each run took longer to reach the
//                  true value of the initial value problem but it also calculated a more accurate value and produced a
//                  smaller error.
//

import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.abs;

public class RungeKuttaTest {

    public static void main(String[] args){

        //Variable declarations--------------------------------------------------------------------
        double[] stepSize = {.1000000, .0500000, .0250000, .0125000, .0062500, .0031250, .0015625};
        int[] numSteps = {20, 40, 80, 160, 320, 640, 1280};
        double trueVal =  0.753913186469598763502963347;
        double k0, k1, k2, k3;

        //Coefficients-----------------------------------------------------------------------------
        double a1 = (1.0 / 5.0);
        double a2 = (3.0 / 5.0);
        double a3 = 1.0;

        double b10 = (1.0 / 5.0);
        double b20 = -(2.0 / 5.0);
        double b21 = (1.0);
        double b30 = (23.0 / 13.0);
        double b31 = -(30.0 / 13.0);
        double b32 = (20.0 / 13.0);

        double c0 = (1.0 / 12.0);
        double c1 = (25.0 / 96.0);
        double c2 = (25.0 / 48.0);
        double c3 = (13.0 / 96.0);

        for(int i = 0; i < stepSize.length; i++){
            double xVal = 1.0;
            double t = 0.0;
            double error = 0.0;

            //Print out top lines of output
            System.out.print("Step Size = " + stepSize[i] + "\n");
            System.out.printf("%10s | %10s\n", "tVal", "xVal");
            System.out.print("-----------------------\n");
            System.out.printf("%10s | %10s\n", t, xVal);

            for(int count = 0; count < numSteps[i]; count++){

                //k0 = h * 3x^2 * cos(5t)
                k0 = stepSize[i] * (3 * pow(xVal, 2) * cos(5 * t));

                //k1 = h * 3(x + (b10 * k0))^2 * cos(5(a1 * h))
                k1 = stepSize[i] * (3 * pow((xVal + (b10 * k0)), 2)) * cos(5 * (t + (a1 * stepSize[i])));

                //k2 = h * 3(x + (b20 * k0) + (b21 * k1))^2 * cos(5(a2 * h))
                k2 = stepSize[i] * (3 * pow((xVal + (b20 * k0) + (b21 * k1)), 2)) * cos(5 * (t + (a2 * stepSize[i])));

                //k3 = h * 3(x + (b30 * k0) + (b31 * k1) + (b32 * k2))^2 * cos(5(a3 * h))
                k3 = stepSize[i] * (3 * pow((xVal + (b30 * k0) + (b31 * k1) + (b32 * k2)), 2)) * cos(5 * (t + (a3 * stepSize[i])));

                //new x value = previous x + ((c0 * k0) + (c1 * k1) + (c2 * k2) + (c3 * k3))
                xVal = xVal + ((c0 * k0) + (c1 * k1) + (c2 * k2) + (c3 * k3));

                //Add new h to t to increase step
                t += stepSize[i];

                //Error = trueValue - calculated xValue
                error = abs(trueVal - xVal);

                System.out.printf("%10.10s | %10.10s\n", t, xVal);
            }
            System.out.print("The error at t=2 is: " + error + " \n\n");
        }
    }
}
