package Exercise5;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Course course = new Course(null, 0, null);
        course.readFile();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        int courseID = 0;
        String courseName;
        int credit = 0;
        String type;

        while (!exit) {
            course.displayMenu();
            char choise = scanner.next().charAt(0);
            switch (choise) {
                case 'a', 'A':
                    try {
                        System.out.println("Enter course ID: ");
                        courseID = scanner.nextInt();
                        scanner.nextLine();
                        if (!course.courseList.containsKey(courseID)) {
                            System.out.println("Enter course name: ");
                            courseName = scanner.nextLine();
                            System.out.println("Enter credit: ");
                            credit = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Enter type: ");
                            type = scanner.nextLine();
                            course.createCourse(courseID, courseName, credit, type);
                            course.writeFile();
                        } else {
                            System.out.println("Course ID already exist!");
                        }
                    } catch (Exception e) {
                        System.out.println("Wrong input type");
                    }
                    break;
                case 'b', 'B':
                    try {
                        System.out.println("Enter course ID: ");
                        courseID = scanner.nextInt();
                        scanner.nextLine();
                        course.searchCourse(courseID);
                    } catch (Exception e) {
                        System.out.println("Only number is allowed!");
                    }
                    break;
                case 'c', 'C':
                    try {
                        System.out.println("Enter course ID: ");
                        courseID = scanner.nextInt();
                        scanner.nextLine();
                        if (course.courseList.containsKey(courseID)) {
                            System.out.println("Enter course name: ");
                            courseName = scanner.nextLine();
                            System.out.println("Enter credit: ");
                            credit = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Enter type: ");
                            type = scanner.nextLine();
                            course.createCourse(courseID, courseName, credit, type);
                            course.writeFile();
                        } else {
                            System.out.println("Course ID does not exist!");
                        }
                    } catch (Exception e) {
                        System.out.println("Wrong input type");
                    }
                    break;
                case 'd', 'D':
                    try {
                        System.out.println("Enter course ID: ");
                        courseID = scanner.nextInt();
                        scanner.nextLine();
                        course.deleteCourse(courseID);
                        course.writeFile();

                    } catch (Exception e) {
                        System.out.println("Wrong input type");
                    }
                    break;
                case 'e', 'E':
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input!");

            }
        }
        scanner.close();
    }
}
