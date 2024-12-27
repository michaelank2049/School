//Fig 3.9

import java.util.Scanner;

public class Account3Test 
{
    public static void main(String[] args)
    {
        Account3 acc1 = new Account3("Jane Green", 50.00);
        Account3 acc2 = new Account3("John Blue", -7.53);
        
    //    System.out.printf("%s balance: $%.2f%n", acc1.getName(), acc1.getBalance());
    //    System.out.printf("%s balance: $%.2f%n", acc2.getName(), acc2.getBalance());
        
        Scanner input = new Scanner(System.in);
      
        System.out.print("Enter deposit amount for account1:");
        double depositAmount = input.nextDouble();
        System.out.printf("%nadding %.2f to account1 balance%n%n", depositAmount);
        acc1.deposit(depositAmount);
        
// display balances
    //    System.out.print("%s balance: $%.2f%n", acc1.getName(), acc1.getBalance());
    //    System.out.print("%s balance: $%.2f%n", acc2.getName(), acc2.getBalance());
 
        
        System.out.print("Enter deposit amount for account2:");
        depositAmount = input.nextDouble();
        System.out.printf("%nadding %.2f to account2 balance%n%n", depositAmount);
        acc2.deposit(depositAmount);
        
// display balances
    //    System.out.print("%s balance: $%.2f%n", acc1.getName(), acc1.getBalance());
    //    System.out.print("%s balance: $%.2f%n", acc2.getName(), acc2.getBalance());        
    }
    
}
