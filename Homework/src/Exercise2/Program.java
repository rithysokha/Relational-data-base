package Exercise2;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Department department = new Department(null, null, 0, 0);
        department.readFile();
        Scanner scanner = new Scanner(System.in);
    boolean exit = false;
    while(!exit){
        System.out.println("Choose an option: ");
        System.out.println("A. Add new department");
        System.out.println("B. Search department by ID");
        System.out.println("C. Update department by ID");
        System.out.println("D. Delete department by ID");
        System.out.println("E. Display department in faculty");
        System.out.println("F. Exit");
        char choise = scanner.next().charAt(0);
        switch(choise){
            case 'a','A':
                department.addNewDepartment();
                break;
            case 'b', 'B':
                department.searchDepartmentByID();
                break;
            case 'c','C':
                department.updateADepartmentByID();
                break;
            case 'd','D':
                department.deleteDepartmentByID();
                break;
            case 'e','E':
                department.deisplayDepartmentInFaculty();
                break;
            case 'f','F':
                exit = true;
                break;
            default:
            System.out.println("Invalid choise");
        }
    }
    scanner.close();
    
    }
}
