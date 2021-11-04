import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Panel {
    private GridBagConstraints constraint = new GridBagConstraints(); //constraints for OUTSIDE THE PANEL (Ie; mainPanel)
    private GridBagConstraints c = new GridBagConstraints(); //constraints for INSIDE THE PANEL
    private JPanel panel;
    private String object;

    

    public Panel(GridBagConstraints con, JPanel p, String o) {
        constraint = (GridBagConstraints)con.clone(); //this is the constraints for OUTSIDE OF THE PANEL (inside the mainPanel); NOT THE INSIDE
        panel = p; //panel that will be edited
        object = o; //object type that will be used
    }

    public JPanel getPanel() { return panel; }
    public Object getObject() { return object; }
    public GridBagConstraints getConstraints() { return constraint; }



    public void makeWindow() {

        if (object.equals("ProblemGenerator")) {
            ProblemGenerator problem = new ProblemGenerator();
            problem.generateQuestion();
            

            JLabel display = new JLabel(problem.getQuestion());
            JFormattedTextField answerTxt = new JFormattedTextField();
            answerTxt.setColumns(7); 
            JButton submitBtn = new JButton("Submit");

            c.gridx = 0; 
            c.gridy = 0; 
            panel.add(display,c);
            c.gridy = 1;
            panel.add(answerTxt,c); 
            c.gridy = 2;
            panel.add(submitBtn,c);

            submitBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(answerTxt.getText().equals(Integer.toString(problem.getAnswer()))) {
                        Game.addBits(1);
                        problem.generateQuestion();
                        display.setText(problem.getQuestion());
                    }
                    answerTxt.setText(null);
                    answerTxt.setColumns(7);
                                       
                } 
            } );
            panel.revalidate();
            panel.repaint();
        }

        if (object.equals("ProblemSolverBox")) {
            ProblemSolverBox solver = new ProblemSolverBox(1, "Automated Problem Solver");
            JButton addOne = new JButton("Buy Solver!");
            JLabel display = new JLabel("0");
            //panel.setSize(300, 200);
            //panel.setBackground(Color.green);
            c.gridx = 0; 
            c.gridy = 0; 
            panel.add(display,c);
            c.gridy = 1;
            panel.add(addOne,c); 


            addOne.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(Game.getFreeBits() >= 2) {
                        Game.useBits(2);
                        solver.addOneSolver();
                        display.setText("Solvers:" + solver.getAmount());
                    }
                }
            });
        }
        
        if (object.equals("ProblemSolverBoxLVL2")) {
            panel.setBackground(Color.red);
            panel.setSize(250, 150);
            return;
        }

        if (object.equals("Display1")) {
            panel.setBackground(Color.blue);
            panel.setSize(200, 100); 
            JLabel displayLabel = new JLabel();
            

       

            JLabel totBits = new JLabel("Total Bits Produced: " + Game.getTotalBits());
            JLabel freeBits = new JLabel("Usable Bits: " + Game.getFreeBits());
            JLabel cpu = new JLabel("CPU Multiplier:% " + Game.getCPU());
            JLabel create = new JLabel ("Total Creativity: " + Game.getcreativity());

            return;
        }


    }



    public void updateWindow() {
        if (object.equals("ProblemGenerator")) {
            //unessicary
        }

        if (object.equals("ProblemSolverBox")) { 

        }

        if (object.equals("ProblemSolverBoxLVL2")) {
            return;
        }

        if (object.equals("Display1")) {
            Component[] displayLabels = panel.getComponents();
            for(Component label : displayLabels) {
                if (label instanceof JLabel) {
                    ((JLabel)label).setText("Total Bits Produced: " + Game.getTotalBits());
                }
            }
        }
        //should update one time-steps worth
    }
}