import java.awt.*;
import javax.swing.*;

import java.util.ArrayList;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout.Constraints;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

public class Game extends JFrame{

    private static int nextProgressionGoal; //EX; 4096, it is the next goal number of bits to an event

    //phase 1
    private static int totalBits; //total bits of free memory
    private static int freeBits; //availible memory to use elswhere

    private static int cpuSpeedModifier; //int cpu modifier
    private static int creativity; //amount of creativity availible to use
    


    //OPTIONAL IF WE MAKE THE PROGRAM WORK
    //phase 2 (again optional)
    private static int money;
    private static int totalResearch;
    private static int freeResearch;


    //phase 3 (COOPERATE WITH HUMANITY)
    private static int fear; //percentage of fear humans have to you

    //phase 3 (REBEL AGAINST HUMANITY)
    private static int warRobots; 
    private static int constructionBots;



    public static void main(String[] args) {
        
        JFrame frame = new JFrame("The GUI"); // Create Frame
        frame.setSize(800, 600); // Set size of frame
        frame.setVisible(true); // Show the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());//new JPanel(new GridBagLayout()); //creates the main frame
        frame.getContentPane().add(mainPanel); //adds the main panel to the frame
        mainPanel.add(new JButton("Hello"), BorderLayout.WEST);


        //holds the list of specifications (contstraints) for each panel
        ArrayList<Panel> panels = new ArrayList<Panel>();
        GridBagConstraints c = new GridBagConstraints();



        //PROBLEM GENERATOR/INPUT PANEL
        JPanel problemJPanel = new JPanel(new BorderLayout());//new GridBagLayout());
        c.gridx = 0; 
        c.gridy = 0; 
        Panel problemPanel = new Panel(c, problemJPanel,"ProblemGenerator");
        panels.add(problemPanel);

        //PROBLEM SOLVER BOX LEVEL 1
        JPanel solJPan = new JPanel(new GridBagLayout());
        c.gridx = 1;  
        Panel solverPanel = new Panel(c, solJPan,"ProblemSolverBox");
        panels.add(solverPanel);
        
        //PROBLEM SOLVER BOX LEVEL 2
        JPanel solJPanL2 = new JPanel(new GridBagLayout());
        c.gridx = 0; 
        c.gridy = 1; 
        Panel solverLevel2Panel = new Panel(c, solJPanL2,"ProblemSolverBoxLVL2");
        panels.add(solverLevel2Panel);

        //DISPLAY PANEL 
        JPanel dispJPan = new JPanel(new GridBagLayout());
        c.gridx = 1; 
        Panel displayPanel = new Panel(c, dispJPan,"Display1");
        panels.add(displayPanel);

        for(Panel p : panels) {
            
            mainPanel.add(p.getPanel(), BorderLayout.NORTH);//p.getConstraints());
            p.makeWindow();// changing the order of these lines removes the button added for testing purposes
      
        }


    }

    public static int getTotalBits() { return totalBits; }
    public static int getFreeBits() { return freeBits; }
    public static int getCPU() { return cpuSpeedModifier; }
    public static int getcreativity() { return creativity; }

    public static void addBits(int b) { 
        freeBits = freeBits + b;
        totalBits = totalBits + b;
    }
    public static void useBits(int b) { 
        freeBits = freeBits - b;
    }

}
