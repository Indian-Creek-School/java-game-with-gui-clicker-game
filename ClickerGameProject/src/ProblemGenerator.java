import java.util.Random;

public class ProblemGenerator {
    private int answer;
    private String question;
    Random r = new Random();

    public void generateQuestion() {
        int a = r.nextInt(20);
        int b = r.nextInt(20);
        boolean s = r.nextBoolean();
        
        if(s){ question = String.valueOf(a) + " + " + String.valueOf(b); answer = a+b; }
        else { question = String.valueOf(a) + " - " + String.valueOf(b); answer = a-b; }
    }

    public int getAnswer() { return answer; }
    public String getQuestion() { return question; }
}