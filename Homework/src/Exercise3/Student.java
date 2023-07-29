//group8
package Exercise3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class Student {
    private int studentID;
    private String studentName;
    private String studentGender;
    private String studentDOB;
    private int studentPhoneNo;
    private String studentAddress;
    private int studentYearOfStudy;
    private int studentGeneration;
    private String studentDegree;

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentDegree() {
        return studentDegree;
    }

    public void setStudentDegree(String studentDegree) {
        this.studentDegree = studentDegree;
    }

    public String getStudentDOB() {
        return studentDOB;
    }

    public void setStudentDOB(String studentDOB) {
        this.studentDOB = studentDOB;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public int getStudentPhoneNo() {
        return studentPhoneNo;
    }

    public void setStudentPhoneNo(int studentPhoneNo) {
        this.studentPhoneNo = studentPhoneNo;
    }

    public int getStudentGeneration() {
        return studentGeneration;
    }

    public void setStudentGeneration(int studentGeneration) {
        this.studentGeneration = studentGeneration;
    }

    public int getStudentYearOfStudy() {
        return studentYearOfStudy;
    }

    public void setStudentYearOfStudy(int studentYearOfStudy) {
        this.studentYearOfStudy = studentYearOfStudy;
    }

    public Student(String studentName, String studentGender, String studentDOB, int studentPhoneNo,
            String studentAddress, int studentYearOfStudy, int studentGeneration, String studentDegree) {
        this.studentName = studentName;
        this.studentGender = studentGender;
        this.studentDOB = studentDOB;
        this.studentPhoneNo = studentPhoneNo;
        this.studentAddress = studentAddress;
        this.studentYearOfStudy = studentYearOfStudy;
        this.studentGeneration = studentGeneration;
        this.studentDegree = studentDegree;
    }

    HashMap<Integer, Student> studentList = new HashMap<>();

    void displayLine() {
        System.out.println("=================================================");
    }

    // read file and input data to hashmap
    void readFile() {
        try {
            // Creates a reader that is linked with the myFile.txt
            FileReader reader = new FileReader("src\\data\\student.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] keyValue = line.split(", ");
                String studentIDStr = keyValue[0];
                String studentNameStr = keyValue[1];
                String studentGenderStr = keyValue[2];
                String studentDOBStr = keyValue[3];
                String studentPhoneNoStr = keyValue[4];
                String studentAddressStr = keyValue[5];
                String studentYearOfStudyStr = keyValue[6];
                String studentGenerationStr = keyValue[7];
                String studentDegreeStr = keyValue[8];
                // convert data type
                Integer studentIDInt = Integer.parseInt(studentIDStr);
                int studentPhoneNoInt = Integer.parseInt(studentPhoneNoStr);
                int studentYearOfStudyInt = Integer.parseInt(studentYearOfStudyStr);
                int studentGenerationInt = Integer.parseInt(studentGenerationStr);

                // Add the key-value pair to the HashMap.
                studentList.put(studentIDInt, new Student(studentNameStr, studentGenderStr, studentDOBStr,
                        studentPhoneNoInt, studentAddressStr, studentYearOfStudyInt, studentGenerationInt,
                        studentDegreeStr));
            }
            // Close the file
            bufferedReader.close();
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // write data back into txt file
    void writeFile() {
        File file = new File("src\\data\\student.txt");
        try {
            // write file back into account.txt
            FileWriter writer = new FileWriter(file);
            for (int key : studentList.keySet()) {
                writer.write(key + ", " + studentList.get(key).getStudentName() + ", "
                        + studentList.get(key).getStudentGender() + ", " + studentList.get(key).getStudentDOB() + ", "
                        + studentList.get(key).getStudentPhoneNo() + ", " + studentList.get(key).getStudentAddress()
                        + ", " + studentList.get(key).getStudentYearOfStudy() + ", "
                        + studentList.get(key).getStudentGeneration() + ", " + studentList.get(key).getStudentDegree()
                        + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //this method is reusable with update student by ID
    void addNewStudent(int studentID, String studentName, String studentGender, String studentDOB, int studentPhoneNo,
            String studentAddress, int studentYearOfStudy, int studentGeneration, String studentDegree) {
        displayLine();
        studentList.put(studentID, new Student(studentName, studentGender, studentDOB, studentPhoneNo, studentAddress,
                studentYearOfStudy, studentGeneration, studentDegree));
        writeFile();
    }
    void searchStudentbyID(int studentID){
        if(studentList.containsKey(studentID)){
            System.out.println("Student ID: " + studentID);
            System.out.println("Student Name: " + studentList.get(studentID).getStudentName());
            System.out.println("Student gender: " + studentList.get(studentID).getStudentGender());
            System.out.println("Student DOB: " + studentList.get(studentID).getStudentDOB());
            System.out.println("Student phone No: " + studentList.get(studentID).getStudentPhoneNo());
            System.out.println("Student address: " + studentList.get(studentID).getStudentAddress());
            System.out.println("Student year of study: " + studentList.get(studentID).getStudentYearOfStudy());
            System.out.println("Student generation: " + studentList.get(studentID).getStudentGeneration());
            System.out.println("Student degree: " + studentList.get(studentID).getStudentDegree());
        }else{
            System.out.println("Student ID not found");
        }
    }

    void deleteStudentByID(int studentID){
        if(studentList.containsKey(studentID)){
            studentList.remove(studentID);
            writeFile();
        }else{
            System.out.println("Student ID not found");
        }
    }

}
