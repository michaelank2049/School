import static java.lang.Math.sqrt;

public class QuadratureTest {
    public static void main(String[] args){
        double[] nodeBoole = {-1, -(1.0 / 2.0), 0 , (1.0 / 2.0), 1};
        double[] weightBoole = {(7.0 / 45.0), (32.0 / 45.0), (12.0 / 45.0), (32.0 / 45.0), (7.0 / 45.0)};
        double[] boole = new double[3];

        double[] nodeGauss = {-sqrt((1.0 / 9.0) * (5.0 - (2.0 * sqrt(10.0 / 7.0)))), -sqrt((1.0 / 9.0) * (5.0 + (2.0 * sqrt(10.0 / 7.0)))), 0, sqrt((1.0 / 9.0) * (5.0 - (2.0 * sqrt(10.0 / 7.0)))), sqrt((1.0 / 9.0) * (5.0 + (2.0 * sqrt(10.0 / 7.0))))};
        double[] weightGauss = {(.3 * ((-.7 + (5 * sqrt(.7))) / (-2 + (5 * sqrt(.7))))), (.3 * ((.7 + (5 * sqrt(.7))) / (2 + (5 * sqrt(.7))))), (128.0 / 225.0), (.3 * ((-.7 + (5 * sqrt(.7))) / (-2 + (5 * sqrt(.7))))), (.3 * ((.7 + (5 * sqrt(.7))) / (2 + (5 * sqrt(.7)))))};
        double[] gauss = new double[3];

        double[] nodeLobatto = {-1, -sqrt(3.0/7.0), 0, sqrt(3.0 / 7.0), 1};
        double[] weightLobatto = {(1.0 / 10.0), (49.0 / 90.0), (32.0 / 45.0), (49.0 / 90.0), (1.0 / 10.0)};
        double[] lobatto = new double[3];

        double[] trueVal = {0.58385316345285761300, 3.8856180831641267317, 1.3250027473578644309};

//---------------------------------------------------Closed Newton Cotes----------------------------------------------------------
        Quadrature nodeIn = new Quadrature(nodeBoole);

        Quadrature solve = new Quadrature(nodeIn.func1(), weightBoole);
        boole[0] = solve.quad();

        solve = new Quadrature(nodeIn.func2(), weightBoole);
        boole[1] = solve.quad();

        solve = new Quadrature(nodeIn.func3(), weightBoole);
        boole[2] = solve.quad();

        Quadrature err = new Quadrature(boole, trueVal);
        double[] booleErr = err.err();

//---------------------------------------------------Gaussian Quadrature----------------------------------------------------------
        nodeIn = new Quadrature(nodeGauss);

        solve = new Quadrature(nodeIn.func1(), weightGauss);
        gauss[0] = solve.quad();

        solve = new Quadrature(nodeIn.func2(), weightGauss);
        gauss[1] = solve.quad();

        solve = new Quadrature(nodeIn.func3(), weightGauss);
        gauss[2] = solve.quad();

        err = new Quadrature(gauss, trueVal);
        double[] gaussErr = err.err();

//---------------------------------------------------Lobatto Quadrature-----------------------------------------------------------
        nodeIn = new Quadrature(nodeLobatto);

        solve = new Quadrature(nodeIn.func1(), weightLobatto);
        lobatto[0] = solve.quad();

        solve = new Quadrature(nodeIn.func2(), weightLobatto);
        lobatto[1] = solve.quad();

        solve = new Quadrature(nodeIn.func3(), weightLobatto);
        lobatto[2] = solve.quad();

        err = new Quadrature(lobatto, trueVal);
        double[] lobattoErr = err.err();

//---------------------------------------------------Print statements-------------------------------------------------------------
        System.out.printf("Closed Newton Cotes Weights and Nodes\n");
        System.out.printf("%7s%10s%10s%10s%10s%10s\n", " ", "1", "2", "3", "4", "5");
        System.out.printf("%7s%10.5s%10.5s%10.5s%10.5s%10.5s\n", "Weight", weightBoole[0], weightBoole[1], weightBoole[2], weightBoole[3], weightBoole[4]);
        System.out.printf("%7s%10.5s%10.5s%10.5s%10.5s%10.5s\n\n", "Node", nodeBoole[0], nodeBoole[1], nodeBoole[2], nodeBoole[3], nodeBoole[4]);

        System.out.printf("Gaussian Quadrature Weights and Nodes\n");
        System.out.printf("%7s%10s%10s%10s%10s%10s\n", " ", "1", "2", "3", "4", "5");
        System.out.printf("%7s%10.5s%10.5s%10.5s%10.5s%10.5s\n", "Weight", weightGauss[0], weightGauss[1], weightGauss[2], weightGauss[3], weightGauss[4]);
        System.out.printf("%7s%10.5s%10.5s%10.5s%10.5s%10.5s\n\n", "Node", nodeGauss[0], nodeGauss[1], nodeGauss[2], nodeGauss[3], nodeGauss[4]);

        System.out.printf("Lobatto Quadrature Weights and Nodes\n");
        System.out.printf("%7s%10s%10s%10s%10s%10s\n", " ", "1", "2", "3", "4", "5");
        System.out.printf("%7s%10.5s%10.5s%10.5s%10.5s%10.5s\n", "Weight", weightLobatto[0], weightLobatto[1], weightLobatto[2], weightLobatto[3], weightLobatto[4]);
        System.out.printf("%7s%10.5s%10.5s%10.5s%10.5s%10.5s\n\n", "Node", nodeLobatto[0], nodeLobatto[1], nodeLobatto[2], nodeLobatto[3], nodeLobatto[4]);

        for(int i = 0; i < trueVal.length; i++)
        {
            switch(i){
                case 0:
                    System.out.printf("Function 1: f(x) = 1 - sin(1 - x)\n");
                    break;
                case 1:
                    System.out.printf("Function 2: f(x) = sqrt(x + 1) + 1\n");
                    break;
                case 2:
                    System.out.printf("Function 3: f(x) = tanh(x + 1)\n");
                    break;
            }
            System.out.printf("%8s%20s%20s%20s\n", " ", "Area Approximation", "Area True Value", "Error");
            System.out.printf("%8s%20.9e%20.9e%20.9e\n", "Boole", boole[i], trueVal[i], booleErr[i]);
            System.out.printf("%8s%20.9e%20.9e%20.9e\n", "Gaussian", gauss[i], trueVal[i], gaussErr[i]);
            System.out.printf("%8s%20.9e%20.9e%20.9e\n\n", "Lobatto", lobatto[i], trueVal[i], lobattoErr[i]);
        }
    }
}
