//Michael Lankford
//1816337

public class Summation 
{
    public static int Summation()
    {
     
        int count = 0;
        int total = 0;
        while (count <= 150)
        {  
            count = count + 3;
            total = total + count; 
        }
        return total;

    }
    
    public static void main(String[] args)
    {
        Summation();
        System.out.printf("The summation of all numbers 0 to 150 are:%d", Summation());
    }
    
}
