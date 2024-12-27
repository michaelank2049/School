// Programmer: Michael Lankford
//
// Course: CSCI 3321 Section #1
//
// Date: November 17, 2022
//
// Assignment: Number 5
//
// Environment: Windows 10 Version 21H2 for x64-based Systems
//
// Files Included: TwoPointBoundary.java
//                 TwoPointBoundaryTest.java
//
// Purpose: Create a program that will use the Runge Kutta method and Secant method to solve a two-point boundary problem
//
// Input: t - holds the initial value for the steps
//        x - holds the given x value
//        k0, k1, k2, k3 - k values that will be used to solve the initial value problem
//        a - array of a coefficients that hold generated values
//        b - array of b coefficients that hold generated values
//        c - array of c coefficients that hold generated values
//        numSteps - holds the for loop condition
//        stepSize - holds the value that will increase t every step
//        reIntegrate - will activate when needed to print the x and t values at the end of the program
//
// Preconditions: Coefficients and other values are input correctly
//
// Output: A table of the x0, x1, and x0+x1-3 values followed by a table of the t and x values
//
// Postconditions: Correct table of values are outputted accordingly
//
// Algorithm:
//      Import cos method
//      Import pow method
//
//      Initialize t
//      Initialize x
//      Initialize k0, k1, k2, k3
//      Initialize a
//      Initialize b
//      Initialize c
//      Initialize numSteps
//      Initialize stepSize
//      Initialize reIntegrate
//
//      If reIntegrate == 0
//          Begin loop
//              Compute k0 = h * 3x^2 * cos(5t)
//              Compute k1 = h * 3(x + (b10 * k0))^2 * cos(5(a1 * h))
//              Compute k2 = h * 3(x + (b20 * k0) + (b21 * k1))^2 * cos(5(a2 * h))
//              Compute k3 = h * 3(x + (b30 * k0) + (b31 * k1) + (b32 * k2))^2 * cos(5(a3 * h))
//              Compute new x value = previous x + ((c0 * k0) + (c1 * k1) + (c2 * k2) + (c3 * k3))
//              Add new h to t to increase step
//          End loop
//      Else
//          Begin Loop
//              Compute k0 = h * 3x^2 * cos(5t)
//              Compute k1 = h * 3(x + (b10 * k0))^2 * cos(5(a1 * h))
//              Compute k2 = h * 3(x + (b20 * k0) + (b21 * k1))^2 * cos(5(a2 * h))
//              Compute k3 = h * 3(x + (b30 * k0) + (b31 * k1) + (b32 * k2))^2 * cos(5(a3 * h))
//              Compute new x value = previous x + ((c0 * k0) + (c1 * k1) + (c2 * k2) + (c3 * k3))
//              Add new h to t to increase step
//          End Loop
//

import static java.lang.Math.cos;
import static java.lang.Math.pow;

public class TwoPointBoundary {
    private double t;
    private double x;
    private double k0, k1, k2, k3;
    private double numSteps;
    private double stepSize;
    private double[] a;
    private double[] b;
    private double[] c;
    private int reIntegrate;

    public TwoPointBoundary(double numStep, double sizeSteps, double xVal, double h, double[] alpha, double[] beta, double[] charlie, int num) {
        numSteps = numStep;
        stepSize = sizeSteps;
        x = xVal;
        t = h;
        a = alpha;
        b = beta;
        c = charlie;
        reIntegrate = num;
    }

    public double rungeKutta(){
        if (reIntegrate == 0){
            for(int count = 0; count < numSteps; count++){

                //k0 = h * (x + .09x^2 * cos(10t))
                k0 = stepSize * (x + (.09 * pow(x, 2)) + cos(10 * t));

                //k1 = h * ((x + (b10 * k0)) + .09(x + (b10 * k0))^2 * cos(10(t + (a1 * h))))
                k1 = stepSize * ((x + (b[0] * k0)) + (.09 * pow((x + (b[0] * k0)), 2)) + cos(10 * (t + (a[0] * stepSize))));

                //k2 = h * ((x + (b20 * k0) + (b21 * k1)) + .09(x + (b20 * k0) + (b21 * k1))^2 * cos(10(t + (a2 * h))))
                k2 = stepSize * ((x + (b[1] * k0) + (b[2] * k1)) + (.09 * pow((x + (b[1] * k0) + (b[2] * k1)), 2)) + cos(10 * (t + (a[1] * stepSize))));

                //k3 = h * ((x + (b30 * k0) + (b31 * k1) + (b32 * k2)) + .09(x + (b30 * k0) + (b31 * k1) + (b32 * k2))^2 * cos(10(t + (a3 * h))))
                k3 = stepSize * ((x + (b[3] * k0) + (b[4] * k1) + (b[5] * k2)) + (.09 * pow((x + (b[3] * k0) + (b[4] * k1) + (b[5] * k2)), 2)) + cos(10 * (t + (a[2] * stepSize))));

                //new x value = previous x + ((c0 * k0) + (c1 * k1) + (c2 * k2) + (c3 * k3))
                x = x + ((c[0] * k0) + (c[1] * k1) + (c[2] * k2) + (c[3] * k3));

                //Add new h to t to increase step
                t += stepSize;
            }
            return x;
        }
        else{
            System.out.printf("%20.9s%20.9s\n", "t", "x");

            for(int count = 0; count < numSteps; count++){

                //k0 = h * (x + .09x^2 * cos(10t))
                k0 = stepSize * (x + (.09 * pow(x, 2)) + cos(10 * t));

                //k1 = h * ((x + (b10 * k0)) + .09(x + (b10 * k0))^2 * cos(10(t + (a1 * h))))
                k1 = stepSize * ((x + (b[0] * k0)) + (.09 * pow((x + (b[0] * k0)), 2)) + cos(10 * (t + (a[0] * stepSize))));

                //k2 = h * ((x + (b20 * k0) + (b21 * k1)) + .09(x + (b20 * k0) + (b21 * k1))^2 * cos(10(t + (a2 * h))))
                k2 = stepSize * ((x + (b[1] * k0) + (b[2] * k1)) + (.09 * pow((x + (b[1] * k0) + (b[2] * k1)), 2)) + cos(10 * (t + (a[1] * stepSize))));

                //k3 = h * ((x + (b30 * k0) + (b31 * k1) + (b32 * k2)) + .09(x + (b30 * k0) + (b31 * k1) + (b32 * k2))^2 * cos(10(t + (a3 * h))))
                k3 = stepSize * ((x + (b[3] * k0) + (b[4] * k1) + (b[5] * k2)) + (.09 * pow((x + (b[3] * k0) + (b[4] * k1) + (b[5] * k2)), 2)) + cos(10 * (t + (a[2] * stepSize))));

                //new x value = previous x + ((c0 * k0) + (c1 * k1) + (c2 * k2) + (c3 * k3))
                x = x + ((c[0] * k0) + (c[1] * k1) + (c[2] * k2) + (c[3] * k3));

                //Add new h to t to increase step
                t += stepSize;

                System.out.printf("%20.9e%20.9e\n", t, x);
            }
            return x;
        }
    }
}
