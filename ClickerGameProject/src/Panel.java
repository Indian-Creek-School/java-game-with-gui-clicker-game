import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Panel {
    private GridBagConstraints constraint;
    private GridBagConstraints inside; //rename
    private JPanel panel;
    private String object;

    

    public Panel(GridBagConstraints c, JPanel p, String o) {
        constraint = c; //this is the constraints for OUTSIDE OF THE PANEL (inside the mainPanel); NOT THE INSIDE
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
            JFormattedTextField answerTxt = new JFormattedTextField(10);
            JButton submitBtn = new JButton("Submit");

            panel.add(display, BorderLayout.NORTH);
            panel.add(answerTxt, BorderLayout.SOUTH);
            panel.add(submitBtn, BorderLayout.EAST);

            submitBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(answerTxt.getText().equals(Integer.toString(problem.getAnswer()))) {
                        Game.addBits(1);
                        Panel.this.updateWindow();
                    }
                    answerTxt.setText(null);
                } 
            } );
            panel.revalidate();
            panel.repaint();
        }

        if (object.equals("ProblemSolverBox")) {
            ProblemSolverBox solver = new ProblemSolverBox(1, "Automated Problem Solver");
            JButton addOne = new JButton("Buy Solver!");
            JLabel display = new JLabel("0");
            addOne.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(Game.getFreeBits() >= 10) {
                        Game.useBits(10);
                        solver.addOneSolver();
                        display.setText("Solvers:" + solver.getAmount());
                    }
                }
            });
        }
        
        if (object.equals("ProblemSolverBoxLVL2")) {
            return;
        }

        if (object.equals("Display1")) {
            
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

            
            return;
        }
        //should update one time-steps worth

     


    }
}