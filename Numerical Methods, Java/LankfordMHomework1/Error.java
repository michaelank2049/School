// Programmer: Michael Lankford
//
// Course: CSCI 3321 Section #1
//
// Date: September 9, 2022
//
// Assignment: Number 1
//
// Environment: Windows 10 Version 21H2 for x64-based Systems
//
// Files Included: Error.java
//                 ErrorTest.java
//
// Purpose: Illustrate the effects of rounding errors and truncation errors
//
// Input: emptyToFillArray- array that will be filled with all halved h values
//        h- initial value to be put into array and halved
//        inputNum- used for given x = 2 radians
//        filledArray- array of h values that will be plugged into derivative formula
//        derivArray- array of derived values that will be used to calculate error
//
// Preconditions: Input value for the derivative is entered correctly
//
// Output: Columns of correct i, h, approx, and error values
//
// Postconditions: Correct table of values is outputted accordingly
//
// Algorithm:
//      Import power method
//
//      Initialize emptyToFillArray
//      Initialize h
//      Initialize inputNum
//      Initialize filledArray
//      Initialize derivArray
//
//      Initialize emptyToFillArray = array for class instance
//      Initialize h = hIn for class instance
//
//      Initialize inputNum = input for class instance
//      Initialize filledArray = array for class instance
//
//      Initialize derivArray = input for class instance
//
//      fillArray method:
//          Start loop
//              Put new value into emptyToFill array
//              Divide h by 2 for new value
//          End loop
//          return emptyToFill array
//
//      derivative method:
//          Initialize output to filledArray size
//          Start loop
//              Compute f(x+h)
//              Compute f(x)
//              Initialize output element to f'(x) = (f(x+h) - (f(x)) / h
//          End loop
//          Return output array
//
//      error method:
//          Initialize err to derivArray size
//          Start loop
//              Initialize err element = derivArray element - (4 - 8cos(8))
//          End loop
//          return err array
//

import static java.lang.Math.pow;

public class Error {

    private double[] emptyToFillArray;
    private double h;
    private double inputNum;
    private double[] filledArray;
    private double[] derivArray;

    public Error(double[] array, double hIn){
        emptyToFillArray = array;
        h = hIn;
    }
    public Error(double input, double[] array){
        inputNum = input;
        filledArray = array;
    }
    public Error(double[] input){

        derivArray = input;
    }


    public double[] fillArray(){
        for(int i = 0; i < 40; i++){
            emptyToFillArray[i] = h;
            h = h / 2;
        }
        return emptyToFillArray;
    }


    public double[] derivative(){
        double[] output = new double[filledArray.length];

        for(int i = 0; i < output.length; i++)
        {
            double fxh = (pow(inputNum + filledArray[i], 2) - Math.sin(2 * pow(inputNum + filledArray[i], 2))) - 1;
            double fx = (pow(inputNum, 2) - Math.sin(2 * pow(inputNum, 2))) - 1;
            output[i] = (fxh - fx) / filledArray[i];
        }
        return output;
    }


    public double[] error(){
        double[] err = new double[derivArray.length];

        for(int i = 0; i < err.length; i++){
            err[i] = derivArray[i] - (4-(8 * Math.cos(8)));
        }
        return err;
    }
}
