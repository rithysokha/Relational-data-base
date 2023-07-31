package Exercise6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class Teacher {
    private String teacherName;
    private String tacherGender;
    private String teacherDOB;
    private String teacherPhoneNo;
    private String teacherAddress;
    private int userID;

    public String getTeacherName() {
        return teacherName;
    }

    public String getTacherGender() {
        return tacherGender;
    }

    public String getTeacherDOB() {
        return teacherDOB;
    }

    public String getTeacherPhoneNo() {
        return teacherPhoneNo;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public int getUserID() {
        return userID;
    }

    Teacher(String teacherName, String teacherGender, String teachrDOB, String teacherPoneNo, String teacherAddress,
            int userID) {
        this.teacherName = teacherName;
        this.tacherGender = teacherGender;
        this.teacherDOB = teachrDOB;
        this.teacherPhoneNo = teacherPoneNo;
        this.teacherAddress = teacherAddress;
        this.userID = userID;
    }

    HashMap<Integer, Teacher> teacherList = new HashMap<>();
    HashMap<Integer, int[]> teacherCourseList = new HashMap<>();
    HashMap<Integer, String> courseList = new HashMap<>();
    

    // read file and input data to hashmap
    void readFile() {
        try {
            // Creates a reader that is linked with the myFile.txt
            FileReader reader = new FileReader("src\\data\\teacher.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] keyValue = line.split(", ");
                String teacherIDStr = keyValue[0];
                String teacherNameStr = keyValue[1];
                String teacherGenderStr = keyValue[2];
                String teacherDOBStr = keyValue[3];
                String teacherPhoneNoStr = keyValue[4];
                String teacherAddressStr = keyValue[5];
                String userIDString = keyValue[6];
                // convert data type
                Integer teacherIDInt = Integer.parseInt(teacherIDStr);
                int userIDInt = Integer.parseInt(userIDString);
                // Add the key-value pair to the HashMap.
                teacherList.put(teacherIDInt, new Teacher(teacherNameStr, teacherGenderStr, teacherDOBStr,
                        teacherPhoneNoStr, teacherAddressStr, userIDInt));

            }
            // Close the file
            bufferedReader.close();
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    void readFileCourse() {
        try {
            // Creates a reader that is linked with the myFile.txt
            FileReader reader = new FileReader("src\\data\\course.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] keyValue = line.split(", ");
                String courseIDStr = keyValue[0];
                String courseNameStr = keyValue[1];
                // convert to data type
                Integer courseIDInteger = Integer.parseInt(courseIDStr);
                // Add the key-value pair to the HashMap.
                courseList.put(courseIDInteger, courseNameStr);
            }
            // Close the file.
            bufferedReader.close();
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // write data back into txt file
    void writeFile() {
        File file = new File("src\\data\\teacher.txt");
        try {
            // write file back into account.txt
            FileWriter writer = new FileWriter(file);
            for (int key : teacherList.keySet()) {
                writer.write(key + ", " + teacherList.get(key).getTeacherName() + ", "
                        + teacherList.get(key).getTacherGender() + ", " + teacherList.get(key).getTeacherDOB() + ", "
                        + teacherList.get(key).getTeacherPhoneNo() + ", " + teacherList.get(key).getTeacherAddress()
                        + ", " + teacherList.get(key).getUserID() + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void displayLine() {
        System.out.println("=================================================");
    }
    void displayMenu(){
        displayLine();
        System.out.println("A. Add new teacher.");
        System.out.println("B. Search teacher by ID.");	
        System.out.println("C. Update teacher by ID.");
        System.out.println("D. Delete teacher by ID.");
        System.out.println("E. Display all course tough by a teacher.");
        System.out.println("F. Exit.");
    }

    // this method is reusable with update teacher by ID
    void addNewTeacher(int teacherID, String teacherName, String teacherGender, String teachrDOB, String teacherPoneNo,
            String teacherAddress, int userID) {
        teacherList.put(teacherID, new Teacher(teacherName, teacherGender, teachrDOB, teacherPoneNo, teacherAddress,
                userID));
        writeFile();
    }
    void searchTeacherByID(int teacherID){
        if(teacherList.containsKey(teacherID)){
            System.out.println("Teacher ID: " + teacherID);
            System.out.println("Teacher Name: " + teacherList.get(teacherID).getTeacherName());
            System.out.println("Teacher gender: " + teacherList.get(teacherID).getTacherGender());
            System.out.println("Teacher DOB: " + teacherList.get(teacherID).getTeacherDOB());
            System.out.println("Teacher phone number: " + teacherList.get(teacherID).getTeacherPhoneNo());
            System.out.println("Teacher address: " + teacherList.get(teacherID).getTeacherAddress());
            System.out.println("User ID: " + teacherList.get(teacherID).getUserID());
        }else{
            System.out.println("Teacher ID does not exist!");
        }
    }
    void deleteTeacherByID(int teacherID){
        if(teacherList.containsKey(teacherID)){
            teacherList.remove(teacherID);
        }else{
            System.out.println("Teacher ID does not exist!");
        }
        writeFile();
    }
    void displayAllCourseToughByATeacher(int teacherID) {
        readFileCourse();
        if(teacherList.containsKey(teacherID))
        {System.out.println("Teacher ID: " + teacherID);
        System.out.println("Teacher Name: " + teacherList.get(teacherID));
        for (int index = 0; index <= 4; index++) {
            if (teacherCourseList.get(teacherID)[index] != 0) {
                System.out.println("Course ID: " + teacherCourseList.get(teacherID)[index]);
                System.out.println("Course Name: " + courseList.get(teacherCourseList.get(teacherID)[index]));
            }
        }}else{System.out.println("Teacher ID not found.");}
    }
     //for teacher course assigning progam
     void writeFileToTeacherCourse() {
        File file = new File("src\\data\\teacherCourse.txt");
        try {
            // write file back into account.txt
            FileWriter writer = new FileWriter(file, true);
            for (int key : teacherList.keySet()) {
                writer.write(key + ", " + 0 + ", " + 0 +  ", " + 0+ ", " + 0+ ", " + 0+ ", " + 0 +"\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
