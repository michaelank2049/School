
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class FuelTest 
{
    public static void main(String[] args)
    {
        List<String[]> fuelArrayTest = new ArrayList<>();       // Variable declarations
        List<String[]> fuelArrayTrain = new ArrayList<>();
        
        List<Double> testOut = new ArrayList<>();
        List<Double> trainOut = new ArrayList<>();
        List<Double> calc = new ArrayList<>();
        
        String[] temp;
        double[] weight = {0,0,0};
        double bias = 0;
        
        try
        {
                    // BufferedReaders to read the files
            BufferedReader fileTest = new BufferedReader(new FileReader("C:\\Users\\micha\\OneDrive\\Desktop\\Machine Learning\\LankfordMTermProject\\cleanedTest.csv"));
            BufferedReader fileTrain = new BufferedReader(new FileReader("C:\\Users\\micha\\OneDrive\\Desktop\\Machine Learning\\LankfordMTermProject\\cleanedTrain.csv"));
            
            BufferedReader fileTestOut = new BufferedReader(new FileReader("C:\\Users\\micha\\OneDrive\\Desktop\\Machine Learning\\LankfordMTermProject\\cleanedTestOutput.csv"));
            BufferedReader fileTrainOut = new BufferedReader(new FileReader("C:\\Users\\micha\\OneDrive\\Desktop\\Machine Learning\\LankfordMTermProject\\cleanedTrainOutput.csv"));
            
            
            String line;
            while ((line = fileTest.readLine()) != null)        // While loops to put the files into array lists
            {
                fuelArrayTest.add(line.split(","));
            }
            fileTest.close();
            
            while ((line = fileTrain.readLine()) != null)
            {
                fuelArrayTrain.add(line.split(","));
            }
            fileTrain.close();
      
            line = fileTrainOut.readLine();
            while ((line = fileTrainOut.readLine()) != null)
            {
                temp = line.split(",");
                trainOut.add(Double.parseDouble(temp[1]));
            }
            fileTrainOut.close();
            
            line = fileTestOut.readLine();
            while ((line = fileTestOut.readLine()) != null)
            {
                temp = line.split(",");
                testOut.add(Double.parseDouble(temp[1]));
            }
            fileTestOut.close();
            
             
            String[][] tempTest = new String[fuelArrayTest.size()][0];      // Statements to put array lists into arrays
            fuelArrayTest.toArray(tempTest);
            int lenTest = (tempTest.length);        // Calculates array length
            
            String[][] tempTrain = new String[fuelArrayTrain.size()][0];
            fuelArrayTrain.toArray(tempTrain);
            int lenTrain = (tempTrain.length);

            
            FuelProject fp = new FuelProject(tempTrain, trainOut, calc, lenTrain, weight, bias);        // Calls linear regression
            bias = fp.linearRegression();
            
            fp = new FuelProject(tempTest, testOut, calc, lenTest, weight, bias);      // Calls test method
            List<Double> output = fp.testAlgorithm();
            
            int lenPred = output.size();
            fp = new FuelProject(tempTest, testOut, calc, lenPred, weight, bias);       // Calls MAPE method
            double mapeOutput = fp.meanAbsPercenError();
            
            
            System.out.print("\nThe Mean Absolute Percentage Error is: " + mapeOutput + "%\n");        // Outputs MAPE
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
    }
}
