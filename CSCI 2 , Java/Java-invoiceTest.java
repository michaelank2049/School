//Michael Lankford
//1816337
//Homework 6 Number 3

public class InvoiceTest 
{
    public static void main(String[] args)
    {
        Invoice i1 = new Invoice("987", "Yellow", 75, 2.34);
        Invoice i2 = new Invoice("94U", "Blue", -12, 10.00);
        Invoice i3 = new Invoice("01H", "Red", 12, 1.75);
        Invoice i4 = new Invoice("JYP", "Pink", 104, 8.00);
        Invoice i5 = new Invoice("5I4", "Violet", 84, -9.00);
        Invoice i6 = new Invoice("048", "Brown", 50, 23.56);
        Invoice i7 = new Invoice("IGW", "Green", -1, 19.99);
        Invoice i8 = new Invoice("2Y6", "Orange", 500, .50);
        
        System.out.printf("Part 1's number is: %s, description is: %s, quantity is: %d, and price is: $%s" 
                , i1.getNumber() , i1.getDescription() , i1.getQuantity() , i1.getPrice() + "\n");
        System.out.printf("Part 1's invoice amount is: $%s" , i1.getInvoiceAmount() + "\n");
        
        System.out.printf("Part 2's number is: %s, description is: %s, quantity is: %d, and price is: $%s" 
                , i2.getNumber() , i2.getDescription() , i2.getQuantity() , i2.getPrice() + "\n");
        System.out.printf("Part 2's invoice amount is: $%s" , i2.getInvoiceAmount() + "\n");
        
        System.out.printf("Part 3's number is: %s, description is: %s, quantity is: %d, and price is: $%s" 
                , i3.getNumber() , i3.getDescription() , i3.getQuantity() , i3.getPrice() + "\n");
        System.out.printf("Part 3's invoice amount is: $%s" , i3.getInvoiceAmount() + "\n");
        
        System.out.printf("Part 4's number is: %s, description is: %s, quantity is: %d, and price is: $%s" 
                , i4.getNumber() , i4.getDescription() , i4.getQuantity() , i4.getPrice() + "\n");
        System.out.printf("Part 4's invoice amount is: $%s" , i4.getInvoiceAmount() + "\n");
        
        System.out.printf("Part 5's number is: %s, description is: %s, quantity is: %d, and price is: $%s" 
                , i5.getNumber() , i5.getDescription() , i5.getQuantity() , i5.getPrice() + "\n");
        System.out.printf("Part 5's invoice amount is: $%s" , i5.getInvoiceAmount() + "\n");
        
        System.out.printf("Part 6's number is: %s, description is: %s, quantity is: %d, and price is: $%s" 
                , i6.getNumber() , i6.getDescription() , i6.getQuantity() , i6.getPrice() + "\n");
        System.out.printf("Part 6's invoice amount is: $%s" , i6.getInvoiceAmount() + "\n");
        
        System.out.printf("Part 7's number is: %s, description is: %s, quantity is: %d, and price is: $%s" 
                , i7.getNumber() , i7.getDescription() , i7.getQuantity() , i7.getPrice() + "\n");
        System.out.printf("Part 7's invoice amount is: $%s" , i7.getInvoiceAmount() + "\n");
        
        System.out.printf("Part 8's number is: %s, description is: %s, quantity is: %d, and price is: $%s" 
                , i8.getNumber() , i8.getDescription() , i8.getQuantity() , i8.getPrice() + "\n");
        System.out.printf("Part 8's invoice amount is: $%s" , i8.getInvoiceAmount());
       
    }
    
}
