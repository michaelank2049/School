
public class ForLoop1To100
{
    public static void main(String[] args)
    {
        for (int counter = 0; counter <= 100; counter++)
        {
            if (counter >= 50 && counter <=59)
            {
                continue;
            }
            else
            {
                System.out.printf("%d,", counter);
            }
        }    
    }
    
}
