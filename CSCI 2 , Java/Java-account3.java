//Fig 3.8

public class Account3 
{
    private String name;
    private double balance;
    
//Constructor    
    public Account3(String name, double balance)
    {
        this.name = name;
        
        if(balance > 0.0)
        {
            this.balance = balance;
        }
    }
    
//Method that adds a valid amount to balance    
    public void deposit(double depositAmount)
    {
        if(depositAmount > 0.0)
        {
            balance = balance + depositAmount;
        }
    }
 
//Method to return account balance    
    public double getBalance()
    {
        return balance;
    }
 
//set name method    
    public void setName(String name)
    {
        this.name = name;
    }
  
//return name method    
    public String getName()
    {
        return name;
    }
    
    
}
