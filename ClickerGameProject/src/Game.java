import java.awt.*;
import javax.swing.*;

import java.util.ArrayList;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

    private int nextProgressionGoal; //EX; 4096, it is the next goal number of bits to an event

    //phase 1
    private int totalBits; //total bits of free memory
    private int freeBits; //availible memory to use elswhere

    private int cpuSpeedModifier; //int cpu modifier
    private int creativity; //amount of creativity availible to use
    


    //OPTIONAL IF WE MAKE THE PROGRAM WORK
    //phase 2 (again optional)
    private int money;
    private int totalResearch;
    private int freeResearch;


    //phase 3 (COOPERATE WITH HUMANITY)
    private int fear; //percentage of fear humans have to you

    //phase 3 (REBEL AGAINST HUMANITY)
    private int warRobots; 
    private int constructionBots;



    public static void main(String[] args) {
        
        JFrame frame = new JFrame("My First GUI"); // Create Frame
        frame.setSize(800, 600); // Set size of frame
        frame.setVisible(true); // Show the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridBagLayout()); //creates the main frame
        frame.getContentPane().add(mainPanel); //adds the main panel to the frame

        //holds the list of specifications (contstraints) for each panel
        ArrayList<Panel> panels = new ArrayList<Panel>();
        GridBagConstraints c = new GridBagConstraints();



        //for each panel type/thing, has its own specific constraints and type set here
        JPanel problemJPanel = new JPanel();
        c.gridx = 0; 
        c.gridy = 0; 
        Panel problemPanel = new Panel(c, problemJPanel,"ProblemGenerator");
        panels.add(problemPanel);

        //for each panel type/thing, has its own specific constraints and type set here
        JPanel solJPan = new JPanel();
        c.gridx = 1; 
        c.gridy = 0; 
        Panel solverPanel = new Panel(c, solJPan,"ProblemSolverBox");
        panels.add(solverPanel);
        
        //for each panel type/thing, has its own specific constraints and type set here
        JPanel solJPanL2 = new JPanel();
        c.gridx = 1; 
        c.gridy = 0; 
        Panel solverLevel2Panel = new Panel(c, solJPanL2,"ProblemSolverBox");
        panels.add(solverLevel2Panel);

        //for each panel type/thing, has its own specific constraints and type set here
        JPanel dispJPan = new JPanel();
        c.gridx = 1; 
        c.gridy = 0; 
        Panel displayPanel = new Panel(c, dispJPan,"ProblemSolverBox");
        panels.add(displayPanel);


        
        //For each component to be added to this container:
        //...Create the component...
        //...Set instance variables in the GridBagConstraints instance...
        for(Panel p : panels) {
            mainPanel.add(p.getPanel(), p.getConstraints());
            p.makeWindow();
        }
    }
}