
import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        ArrayList<Double> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input;

        // Prompt the user to enter grades
        System.out.println("Welcome to the Student Grade Tracker!");
        System.out.println("Enter student grades (type 'done' when finished):");

        // Loop to gather grades
        while (true) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break; // Exit loop when done is typed
            }
            try {
                // Attempt to parse the input as a double
                double grade = Double.parseDouble(input);
                grades.add(grade); // Add grade to the list
            } catch (NumberFormatException e) {
                // Handle invalid input
                System.out.println("Invalid input. Please enter a valid grade or 'done' to finish.");
            }
        }

        // Check if any grades were entered
        if (grades.isEmpty()) {
            System.out.println("No grades entered.");
        } else {
            // Calculate and display results
            double average = calculateAverage(grades);
            double highest = calculateHighest(grades);
            double lowest = calculateLowest(grades);

            System.out.printf("Average Grade: %.2f%n", average);
            System.out.printf("Highest Grade: %.2f%n", highest);
            System.out.printf("Lowest Grade: %.2f%n", lowest);
        }

        scanner.close(); // Close the scanner
    }

    // Method to calculate the average grade
    private static double calculateAverage(ArrayList<Double> grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade; // Sum up the grades
        }
        return sum / grades.size(); // Return the average
    }

    // Method to find the highest grade
    private static double calculateHighest(ArrayList<Double> grades) {
        double highest = grades.get(0); // Start with the first grade
        for (double grade : grades) {
            if (grade > highest) {
                highest = grade; // Update highest if a greater grade is found
            }
        }
        return highest; // Return the highest grade
    }

    // Method to find the lowest grade
    private static double calculateLowest(ArrayList<Double> grades) {
        double lowest = grades.get(0); // Start with the first grade
        for (double grade : grades) {
            if (grade < lowest) {
                lowest = grade; // Update lowest if a smaller grade is found
            }
        }
        return lowest; // Return the lowest grade
    }
}