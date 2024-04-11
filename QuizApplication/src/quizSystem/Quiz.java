package quizSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

class QuizQuestions
{
	String question;
	List<String> options;
	int correctOptionsIndex;
	
	public QuizQuestions(String question, List<String> options, int correctOptionsIndex )
	{
		this.question = question;
		this.options = options;
		this.correctOptionsIndex = correctOptionsIndex;
	}
	
}

class Quizz
{
	List<QuizQuestions> questions;
	int currentQuestionIndex;
	int score;
	int totalTimePerQuestion; //in sec
	Scanner scanner;
	
	public Quizz(List<QuizQuestions> questions, int TotalTimePerQuestion)
	{
		this.questions = questions;
		this.currentQuestionIndex = 0;
		this.score = 0;
		this.totalTimePerQuestion = totalTimePerQuestion;
		this.scanner = new Scanner(System.in);
	}
 public void startQuiz()
{
	for(QuizQuestions question : questions)
	{
		displayQuestion(question);
		boolean isCorrect = SubmitAnswer(question);
		if(isCorrect)
		{
			score++;
		}
		System.out.println();
	}
	displayResult();
}
  private void displayResult() 
	{
	// TODO Auto-generated method stub
	 System.out.println("Quiz is completed !");
	 System.out.println("Your Score: " + score + "/" + questions.size());
}
private boolean SubmitAnswer(QuizQuestions question) 
{
	// TODO Auto-generated method stub
	Timer timer = new Timer();
	timer.schedule(new TimerTask()
			{
		    public void run()
		    {
		    System.out.println("\nTime is up..!");
		    synchronized(scanner)
		    {
		    	scanner.notify();
		    }
		    }
			}, totalTimePerQuestion * 1000);
	    System.out.println("\nEnter your choice: ");
	    int choice = scanner.nextInt();
        timer.cancel();
        return choice - 1 == question.correctOptionsIndex;
	
	return false;
}
private void displayQuestion(QuizQuestions question) {
	// TODO Auto-generated method stub
	System.out.println(question.question);
	for(int i = 0; i<question.options.size(); i++)
	{
		System.out.println((i+1)+ ". " + question.options.get(i));
	}
}
public class Quiz {

	public Quiz(List<QuizQuestions> questions, int i) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Sample Quiz
        List<QuizQuestions> questions = new ArrayList<>();
        questions.add(new QuizQuestions("What is the capital of France?",
                Arrays.asList("London", "Paris", "Berlin", "Rome"), 1));
        questions.add(new QuizQuestions("What is 2 + 2?",
                Arrays.asList("3", "4", "5", "6"), 1));
        questions.add(new QuizQuestions("Which is the largest planet in the Solar System?",
                Arrays.asList("Mars", "Earth", "Jupiter", "Saturn"), 2));

        Quiz quiz = new Quiz(questions, 10); // 10 seconds per question
		quiz.startQuiz();
		}
}
}