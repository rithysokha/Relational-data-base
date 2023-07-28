package Exercise1;
import java.util.Scanner;
public class Program {
    public static void main(String[] args) {
        Faculty faculty = new Faculty("", "", 0);
        faculty.readFile();
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        while (!exit) {
            faculty.displayLine();
            System.out.println("A. Add a new faculty");
            System.out.println("B. Search a faculty by ID");
            System.out.println("C. Update a faculty");
            System.out.println("D. Delete a faculty");
            System.out.println("E. Exit");
            System.out.println("Enter your choice: ");
            char choice = scanner.next().charAt(0);
            switch (choice) {
                case 'a', 'A':
                    faculty.addNewFaculty();
                    break;
                case 'b', 'B':
                    faculty.searchFacultybyID();
                    break;
                case 'c', 'C':	
                    faculty.updateAFaculty();
                    break;
                case 'd', 'D':
                    faculty.deleteAFaculty();
                    break;
                case 'e', 'E'	:
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
