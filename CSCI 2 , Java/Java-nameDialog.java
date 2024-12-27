//Fig 3.13
//Obtain user input from a dialog

import javax.swing.JOptionPane;

public class NameDialog 
{
    public static void main(String[] args)
    {
        
//Prompt user input        
        String name = JOptionPane.showInputDialog("What is your name?");
        
//Create the message
        String message = String.format("Welcome, %s, to Java Programming!", name);
        
//Display message to welcome user by name        
        JOptionPane.showMessageDialog(null, message);
    }
    
}
