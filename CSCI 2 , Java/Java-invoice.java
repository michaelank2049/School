//Michael Lankford
//1816337
//Homework 6 Number 3

public class Invoice 
{

    
//Declarations        
    private String partNum;
    private String partDescrip;
    private int partQuant;
    private double partPrice;
    
        
//Constructor Class    
    public Invoice(String partNum, String partDescrip, int partQuant, double partPrice)
    {
        this.partNum = partNum;
        this.partDescrip = partDescrip;
        this.partQuant= partQuant;
        this.partPrice = partPrice;       
    }
    
    
//Set and Get methods for partNumber    
    public void setNumber(String partNum)
    {
        this.partNum = partNum;
    }
    public String getNumber()
    {
        return partNum;
    }
 
    
//Set and Get methods for partDescription    
    public void setDescritionp(String partDescrip)
    {
        this.partDescrip = partDescrip;
    }
    public String getDescription()
    {
        return partDescrip;
    }

    
//Set and Get methods for partQuantity
    public void setQuantity(int partQuant)
    {
        if(partQuant >= 0 && partQuant <= 1000)
        {
            this.partQuant = partQuant;
        }
    }
    public int getQuantity()
    {
        return partQuant;
    }    

    
//Set and Get methods for partPrice   
    public void setPrice(double partPrice)
    {
        if(partPrice >= 0 && partPrice <= 1000)
        {
            this.partPrice = partPrice;
        }
    }
    public double getPrice()
    {
        return partPrice;
    }      
    
    
    public double getInvoiceAmount()
    {
        double total = 0;
        if(partQuant < 0)
        {
            partQuant = 0;
            total = partQuant * partPrice;
        }
        else if(partPrice < 0)
        {
            partPrice = 0.0;
            total = partPrice * partQuant;
        }
        else
        {
            total = partPrice * partQuant;
        }
        return total;
    }

    
}
