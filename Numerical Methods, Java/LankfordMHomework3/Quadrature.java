// Programmer: Michael Lankford
//
// Course: CSCI 3321 Section #1
//
// Date: October 10, 2022
//
// Assignment: Number 3
//
// Environment: Windows 10 Version 21H2 for x64-based Systems
//
// Files Included: QuadratureTest.java
//                 Quadrature.java
//
// Purpose: Create a program that will use Closed Newton Cotes, Gaussian Quadrature, and Lobatto Quadrature
//              to find the area under three different curves
//
// Input: num1 - array that represents the nodes when calculating area or full solved area when calculating error
//        num2 - array that represents the weights when calculating area or true area when calculating error
//        funcOut - array that holds values for nodes after being plugged into the function
//        error - array that holds the error values
//        quadOut - variable that will hold the calculated area
//
// Preconditions: Nodes and weights are input correctly
//
// Output: Rows of nodes and weights for each quadrature formula followed by columns of
//              correct area approximation, area true value, and error for each quadrature formula for each function
//
// Postconditions: Correct table of values is outputted accordingly
//
// Algorithm:
//      Import square root method
//      Import tanh method
//      Import sin method
//      Import absolute value method
//
//      Initialize num1
//      Initialize num2
//      Initialize funcOut
//      Initialize error
//      Initialize quadOut
//
//      quad Method:
//          Multiply each weight by the solved function value
//          Add each value to quadOut
//          Return quadOut
//
//      func1 Method:
//          Initialize funcOut to num1 array size
//          Start loop
//              Compute f(x) = 1 - sin(1 - x)
//              Add each value to funcOut
//          End loop
//          Return funcOut
//
//      func2 Method:
//          Initialize funcOut to num1 array size
//          Start loop
//              Compute f(x) = sqrt(x + 1) + 1
//              Add each value to funcOut
//          End loop
//          Return funcOut
//
//      func3 Method:
//          Initialize funcOut to num1 array size
//          Start loop
//              Compute f(x) = tanh(x + 1)
//              Add each value to funcOut
//          End loop
//          Return funcOut
//
//      err Method:
//          Initialize error to num1 array size
//          Start loop
//              Compute f(x) = | true value - calculated value |
//              Add each value to error
//          End loop
//          Return error
//
// Conclusions: My conclusion after making this experiment was that Closed Newton Cotes, Gaussian Quadrature,
//                  and Lobatto Quadrature are all pretty accurate when finding the area under a curve and viable methods
//                  with small amounts of error. While saying that, Gaussian Quadrature was slightly better by a couple of
//                  decimal points compared to Closed Newton Cotes and Lobatto Quadrature for each function so I'd recommend
//                  to use that when finding area under a curve.
//

import static java.lang.Math.sqrt;
import static java.lang.Math.tanh;
import static java.lang.Math.sin;
import static java.lang.Math.abs;

public class Quadrature {

    private double[] num1;
    private double[] num2;
    double[] funcOut;
    double[] error;
    double quadOut;

    public Quadrature(double[] input, double[] weight){
        num1 = input;
        num2 = weight;
    }

    public Quadrature(double[] input){
        num1 = input;
    }

    public double quad(){
        quadOut = (num2[0] * num1[0]) + (num2[1] * num1[1]) + (num2[2] * num1[2]) + (num2[3] * num1[3]) + (num2[4] * num1[4]);
        return quadOut;
    }

    public double[] func1(){
        funcOut = new double[num1.length];
        for(int i = 0; i < num1.length; i++)
        {
            funcOut[i] = 1 - sin(1 - num1[i]);
        }
        return funcOut;
    }

    public double[] func2(){
        funcOut = new double[num1.length];
        for(int i = 0; i < num1.length; i++)
        {
            funcOut[i] = sqrt(num1[i] + 1) + 1;
        }
        return funcOut;
    }

    public double[] func3(){
        funcOut = new double[num1.length];
        for(int i = 0; i < num1.length; i++)
        {
            funcOut[i] = tanh(num1[i] + 1);
        }
        return funcOut;
    }

    public double[] err(){
        error = new double[num1.length];
        for(int i = 0; i < num1.length; i++)
        {
            error[i] = abs(num2[i] - num1[i]);
        }
        return error;
    }
}
