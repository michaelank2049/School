public class ItemTest
{
    public static void main(String[] args)
    {
        Item[] itemArray = new Item[6];
        itemArray[0] = new bigItem(1745, 80.99, 12);
        itemArray[1] = new bigItem(832, 200.00, 50);
        itemArray[2] = new bigItem(36892, 597.00, 23);
        itemArray[3] = new smallItem(8460, 4378.00, 9);
        itemArray[4] = new smallItem(76, 4938.00, 70);
        itemArray[5] = new smallItem(36, 72.00, 15);
     
     
        for (Item itemArray1 : itemArray) {
            System.out.printf("\nThe item number is: " + itemArray1.itemNum + 
                    "\nThe item price is: " + itemArray1.price + "\nThe shipping cost is: " + itemArray1.shippingCost());
        }
    }
   
}