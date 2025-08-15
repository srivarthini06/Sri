import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    // Inner Student class
    static class Student {
        private String name;
        private double grade;

        public Student(String name, double grade) {
            this.name = name;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public double getGrade() {
            return grade;
        }

        @Override
        public String toString() {
            return name + " - Grade: " + grade;
        }
    }

    // Main logic
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Grade Tracker ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Show Average Grade");
            System.out.println("4. Show Highest Grade");
            System.out.println("5. Show Lowest Grade");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter grade (0-100): ");
                    double grade = scanner.nextDouble();
                    students.add(new Student(name, grade));
                    System.out.println("Student added.");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students added yet.");
                    } else {
                        for (Student s : students) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No data to calculate average.");
                    } else {
                        double sum = 0;
                        for (Student s : students) {
                            sum += s.getGrade();
                        }
                        System.out.println("Average Grade: " + (sum / students.size()));
                    }
                    break;

                case 4:
                    if (students.isEmpty()) {
                        System.out.println("No data to find highest grade.");
                    } else {
                        Student topStudent = students.get(0);
                        for (Student s : students) {
                            if (s.getGrade() > topStudent.getGrade()) {
                                topStudent = s;
                            }
                        }
                        System.out.println("Top Performer: " + topStudent);
                    }
                    break;

                case 5:
                    if (students.isEmpty()) {
                        System.out.println("No data to find lowest grade.");
                    } else {
                        Student lowStudent = students.get(0);
                        for (Student s : students) {
                            if (s.getGrade() < lowStudent.getGrade()) {
                                lowStudent = s;
                            }
                        }
                        System.out.println("Lowest Performer: " + lowStudent);
                    }
                    break;

                case 6:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 6);

        scanner.close();
    }
}