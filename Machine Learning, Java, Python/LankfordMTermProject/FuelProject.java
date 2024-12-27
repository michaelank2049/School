
import java.util.Arrays;
import java.util.List;

public class FuelProject 
{
    private final String[][] data;        // Variable declarations
    private final List<Double> out;
    private final int arrayLen;
    private final double[] weight;
    private double bias;
    private final List<Double> test;
    
    double learnRate = .0001;       // Declares learning rate and epoch iterations
    double epoch = 1000;
    
    public FuelProject(String[][] vg, List<Double> o, List<Double> pred, int len, double[] w, double b)     // Constructor
    {
        test = pred;
        out = o;
        data = vg;
        arrayLen = len;
        weight = w;
        bias = b;
    }
    
    public double linearRegression()       // Calculates the derivatives of the mean squared error and the updated weights/bias
    {
        for(int m = 0; m < epoch; m++)      // Epoch iterator for max times ran
        {
            double weightDerivMSE = 0;     // Variable declaration
            double biasDerivMSE = 0;
            double feat = 0;
            double actualWeight = 0;
            double calcWeight = 0;
            
            for (int i = 1; i < arrayLen; i++)
            {
                for (int j = 1; j <= weight.length; j++)
                {
                    feat = Double.parseDouble(data[i][j]);       // Feature to be used for calculation
                    
                    actualWeight = out.get(i - 1);      // Actual value for the associated features 
                    
                    calcWeight = (feat * weight[j - 1] + bias);      // Calculated value with the associated features, weight, and bias
                             
                    
            // Weight Mean Squared Error Derivative = (-2/n) * sum(x * (yActual - yCalc))
            // Bias Mean Squared Error Derivative = (-2/n) * sum(yActual - yCalc)
                    
                    weightDerivMSE = weightDerivMSE + ((float) -2 / arrayLen) * (feat) * (actualWeight - calcWeight);
                    biasDerivMSE = biasDerivMSE + ((float) -2 / arrayLen) * (actualWeight - calcWeight);
                    
                    
            // Weight = Weight - Learnrate * weightDerivMSE
            // Bias = Bias - Learnrate * biasDerivMSE
                    weight[j - 1] = weight[j - 1] - (learnRate * weightDerivMSE);
                    bias = bias - (learnRate * biasDerivMSE);
                    
                }
            }
            System.out.print("The calculated weights are: " + Arrays.toString(weight) + "\n");
            System.out.print("The calculated bias is: " + bias + "\n");
        }
        return bias;
    }
    
    
    public List<Double> testAlgorithm()     // Tests agorithm based on test features and the calculated weight and bias
    {
        double calc = 0;        // Variable declarations
        double feat = 0;

        System.out.print("\n");     // Newline to separate outputs
        
        for (int i = 1; i < arrayLen; i++)
        {
            for (int j = 1; j < weight.length; j++)
            {
                feat = Double.parseDouble(data[i][j]);       // Feature to be used for calculation
                
                calc = weight[j] * feat + bias;      // Calculates the test 
            }
            test.add(calc);
                    
            System.out.print("The calculated prediction is: " + calc + "\n");       // Output 
        }
        return test;
    }
    
    public double meanAbsPercenError()      // Calculates the mean absolute percentage error
    {
        double mape = 0;        // Variable declaration
        double actualWeight = 0;
        double calcWeight = 0;
        
        for(int i = 0; i < arrayLen; i++)
        {   
            actualWeight = out.get(i);
            calcWeight = test.get(i);
            
        //MAPE = 100 * (1/n) * absolute value sum((actual - predicted) / actual)
            
            mape = mape + ((float) 1 / arrayLen) * (Math.abs(actualWeight - calcWeight) / actualWeight);
        }
        
        return mape * 100;      // Multiplies the decimal by 100 for percentage error
    }
}
