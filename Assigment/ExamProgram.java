import java.util.Scanner;

public class ExamProgram {

    //This is the method used to veiw course work//
    public static void viewCourseWorkResults(double[] courseWork) {
        System.out.println("Course Work Results:");
        for (int numb = 0; numb < courseWork.length; numb++) {
            System.out.println("Assessment " + (numb + 1) + ": " + courseWork[numb]);
        }
    }

    // This is the method used  to view exam results
    public static void viewExamResults(double finalExam, double totalScore) {
        System.out.println("Final Exam Result: " + finalExam);
        System.out.println("Total Score: " + totalScore);
    }

    // This is the method used to count the number of course work assessments
    public static int countCourseWorkAssessments(double[] courseWork) {
        int count = 0;
        for (int numb1 = 0; numb1 < courseWork.length; numb1++) {
            if (courseWork[numb1] > 0) {
                count++;
            }
        }
        return count;
    }

    // Method to determine if the student has done 2/3 of course work
    public static boolean hasCompletedTwoThirdsCourseWork(int count, int totalAssessments) {
        return count >= (2.0 / 3.0) * totalAssessments;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //An Example of  course work and final exam results
        double[] courseWork = {10, 15, 20, 25, 30}; //  course work results
        double finalExam = 50; //  final exam result

        // Calculate total score
        double courseWorkTotal = 0;
        for (double score : courseWork) {
            courseWorkTotal += score;
        }
        double totalScore = courseWorkTotal + finalExam;

        // Count the number of course work assessments done
        int totalAssessments = courseWork.length;
        int assessmentsDone = countCourseWorkAssessments(courseWork);

        // confirm if the student has done the required course work
        boolean completedTwoThirds = hasCompletedTwoThirdsCourseWork(assessmentsDone, totalAssessments);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. View course work results");
            System.out.println("2. View exam results");
            System.out.println("3. Exit the program");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewCourseWorkResults(courseWork);
                    break;
                case 2:
                    if (completedTwoThirds) {
                        viewExamResults(finalExam, totalScore);
                    } else {
                        System.out.println("Student must repeat the course work as they have not completed 2/3 of the assessments.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
