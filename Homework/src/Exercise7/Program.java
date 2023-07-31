package Exercise7;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TeacherCourse teacherCourse = new TeacherCourse();
        teacherCourse.readFileTeacher();
        teacherCourse.readFileTeacherCourse();
        boolean exit = false;
        int courseID;
        int teacherID;
        while(!exit){
            teacherCourse.displayMenu();
            char choise = scanner.next().charAt(0);
            switch(choise){
                case 'a', 'A':
                try{
                    System.out.println("Enter teacher ID: ");
                    teacherID = scanner.nextInt();
                    scanner.nextLine();
                    if(teacherCourse.teacherList.containsKey(teacherID)){
                        System.out.println("Enter course ID: ");
                        courseID = scanner.nextInt();
                        scanner.nextLine();
                        teacherCourse.assignCourseToATeacher(teacherID, courseID);
                    }else{
                        System.out.println("Teacher ID not found.");
                    }
                }
                catch(Exception e){
                    System.out.println("Only number is allowed");
                }
                break;
                case 'b', 'B':
                try{
                    System.out.println("Enter teacher ID: ");
                    teacherID = scanner.nextInt();
                    scanner.nextLine();
                    if(teacherCourse.teacherList.containsKey(teacherID)){
                        System.out.println("Enter course ID: ");
                        courseID = scanner.nextInt();
                        scanner.nextLine();
                        teacherCourse.removeCourseFromATeacher(teacherID, courseID);
                    }else{
                        System.out.println("Teacher ID not found.");
                    }
                }catch(Exception e){
                    System.out.println("Only number is allowd");
                }
                break;
                case 'c', 'C':
                try{
                    System.out.println("Enter teacher ID");
                    teacherID = scanner.nextInt();
                    scanner.nextLine();
                    teacherCourse.displayAllCourseToughByATeacher(teacherID);
                }
                catch(Exception e){
                    System.out.println("Only number is allowed");
                }
                break;
                case 'd', 'D':
                exit=true;
                break;
                default:
                System.out.println("Invalid choise");
            }
        }
        scanner.close();
    }
}
