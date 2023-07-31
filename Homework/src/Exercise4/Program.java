package Exercise4;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        StudentDepartment student = new StudentDepartment();
        student.readFileStudent();
        student.readFileStudentDept();
        Scanner scanner = new Scanner(System.in);
        int studentID = 0;
        int departmentID = 0;
        boolean exit = false;

        while (!exit) {
            student.displayMenu();
            char choice = scanner.next().charAt(0);
            switch (choice) {
                case 'a', 'A':
                    try {
                        System.out.println("Enter student ID: ");
                        studentID = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter department ID: ");
                        departmentID = scanner.nextInt();
                        scanner.nextLine();
                        student.enrollStudentToDepartment(studentID, departmentID);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 'b', 'B':
                    try {
                        System.out.println("Enter student ID: ");
                        studentID = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter department ID: ");
                        departmentID = scanner.nextInt();
                        scanner.nextLine();
                        student.removeStudentFromDepartment(studentID, departmentID);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 'c', 'C':
                    try {
                        System.out.println("Enter department ID: ");
                        departmentID = scanner.nextInt();
                        scanner.nextLine();
                        student.displayAllStudentInDepartment(departmentID);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 'd', 'D':
                    try {
                        System.out.println("Enter student ID: ");
                        studentID = scanner.nextInt();
                        scanner.nextLine();
                        student.displayAllDepartmentOfStudent(studentID);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 'e', 'E':
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }
}
