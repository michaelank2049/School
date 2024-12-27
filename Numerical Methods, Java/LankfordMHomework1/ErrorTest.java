public class ErrorTest {
    public static void main(String[] args){
        double h = 1;
        double input = 2;
        double[] array = new double[40];
        double[] filledArray;
        double[] output;
        double[] error;

        Error er = new Error(array, h);
        filledArray = er.fillArray();

        er = new Error(input, filledArray);
        output = er.derivative();

        er = new Error(output);
        error = er.error();

        System.out.printf("%3s%15s%15s%15s \n","i", "h", "approx", "error");
        for(int i = 0; i < filledArray.length; i++){
            System.out.printf("%3d%15.6e%15.6e%15.6e\n", i, filledArray[i], output[i], error[i]);
        }

    }
}
