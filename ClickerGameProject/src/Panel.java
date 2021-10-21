import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Panel {
    private GridBagConstraints constraint;
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

            submitBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(answerTxt.getText().equals(Integer.toString(problem.getAnswer()))) {
                        Game.addBits(1);
                        //e.getSource();
                    }
                    answerTxt.setText(null);
                } 
            } );
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
            return;
        }
        //should update one time-steps worth
    }
}