public class BicycleTest 
{
    public static void main(String[] args)
    {
        Bicycle b1 = new Bicycle(586, 12.58, "Blue", 899.99);
        Bicycle b2 = new Bicycle(21, 17.8, "Dog", 650.99);
        Bicycle b3 = new Bicycle(4740, 14.1, "Cat", 1000);
        Bicycle b4 = new Bicycle(2054, 28.5, "Red", 925);
        Bicycle b5 = new Bicycle(754, 20.25, "Black", 867.65);
        
        System.out.printf("\n Bike Number is %d, Speed is %.2f, Model is %s, Price is $%.2f", b1.bldNo, b1.getSpeed(), b1.bModel, b1.bPrice); 
        System.out.printf("\n Bike Number is %d, Speed is %.2f, Model is %s, Price is $%.2f", b2.bldNo, b2.getSpeed(), b2.bModel, b2.bPrice); 
        System.out.printf("\n Bike Number is %d, Speed is %.2f, Model is %s, Price is $%.2f", b3.bldNo, b3.getSpeed(), b3.bModel, b3.bPrice);
        System.out.printf("\n Bike Number is %d, Speed is %.2f, Model is %s, Price is $%.2f", b4.bldNo, b4.getSpeed(), b4.bModel, b4.bPrice);
        System.out.printf("\n Bike Number is %d, Speed is %.2f, Model is %s, Price is $%.2f", b5.bldNo, b5.getSpeed(), b5.bModel, b5.bPrice);
    }

}   