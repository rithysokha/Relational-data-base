//group8
package Exercise2;

import java.util.Scanner;

public class Program {
    void displayMenu(){
        Department department = new Department(null, null, 0, 0);
            department.displayLine();
            System.out.println("Choose an option: ");
            System.out.println("A. Add new department");
            System.out.println("B. Search department by ID");
            System.out.println("C. Update department by ID");
            System.out.println("D. Delete department by ID");
            System.out.println("E. Display department in faculty");
            System.out.println("F. Exit");
    }
    public static void main(String[] args) {
        Department department = new Department(null, null, 0, 0);
        Program program = new Program();
        department.readFile();
        department.readFileFaculty();
        int deptID = 0;
        String deptName = "";
        String headName = "";
        int officeNo = 0;
        int facultyID = 0;
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            program.displayMenu();
            char choise = scanner.next().charAt(0);
            switch (choise) {
                case 'a', 'A':
                try {
                    System.out.println("Enter department ID: ");
                    deptID = scanner.nextInt();
                    scanner.nextLine();
                    if (!department.departmentList.containsKey(deptID)) {
                        System.out.println("Enter department name: ");
                        deptName = scanner.nextLine();
                        System.out.println("Enter head name: ");
                        headName = scanner.nextLine();
                        System.out.println("Enter office No: ");
                        officeNo = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter faculty ID: ");
                        facultyID = scanner.nextInt();
                        scanner.nextLine();
                        department.addNewDepartment(deptID, deptName, headName, officeNo, facultyID);
                    } else {
                        System.out.println("Department ID already exists.");
                    }
                     } catch (Exception e) {
                    System.out.println("Wrong input type");
                }
                    break;
                case 'b', 'B':
                try{
                System.out.println("Enter department ID: ");
                deptID = scanner.nextInt();
                scanner.nextLine();
                    department.searchDepartmentByID(deptID);
                }catch(Exception e){
                    System.out.println("Only number is allowed");
                }
                    break;
                case 'c', 'C':
                try{
                System.out.println("Enter department ID: ");
                deptID = scanner.nextInt();
                scanner.nextLine();
                if(department.departmentList.containsKey(deptID)){
                    System.out.println("Enter new department name: ");
                    deptName = scanner.nextLine();
                    System.out.println("Enter head name: ");
                    headName = scanner.nextLine();
                    System.out.println("Enter office No: ");
                    officeNo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter faculty ID: ");
                    facultyID = scanner.nextInt();
                    scanner.nextLine();
                    //reuse addNewDepartment method to save space
                    department.addNewDepartment(deptID, deptName, headName, officeNo, facultyID);
                }else{
                    System.out.println("Invalid department ID.");
                }}catch(Exception e){
                    System.out.println("Wrong input type");
                }
                    break;
                case 'd', 'D':
                try{
                System.out.println("Enter department ID: ");
                deptID = scanner.nextInt();
                scanner.nextLine();
                    department.deleteDepartmentByID(deptID);
                }catch(Exception e){
                    System.out.println("Only number is allowed");
                }
                    break;
                case 'e', 'E':
                try{
                System.out.println("Enter faculty ID: ");
                facultyID = scanner.nextInt();
                scanner.nextLine();
                    department.deisplayDepartmentInFaculty(facultyID);
                }catch(Exception e){
                    System.out.println("Only number is allowed");	
                }
                    break;
                case 'f', 'F':
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choise");
            }
        }
        scanner.close();

    }
}
