import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Panel {
    private GridBagConstraints constraint;
    private JPanel panel;

    //type of object to be stored/used in the specific panel
    private String object;
    

    public Panel(GridBagConstraints c, JPanel p,  Object o) {
        constraint = c; //this is the constraints for OUTSIDE OF THE PANEL (inside the mainPanel); NOT THE INSIDE
        panel = p; //panel that will be edited
        //object = o; object type that will be placed within the panel 
    }

    public JPanel getPanel() { return panel; }
    public Object getObject() { return object; }
    public GridBagConstraints getConstraints() { return constraint; }

    public void makeWindow() {
        if (object.equals("ProblemGenerator")) {
            ProblemGenerator problem = new ProblemGenerator();
            problem.generateQuestion();

            JFormattedTextField answerTxt = new JFormattedTextField(10);
            JButton submitBtn = new JButton("Submit");
            submitBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //dosomething with text answerTxt.getText();
                    answerTxt.setText(null);
                } 
            } );
        }

        /* if (object instanceof ProblemSolverBox) {
            ProblemSolverBox problem = new ProblemSolverBox(1,"Level 1 Solver"); //make new instance of ProblemSolverBox object
            //when the button is called, use the .addOneSolver

            JButton aaa = new JButton("add problem Solver");
            aaa.setSize(100,100); //sets the size of the button in pixels
            aaa.setVisible(true); //makes the button visible

            aaa.addActionListener(new ActionListener(){
                 @Override
                public void actionPerformed(ActionEvent e) {
                problem.addOneSolver();
                }
            });

            
            //this button adds another ProblemSolver amount
            //this displays the amount of problem solvers that exist
            //...
            //do something
        } */
    }
    public void updateWindow() {
        return;
        //should update one time-steps worth
    }
}