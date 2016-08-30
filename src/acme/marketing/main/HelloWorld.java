package acme.marketing.main;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
 

public class HelloWorld implements Runnable {

    @Override
    public void run() {
        // Create the window
        JFrame f = new JFrame("Hello, !");
        // Sets the behavior for when the window is closed
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Add a layout manager so that the button is not placed on top of the label
        f.setLayout(new FlowLayout());
        // Add a label and a button
        Fract fract = new Fract();
        
        JButton btn = new JButton("Change");
        
        btn.addActionListener(fract);
        
        fract.add(btn);
        
        fract.setPreferredSize(new Dimension(800, 800));
        
        f.add(fract);
        
        // Arrange the components inside the window
        f.pack();
        // By default, the window is not visible. Make it visible.
        f.setVisible(true);
    }
    
 
    public static void main(String[] args) {
        HelloWorld hw = new HelloWorld();
        // Schedules the application to be run at the correct time in the event queue.
        SwingUtilities.invokeLater(hw);
    }   
}