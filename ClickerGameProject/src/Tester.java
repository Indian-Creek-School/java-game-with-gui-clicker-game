public class Tester {
    
    
    public static void main(String[] args) {

        ProblemGenerator name = new ProblemGenerator();
        System.out.println();
       

        name.generateQuestion();
        System.out.println(name.getQuestion());
        System.out.println(name.getAnswer());

        System.out.println("^^^^^Question stuff^^^^^");
        System.out.println("vvvvSolver stoffvvvv");
      

        ProblemSolverBox solver = new ProblemSolverBox(1,"name");
        System.out.println(solver.getMultiplier());
        solver.addOneSolver();
        System.out.println(solver.getAmount());
        System.out.println(solver.getBaseValue());
        System.out.println(solver.getName());
        System.out.println(solver.calculateGains());

        System.out.println();
        System.out.println();
        
        solver.setMultiplier(3);
        solver.addOneSolver();
        System.out.println(solver.getMultiplier());
        solver.addToMultiplier(3);
        System.out.println(solver.getMultiplier());
        System.out.println(solver.calculateGains());

    }
}
