//Michael Lankford
//1816337 

public abstract class Item 
{
    public int itemNum;
    public double price;
    public int weight;
    public int length;
    
    public abstract double shippingCost();
}

class bigItem extends Item
{
    public bigItem(int itemNum, double price, int weight)
    {
        this.itemNum = itemNum;
        this.price = price;
        this.weight = weight;
    }
    
    @Override
    public double shippingCost()
    {
        double totalCost = (price*.10) + (weight * .05);
        
        return totalCost;
    }
    
}

class smallItem extends Item
{
    public smallItem(int itemNum, double price, int length)
    {
        this.itemNum = itemNum;
        this.price = price;
        this.length = length;
    }
    
    @Override
    public double shippingCost()
    {
        double totalCost = 0;
        
        if( length > 10)
            totalCost = ((price *.10) + 5.00);
            
        return totalCost;
    }
    
}

