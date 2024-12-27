// Programmer: Michael Lankford
//
// Course: CSCI 3321 Section #1
//
// Date: September 25, 2022
//
// Assignment: Number 2
//
// Environment: Windows 10 Version 21H2 for x64-based Systems
//
// Files Included: SecantTest.java
//
// Purpose: Create a program that will use the Secant Method to solve a problem
//
// Input: xn - first x value for input
//        xnm1 - second x value for input
//        fxn - given formula that first x value will be input to
//        fxnm1 - given formula that second x value will be input to
//        xnp1 - next x value that will be solved
//        i - iterator for the while loop
//
// Preconditions: Input values for the first and second x are entered correctly
//
// Output: Columns of correct i, xn, and fxn values
//
// Postconditions: Correct table of values is outputted accordingly
//
// Algorithm:
//      Import power method
//      Import sin method
//      Import absolute value method
//
//      Initialize xn
//      Initialize xnm1
//      Initialize fxn
//      Initialize fxnm1
//      Initialize xnp1
//      Initialize i
//
//      Calculate fxn = xn^5 - .2sin(xn) - 10
//
//      Print table column headers
//
//      while( i < 100 and |fxn| > .000000001)
//          Compute fxn
//          Compute fxnm1
//          Compute xnp1
//
//          Print table values
//
//          Set xnm1 = xn
//          Set xn = xnp1
//          Iterate i
//

import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.abs;

public class SecantTest {
    public static void main(String[] args){
        double xn = 1.0;
        double xnm1 = 2.0;
        double fxn ;
        double fxnm1;
        double xnp1;
        int i = 1;

        fxn = pow(xn,5) - (.2 * sin(xn)) - 10;

        System.out.printf("%3s%20s%20s\n", "n", "xn", "f(xn)");
        while((i < 20) && (abs(fxn) > pow(10,-9))){
            fxn = pow(xn,5) - (.2 * sin(xn)) - 10;
            fxnm1 = pow(xnm1, 5) - (.2 * sin(xnm1)) - 10;
            xnp1 = xn - fxn * ((xn-xnm1) / (fxn - fxnm1));

            System.out.printf("%3d%20.9e%20.9e\n", i, xn, fxn);

            xnm1 = xn;
            xn = xnp1;
            i++;
        }
    }
}