public class ProblemSolverBox {
    private int solverAmount; //keeps track of the number of 'times' this problem solver has been purchased
    private int multiplier; //keeps track of the multiplier that this problem solver has against the amount to determine the total
    private int baseValue; //the base amount of gain you get from a solver object
    private String name; //name of the solver object

    public ProblemSolverBox(int b,String n) {
        solverAmount = 0;
        multiplier = 1;
        baseValue = b;
        name = n;
    }

    //get methods
    public int getMultiplier() { return multiplier; }
    public int getAmount() { return solverAmount; }
    public int getBaseValue() { return baseValue; }
    public String getName() { return name; }

    //allows you to change the multiplier as player gains bonuses through research
    public void setMultiplier(int m) { multiplier = m; }
    public void addToMultiplier(int m) { multiplier = m + multiplier; }

    //add or change solver amounts 
    public void resetSolvers() { solverAmount = 0; }
    public void addOneSolver() { solverAmount++; }
    public void addManySolvers(int a) { solverAmount = solverAmount + a; }
     
    //use this on each time step to calculate the # of memory gained
    public int calculateGains() { return multiplier * solverAmount * baseValue; } 

}
