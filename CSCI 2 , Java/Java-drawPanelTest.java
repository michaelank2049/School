//Fig 4.19
//Create JFrame to display drawPanel

import javax.swing.JFrame;

public class DrawPanelTest 
{
    public static void main(String[] args)
    { 
//create a panel that cotains our drawing       
        DrawPanel panel = new DrawPanel();
 
//create a new frame to hold the panel        
        JFrame application = new JFrame();
 
//set frame to exit when it is closed        
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  //      application.add(panel);
        application.setSize(250, 250);
        application.setVisible(true);
        
    }
    
}
