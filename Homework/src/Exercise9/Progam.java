package Exercise9;

import java.util.Scanner;

public class Progam {
    public static void main(String[] args) {
        Login login = new Login();
        login.readFileTeacher();
        login.readFileStudent();
        login.readFileAccount();
        Scanner scanner = new Scanner(System.in);
        int userID;
        int password;
        try {
            System.out.println("Enter user ID: ");
            userID = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter password: ");
            password = scanner.nextInt();
            scanner.nextLine();
            login.logIn(userID, password);
        } catch (Exception e) {
            System.out.println("Only number is allowed");
        }
        scanner.close();
    }
}
