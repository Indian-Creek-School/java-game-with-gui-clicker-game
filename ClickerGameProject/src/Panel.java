import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.NumberFormat;


public class Panel {
    private GridBagConstraints constraint = new GridBagConstraints(); //constraints for OUTSIDE THE PANEL (Ie; mainPanel)
    private GridBagConstraints c = new GridBagConstraints(); //constraints for INSIDE THE PANEL
    private JPanel panel;
    private String object;

    ProblemSolverBox solver = new ProblemSolverBox(1, "AutoSolver1");
    ProblemSolverBox solver2 = new ProblemSolverBox(5, "AutoSolver2");

    

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
            panel.validate();
            panel.repaint();
        }

        if (object.equals("ProblemSolverBox")) {
            JButton addOne = new JButton("Allocate Solver!");
            JLabel display = new JLabel("Allocated Solvers: 0");
            c.gridx = 0; 
            c.gridy = 0; 
            panel.add(display,c);
            c.gridy = 1;
            panel.add(addOne,c); 


            addOne.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(Game.getFreeBits() >= 5) {
                        Game.useBits(5);
                        solver.addOneSolver();
                        display.setText("Allocated Solvers: " + solver.getAmount());
                    }
                }
            });
        }
        
        if (object.equals("ProblemSolverBoxLVL2")) {
            JButton addOne = new JButton("Allocate Mega Solver!");
            JLabel display = new JLabel("Allocated Solvers: 0");
            c.gridx = 0; 
            c.gridy = 0; 
            panel.add(display,c);
            c.gridy = 1;
            panel.add(addOne,c); 


            addOne.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(Game.getFreeBits() >= 50) {
                        Game.useBits(50);
                        solver.addOneSolver();
                        display.setText("Allocated Solvers: " + solver.getAmount());
                    }
                }
            });
        }

        if (object.equals("Display1")) {
            JLabel freeBits = new JLabel("Usable Bits: " + Game.getFreeBits());
            JLabel cpu = new JLabel("CPU Multiplier: %" + Game.getCPU());
            JLabel create = new JLabel ("Total Creativity: " + Game.getcreativity());
            "<html>Usable Bits:  + Game.getFreeBits()<br/>blahblahblah</html>"
            c.gridx= 0;
            c.gridy = 0;
            panel.add(freeBits,c);
            c.gridy = 1; 
            panel.add(cpu,c);
            c.gridy = 2;
            panel.add(create,c);
        }

        if (object.equals("DisplayBits")) {
            JLabel totBits = new JLabel("Total Bits Produced: " + Game.getTotalBits());
            Font f = new Font("Courier", Font.BOLD,30);
            totBits.setFont(f);
            totBits.setHorizontalAlignment(JLabel.CENTER);
            
            c.gridx = 0; 
            c.gridy = 0; 
            panel.add(totBits,c);
        }


    }



    public void updateWindow() {
        if (object.equals("ProblemGenerator")) {
            //unessicary
        }

        if (object.equals("ProblemSolverBox")) { 
            Game.addBits(solver.calculateGains());
        }

        if (object.equals("ProblemSolverBoxLVL2")) {
            Game.addBits(solver2.calculateGains());
        }

        if (object.equals("Display1")) {
            Component[] displayLabels = panel.getComponents();
            int i = 0;
            for(Component label : displayLabels) {
                if (label instanceof JLabel) {
                    i++;
                    if (i == 1) {
                        ((JLabel)label).setText("Usable Bits: " + NumberFormat.getIntegerInstance().format(Game.getFreeBits()));
                    }
                    if (i == 2) {
                        ((JLabel)label).setText("CPU Multiplier:% " + Game.getCPU());
                    }
                    if (i == 3) {
                        ((JLabel)label).setText("Total Creativity: " + NumberFormat.getIntegerInstance().format(Game.getcreativity()));
                    }
                }
            }
        }
        
        if (object.equals("DisplayBits")) {
            Component[] displayLabels = panel.getComponents();
            for(Component label : displayLabels) {
                if (label instanceof JLabel) {
                    ((JLabel)label).setText("Total Bits Produced: " + 
                    NumberFormat.getIntegerInstance().format(Game.getTotalBits()));
                }
            }
        }

        panel.validate();
        panel.repaint();
    }
}