//group8
package Exercise1;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Faculty faculty = new Faculty("", "", 0);
        faculty.readFile();
        boolean exit = false;
        int facultyID = 0;
        String facultyName = "";
        String deanName = "";
        int officeNo = 0;
        Scanner scanner = new Scanner(System.in);
        while (!exit) {
            faculty.displayLine();
            faculty.displayMenu();
            char choice = scanner.next().charAt(0);
            switch (choice) {
                case 'a', 'A':
                    try {
                        System.out.println("Enter faculty ID: ");
                        facultyID = scanner.nextInt();
                        scanner.nextLine();
                        // check availability of faculty ID
                        if (!faculty.facultyList.containsKey(facultyID)) {
                            System.out.println("Enter faculty name: ");
                            facultyName = scanner.nextLine();
                            System.out.println("Enter dean name: ");
                            deanName = scanner.nextLine();
                            System.out.println("Enter office No: ");
                            officeNo = scanner.nextInt();
                            scanner.nextLine();
                            faculty.addNewFaculty(facultyID, facultyName, deanName, officeNo);
                        } else {
                            System.out.println("Faculty ID already exists.");
                        }
                    } catch (Exception e) {
                        System.out.println("Wrong input type");
                    }
                    break;
                case 'b', 'B':
                    try {
                        System.out.println("Enter faculty ID: ");
                        facultyID = scanner.nextInt();
                        scanner.nextLine();
                        faculty.searchFacultybyID(facultyID);
                    } catch (Exception e) {
                        System.out.println("Only number is allowed");
                    }
                    break;
                case 'c', 'C':
                    try {
                        System.out.println("Enter faculty ID: ");
                        facultyID = scanner.nextInt();
                        scanner.nextLine();
                        // check availability of faculty ID
                        if (faculty.facultyList.containsKey(facultyID)) {
                            System.out.println("Enter new faculty name: ");
                            facultyName = scanner.nextLine();
                            System.out.println("Enter new dean name: ");
                            deanName = scanner.nextLine();
                            System.out.println("Enter new office No: ");
                            officeNo = scanner.nextInt();
                            scanner.nextLine();
                            faculty.addNewFaculty(facultyID, facultyName, deanName, officeNo);
                        } else {
                            System.out.println("Invalid faculty ID.");
                        }
                    } catch (Exception e) {
                        System.out.println("Wrong input type");
                    }
                    break;
                case 'd', 'D':
                    try {
                        System.out.println("Enter faculty ID: ");
                        facultyID = scanner.nextInt();
                        scanner.nextLine();
                        faculty.deleteAFaculty(facultyID);
                    } catch (Exception e) {
                        System.out.println("Wrong input type");
                    }
                    break;
                case 'e', 'E':
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        scanner.close();
    }
}
