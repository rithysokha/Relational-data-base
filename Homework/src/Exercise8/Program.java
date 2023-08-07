package Exercise8;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Account account = new Account();
        account.readFileStudent();
        account.readFileTeacher();
        account.readFileAccount();
        Scanner scanner = new Scanner(System.in);
        int userID;
        int password;
        boolean exit = false;
        while (!exit) {
            account.displayMenu();
            char choise = scanner.next().charAt(0);
            switch (choise) {
                case 'a', 'A':
                    try {
                        System.out.println("Enter student ID: ");
                        userID = scanner.nextInt();
                        scanner.nextLine();
                        if (account.studentList.containsKey(userID)) {
                            userID+=1000;//add 1000 to the student userID so we can know who are them when login
                            if (!account.accountList.containsKey(userID)) {
                                System.out.println("Enter new password: ");
                                password = scanner.nextInt();
                                scanner.nextLine();
                                account.createAccount(userID, password);
                            } else {
                                System.out.println("The account for this student is existed.");
                            }
                        } else {
                            System.out.println("Student ID not found");
                        }
                    } catch (Exception e) {
                        System.out.println("Only number is allowed");
                    }
                    break;
                case 'b', 'B':
                    try {
                        System.out.println("Enter teacher ID: ");
                        userID = scanner.nextInt();
                        scanner.nextLine();
                        if (account.studentList.containsKey(userID)) {
                            if (!account.accountList.containsKey(userID)) {
                                System.out.println("Enter new password: ");
                                password = scanner.nextInt();
                                scanner.nextLine();
                                account.createAccount(userID, password);
                            } else {
                                System.out.println("The account for this teacher is existed");
                            }
                        } else {
                            System.out.println("Teacher ID not found");
                        }
                    } catch (Exception e) {
                        System.out.println("Only number is allowed");
                    }
                    break;
                case 'c', 'C':
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choise.");
                    break;
            }
        }
        scanner.close();
    }
}
