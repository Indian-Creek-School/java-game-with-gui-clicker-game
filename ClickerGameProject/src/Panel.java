import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.NumberFormat;


public class Panel {
    private GridBagConstraints constraint = new GridBagConstraints(); //constraints for OUTSIDE THE PANEL (Ie; mainPanel)
    private GridBagConstraints c = new GridBagConstraints(); //constraints for INSIDE THE PANEL
    private JPanel panel;
    private String object;

    private JLabel lbl;
    private JButton bttn;
    private JButton bttn2;
    private JButton bttn3;
    private Boolean flip = true;
    private Boolean flip2 = true;

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
            answerTxt.addActionListener(new ActionListener() {
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
            JButton upgrade = new JButton("Upgrade!");
            JLabel upDog = new JLabel("(100 Creativity)");

            c.gridx = 0; 
            c.gridy = 0; 
            panel.add(display,c);
            display.setVisible(false);
            c.gridy = 1;
            panel.add(addOne,c); 
            addOne.setVisible(false);
            c.gridx = 1;
            c.gridy = 1;
            panel.add(upgrade,c);
            upgrade.setVisible(false);
            c.gridy = 0;
            panel.add(upDog,c);
            upDog.setVisible(false);

            bttn = addOne;
            lbl = display;

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
            upgrade.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(Game.getcreativity() >= 100) {
                        Game.useCreativity(100);
                        solver.addToMultiplier(1);
                    }
                }
            });
        }
        
        if (object.equals("ProblemSolverBoxLVL2")) {
            JButton addOne = new JButton("Allocate Mega Solver!");
            JLabel display = new JLabel("Allocated Solvers: 0");
            JButton upgrade = new JButton("Upgrade!");
            JLabel upDog = new JLabel("(100 Creativity)");
            JButton addFive = new JButton("Allocate 5x Solvers");
            JButton addTwenty = new JButton("Allocated 25x Solvers");


            c.gridx = 0; 
            c.gridy = 0; 
            panel.add(display,c);
            display.setVisible(false);
            c.gridy = 1;
            panel.add(addOne,c); 
            addOne.setVisible(false);
            c.gridx = 1;
            panel.add(upgrade,c);
            upgrade.setVisible(false);
            c.gridy = 0;
            panel.add(upDog,c);
            upDog.setVisible(false);
            c.gridx = 0;
            c.gridy = 2;
            panel.add(addFive,c);
            addFive.setVisible(false);
            c.gridx = 1;
            panel.add(addTwenty, c);
            addTwenty.setVisible(false);

            bttn = addOne;
            lbl = display;
            bttn2 = addFive;
            bttn3 = addTwenty;

            addOne.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(Game.getFreeBits() >= 50) {
                        Game.useBits(50);
                        solver2.addOneSolver();
                        
                    }
                }
            });
            upgrade.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(Game.getcreativity() >= 100) {
                        Game.useCreativity(100);
                        solver2.addToMultiplier(1);
                        Game.addCPU(100);
                        
                    }
                }
            });
            addFive.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(Game.getFreeBits() >= 250) {
                        Game.useBits(250);
                        solver2.addManySolvers(5);
                    }
                }
            });
            addTwenty.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(Game.getFreeBits() >= 1250) {
                        Game.useBits(1250);
                        solver2.addManySolvers(25);
                    }
                }
            });
            display.setText("Allocated Solvers: " + solver2.getAmount());
        }

        if (object.equals("Display1")) {
            Font f = new Font("Courier",Font.ITALIC,20);
            JLabel freeBits = new JLabel("Usable Bits: " + Game.getFreeBits());
            JLabel cpu = new JLabel("CPU Multiplier: %" + Game.getCPU());
            freeBits.setFont(f);
            cpu.setFont(f);
            JLabel create = new JLabel (" ");
            create.setFont(f);
            //"<html>Usable Bits:  + Game.getFreeBits()<br/>blahblahblah</html>"
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

        if (object.equals("NotificationDisplay")) {
            JLabel notifications = new JLabel("");
            Font f = new Font("Courier", Font.BOLD,20);
            notifications.setFont(f);

            c.gridx = 0;
            c.gridy = 0;
            panel.add(notifications,c);

        }
    }



    public void updateWindow() {
        Component[] comps = panel.getComponents();
        if (object.equals("ProblemGenerator")) {
            if(Game.getTotalBits() > 30) {
                for(Component c : comps) {
                    c.setVisible(false);   
                }
            }
        }

        if (object.equals("ProblemSolverBox")) { 
            Game.addBits(solver.calculateGains());

            if (Game.getcreativity() >= 100) {
                for(Component c : comps) {
                    c.setVisible(true);
                }
            }
            if (flip && Game.getFreeBits() >= 5) {
                lbl.setVisible(true);
                bttn.setVisible(true);
                flip = false;
            }
            if (!flip && Game.getFreeBits() < 5) {
                lbl.setVisible(false);
                bttn.setVisible(false);
                flip = true;
            }
        }

        if (object.equals("ProblemSolverBoxLVL2")) {
            Game.addBits(solver2.calculateGains());
            if (Game.getcreativity() >= 100) {
                for(Component c : comps) {
                    c.setVisible(true);
                }
            }
            if (flip && Game.getTotalBits() > 100) {
                lbl.setVisible(true);
                bttn.setVisible(true);
                flip = false;
            }
            if (Game.getTotalBits() > 5000) {
                bttn2.setVisible(true);
            }
            if (Game.getTotalBits() > 15000) {
                bttn3.setVisible(true);
            }
        }

        if (object.equals("Display1")) {
            int i = 0;
            if(Game.getFreeBits() >= 1000) {
                Game.addCreativity((Integer)Game.getFreeBits()/10000);
            }
            
            for(Component label : comps) {
                if (label instanceof JLabel) {
                    i++;
                    if (i == 1) {
                        ((JLabel)label).setText("Usable Bits: " + NumberFormat.getIntegerInstance().format(Game.getFreeBits()));
                    }
                    if (i == 2) {
                        ((JLabel)label).setText("CPU Multiplier: %" + Game.getCPU());
                    }
                    if (i == 3 && Game.getcreativity() != -1) {
                        ((JLabel)label).setText("Total Creativity: " + NumberFormat.getIntegerInstance().format(Game.getcreativity()));
                    }
                }
            }
        }
        
        if (object.equals("DisplayBits")) {
            for(Component label : comps) {
                if (label instanceof JLabel) {
                    ((JLabel)label).setText("Total Bits Produced: " + 
                    NumberFormat.getIntegerInstance().format(Game.getTotalBits()));
                }
            }
        }

        if (object.equals("NotificationDisplay")) {
            for(Component label : comps) {
                if (label instanceof JLabel) {
    
                    if (Game.getTotalBits() >= 10000 && Game.getTotalBits() <= 25000) {
                        if (Game.getcreativity() == -1) {
                            ((JLabel)label).setText("I wonder what would happen if I save up over 10,000 idle bits...");
                        }
                        else {
                            ((JLabel)label).setText("");
                        }
                    }
                }
            }
        }

        panel.validate();
        panel.repaint();
    }
}