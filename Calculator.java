import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize variables
        int totalMarks = 0;
        int numSubjects;

        // Input the number of subjects
        System.out.print("Enter the number of subjects: ");
        numSubjects = scanner.nextInt();

        // Input marks for each subject and calculate total marks
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks for Subject " + i + " (out of 100): ");
            int marks = scanner.nextInt();
            totalMarks += marks;
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / (numSubjects * 100) * 100;

        // Assign grades based on average percentage
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else {
            grade = "D";
        }

        // Display results
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
