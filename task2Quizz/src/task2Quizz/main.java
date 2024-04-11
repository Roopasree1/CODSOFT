package task2Quizz;
import java.util.*;

class QuizQuestion {
    String question;
    List<String> options;
    int correctOptionIndex;

    public QuizQuestion(String question, List<String> options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }
}

class Quiz {
    List<QuizQuestion> questions;
    int currentQuestionIndex;
    int score;
    int totalTimePerQuestion; // in sec
    Scanner scanner;

    public Quiz(List<QuizQuestion> questions, int totalTimePerQuestion) {
        this.questions = questions;
        this.currentQuestionIndex = 0;
        this.score = 0;
        this.totalTimePerQuestion = totalTimePerQuestion;
        this.scanner = new Scanner(System.in);
    }

    public void startQuiz() {
        for (QuizQuestion question : questions) {
            displayQuestion(question);
            boolean isCorrect = submitAnswer(question);
            if (isCorrect) {
                score++;
            }
            System.out.println();
        }
        displayResult();
    }

    private void displayQuestion(QuizQuestion question) {
        System.out.println(question.question);
        for (int i = 0; i < question.options.size(); i++) {
            System.out.println((i + 1) + ". " + question.options.get(i));
        }
    }

    private boolean submitAnswer(QuizQuestion question) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up! Moving to the next question.");
                synchronized (scanner) {
                    scanner.notify();
                }
            }
        }, totalTimePerQuestion * 1000);

        System.out.print("\nEnter your choice: ");
        int choice = scanner.nextInt();
        timer.cancel();
        return choice - 1 == question.correctOptionIndex;
    }

    private void displayResult() {
        System.out.println("Quiz Completed!");
        System.out.println("Your Score: " + score + "/" + questions.size());
    }
}

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // Sample Quiz
        List<QuizQuestion> questions = new ArrayList<>();
        questions.add(new QuizQuestion("Which keyword is used to define a class in Java?",
                Arrays.asList("class", "void", "this", "extends"), 0));
        questions.add(new QuizQuestion("Which one is not a Java keyword?",
                Arrays.asList("malloc", "static", "void", "private"), 0));
        questions.add(new QuizQuestion("Which package is imported by default in Java?",
                Arrays.asList("java.lang", "java.util", "java.io", "java.math"), 0));
        questions.add(new QuizQuestion("How many bytes is char in java?",
        	    Arrays.asList("4 bytes", "3  bytes", "2 bytes", "8 bytes"), 2));
        questions.add(new QuizQuestion("Which of the following is not a premitive data type?",
        	    Arrays.asList("int", "String", "boolean", "long"), 1));
        

        Quiz quiz = new Quiz(questions, 10); // 10 seconds per question
        quiz.startQuiz();

	}

}
