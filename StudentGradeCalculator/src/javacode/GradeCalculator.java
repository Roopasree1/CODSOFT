package javacode;

import java.util.Scanner;

public class GradeCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the total number of subjects: ");
		int numSubjects = scanner.nextInt();
		
		int[] marks = new int[numSubjects];
		int totalMarks = 0;
		
		//Input marks for every subject
		for(int i=0; i<numSubjects; i++)
		{
			System.out.print("Enter marks obtained in subject " + (i+1) + ": ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
		}
		
		//average percentage
		double averagePercentage = (double) totalMarks/numSubjects;
		
		//calculating grade
		char grade = calculateGrade(averagePercentage);
		
		//Display results
		System.out.println("\nResults:");
		System.out.println("Total Marks: " + totalMarks);
		System.out.println("Average Percentage: " +averagePercentage);
		System.out.println("Grade: " +grade);
		
		scanner.close();
		}

	private static char calculateGrade(double averagePercentage) {
		// TODO Auto-generated method stub
		if(averagePercentage >=90)
		{
			return 'A';
		}
		else if(averagePercentage >=80)
		{
			return 'B';
		}
		else if (averagePercentage >= 70)
		{
            return 'C';
        } 
		else if (averagePercentage >= 60) 
		{
            return 'D';
        } else 
        {
            return 'F';
        }
	}

}


