package Exercise6;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Teacher teacher = new Teacher(null, null, null, null, null, 0);
        teacher.readFile();
        int teacherID =0;
        String teacherName ="";
        String teacherGender ="";
        String teacherDOB ="";
        String teacherPhoneNo ="";
        String teacherAddress ="";
        int userID =0;
        boolean exit = false;
        while(!exit){
            teacher.displayMenu();
            char choise = scanner.next().charAt(0);
            switch (choise) {
                case 'a', 'A':
                    try{
                    System.out.println("Enter teacher ID: ");
                    teacherID = scanner.nextInt();
                    scanner.nextLine();
                    if(!teacher.teacherList.containsKey(teacherID)){
                        System.out.println("Enter teacher name: ");
                        teacherName = scanner.nextLine();
                        System.out.println("Enter teacher gender:");
                        teacherGender = scanner.nextLine();
                        System.out.println("Enter teacher DOB: ");
                        teacherDOB = scanner.nextLine();
                        System.out.println("Enter teacher phone number: ");
                        teacherPhoneNo = scanner.nextLine();
                        System.out.println("Enter teacher address: ");
                        teacherAddress = scanner.nextLine();
                        userID = teacherID;
                        teacher.addNewTeacher(teacherID, teacherName, teacherGender, teacherDOB, teacherPhoneNo, teacherAddress, userID);
                        teacher.writeFileToTeacherCourse();
                    }else{
                        System.out.println("Teacher ID already exist!");
                    }
                    }catch(Exception e){
                        System.out.println("Wrong input type");
                    }
                    break;
                case 'b', 'B':
                    try{
                        System.out.println("Enter teacher ID: ");
                        teacherID = scanner.nextInt();
                        scanner.nextLine();
                        teacher.searchTeacherByID(teacherID);
                    }catch(Exception e){
                        System.out.println("Wrong input type");
                    }
                    break;	
                case 'c', 'C':
                    try{
                        System.out.println("Enter teacher ID: ");
                    teacherID = scanner.nextInt();
                    scanner.nextLine();
                    if(teacher.teacherList.containsKey(teacherID)){
                        System.out.println("Enter teacher name: ");
                        teacherName = scanner.nextLine();
                        System.out.println("Enter teacher gender:");
                        teacherGender = scanner.nextLine();
                        System.out.println("Enter teacher DOB: ");
                        teacherDOB = scanner.nextLine();
                        System.out.println("Enter teacher phone number: ");
                        teacherPhoneNo = scanner.nextLine();
                        System.out.println("Enter teacher address: ");
                        teacherAddress = scanner.nextLine();
                        userID=teacherID;
                        teacher.addNewTeacher(teacherID, teacherName, teacherGender, teacherDOB, teacherPhoneNo, teacherAddress, userID);}
                        else{
                            System.out.println("Teacher ID does not exist!");
                        }
                    }catch(Exception e){
                        System.out.println("Wrong input type");
                    }
                    break;
                case 'd', 'D':
                    try{
                        System.out.println("Enter teacher ID: ");
                        teacherID = scanner.nextInt();
                        scanner.nextLine();
                        teacher.deleteTeacherByID(teacherID);
                    }catch(Exception e){
                        System.out.println("Wrong input type");
                    }
                    break;
                case 'e', 'E':
                    try{
                        System.out.println("Enter teacher ID: ");
                        teacherID = scanner.nextInt();
                        scanner.nextLine();
                        teacher.displayAllCourseToughByATeacher(teacherID);
                    }catch(Exception e){
                        System.out.println("Wrong input type");
                    }
                    break;
                case 'f', 'F':
                exit=true;
                break;
                default:
                    break;
            }
        }
        scanner.close();
    }
}
