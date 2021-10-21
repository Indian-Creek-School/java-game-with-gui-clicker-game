import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Panel {
    private GridBagConstraints constraint;
    private JPanel panel;

    //type of object to be stored/used in the specific panel
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

        if (object.equals("ProblemSolverBox")) {
            ProblemSolverBox solver = new ProblemSolverBox(1, "Automated Problem Solver");
            

        }
        
        if (object.equals("ProblemSolverBoxLVL2")) {
            return;
        }

        if (object.equals("Display1")) {
            return;
        }





    }
    public void updateWindow() {
        return;
        //should update one time-steps worth
    }
}