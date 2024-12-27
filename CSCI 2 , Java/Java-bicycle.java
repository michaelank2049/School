
public class Bicycle 
{
    public int bldNo;
    private double bSpeed;
    public String bModel;
    public double bPrice;
    
    public Bicycle(int bldNo, double bSpeed, String bModel, double bPrice)
    {
        this.bldNo = bldNo;
        this.bSpeed = bSpeed;
        this.bModel = bModel;
        this.bPrice = bPrice;
    }
    
    public void setSpeed(double bSpeed)
    {
        if (bSpeed >= 10 && bSpeed <= 30)
        {
            this.bSpeed = bSpeed;
        }
    }

    public double getSpeed()
    {
        return bSpeed;
    }
}