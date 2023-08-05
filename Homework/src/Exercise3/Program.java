//group8
package Exercise3;
import java.util.Scanner;
public class Program {
 
    public static void main(String[] args) {
        Student student = new Student("", "", "", "", "", 0, 0, "", 0);
        student.readFile();
        boolean exit = false;
        int studentID = 0;
        String studentName = "";
        String studentGender = "";
        String studentDOB = "";
        String studentPhoneNo = "";
        String studentAddress = "";
        int studentYearOfStudy = 0;
        int studentGeneration = 0;
        String studentDegree = "";
        Scanner scanner = new Scanner(System.in);
        while(!exit){
            student.displayLine();
            student.displayMenu();
             char choise = scanner.next().charAt(0);
            switch(choise){
                case 'a', 'A':
                try{
                    System.out.println("Enter student ID: ");
                    studentID = scanner.nextInt();
                    scanner.nextLine();
                    //check validility of student ID
                    if(!student.studentList.containsKey(studentID)){
                    System.out.println("Enter student name: ");	
                    studentName = scanner.nextLine();
                    System.out.println("Enter student gender: ");
                    studentGender = scanner.nextLine();
                    System.out.println("Enter student DOB: ");
                    studentDOB = scanner.nextLine();
                    System.out.println("Enter student phone No: ");
                    studentPhoneNo = scanner.nextLine();
                    System.out.println("Enter student address: ");
                    studentAddress = scanner.nextLine();
                    System.out.println("Enter student year of study: ");	
                    studentYearOfStudy = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter student generation: ");
                    studentGeneration = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter student degree: ");
                    studentDegree = scanner.nextLine();
                    student.addNewStudent(studentID, studentName, studentGender, studentDOB, studentPhoneNo, studentAddress, studentYearOfStudy, studentGeneration, studentDegree, studentID+1000);
                    }else{
                        System.out.println("Student ID already exists.");
                    }
                }catch(Exception e){
                    System.out.println("Wrong input type");
                }
                break;
                case 'b', 'B':
                try{
                    System.out.println("Enter student ID: ");
                    studentID = scanner.nextInt();
                    scanner.nextLine();
                    student.searchStudentbyID(studentID);
                }
                    catch(Exception e){
                        System.out.println("Wrong input type");
                    }
                break;
                case 'c', 'C':
                try{
                    System.out.println("Enter student ID: ");
                    studentID = scanner.nextInt();
                    scanner.nextLine();
                    //check the validity of student ID
                    if(student.studentList.containsKey(studentID)){
                    System.out.println("Enter student name: ");	
                    studentName = scanner.nextLine();
                    System.out.println("Enter student gender: ");
                    studentGender = scanner.nextLine();
                    System.out.println("Enter student DOB: ");
                    studentDOB = scanner.nextLine();
                    System.out.println("Enter student phone No: ");
                    studentPhoneNo = scanner.nextLine();
                    System.out.println("Enter student address: ");
                    studentAddress = scanner.nextLine();
                    System.out.println("Enter student year of study: ");	
                    studentYearOfStudy = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter student generation: ");
                    studentGeneration = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter student degree: ");
                    studentDegree = scanner.nextLine();
                    student.addNewStudent(studentID, studentName, studentGender, studentDOB, studentPhoneNo, studentAddress, studentYearOfStudy, studentGeneration, studentDegree, studentID+1000);
                    }else{
                        System.out.println("Student ID does not exists.");
                    }
                }catch(Exception e){
                    System.out.println("Wrong input type");
                }
                break;
                case 'd', 'D':
                try{
                    System.out.println("Enter student ID: ");
                    studentID = scanner.nextInt();
                    scanner.nextLine();
                    if(student.studentList.containsKey(studentID)){
                        student.deleteStudentByID(studentID);
                    }else{
                        System.out.println("Student ID does not exists.");
                    }
                }catch(Exception e){
                    System.out.println("Wrong input type");
                }
                break;
                case 'e', 'E':
                exit = true;
                break;
                default:System.out.println("Incalid choise");
            }
        }

        scanner.close();
    
    }
}



