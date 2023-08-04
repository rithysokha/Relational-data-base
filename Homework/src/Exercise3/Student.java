//group8
package Exercise3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class Student {
    private String studentName;
    private String studentGender;
    private String studentDOB;
    private String studentPhoneNo;
    private String studentAddress;
    private int studentYearOfStudy;
    private int studentGeneration;
    private String studentDegree;
    private int userID;

    public String getStudentName() {
        return studentName;
    }

    public String getStudentDegree() {
        return studentDegree;
    }

    public String getStudentDOB() {
        return studentDOB;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public String getStudentPhoneNo() {
        return studentPhoneNo;
    }

    public int getStudentGeneration() {
        return studentGeneration;
    }

    public int getStudentYearOfStudy() {
        return studentYearOfStudy;
    }

    public int getUserID() {
        return userID;
    }

    public Student(String studentName, String studentGender, String studentDOB, String studentPhoneNo,
            String studentAddress, int studentYearOfStudy, int studentGeneration, String studentDegree, int userID) {
        this.studentName = studentName;
        this.studentGender = studentGender;
        this.studentDOB = studentDOB;
        this.studentPhoneNo = studentPhoneNo;
        this.studentAddress = studentAddress;
        this.studentYearOfStudy = studentYearOfStudy;
        this.studentGeneration = studentGeneration;
        this.studentDegree = studentDegree;
        this.userID = userID;
    }

    HashMap<Integer, Student> studentList = new HashMap<>();
    HashMap<Integer, int[]> studentDept = new HashMap<>();

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
                String userIDString = keyValue[9];
                // convert data type
                Integer studentIDInt = Integer.parseInt(studentIDStr);
                int studentYearOfStudyInt = Integer.parseInt(studentYearOfStudyStr);
                int studentGenerationInt = Integer.parseInt(studentGenerationStr);
                int userIDInt = Integer.parseInt(userIDString);

                // Add the key-value pair to the HashMap.
                studentList.put(studentIDInt, new Student(studentNameStr, studentGenderStr, studentDOBStr,
                        studentPhoneNoStr, studentAddressStr, studentYearOfStudyInt, studentGenerationInt,
                        studentDegreeStr, userIDInt));
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
                        + ", " + studentList.get(key).getUserID()
                        + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // this method is reusable with update student by ID
    void addNewStudent(int studentID, String studentName, String studentGender, String studentDOB, String studentPhoneNo,
            String studentAddress, int studentYearOfStudy, int studentGeneration, String studentDegree, int userID) {
        displayLine();
        studentList.put(studentID, new Student(studentName, studentGender, studentDOB, studentPhoneNo, studentAddress,
                studentYearOfStudy, studentGeneration, studentDegree, userID));
        writeFile();
        writeFileToStudentDept();
    }

    void searchStudentbyID(int studentID) {
        displayLine();
        if (studentList.containsKey(studentID)) {
            System.out.println("Student ID: " + studentID);
            System.out.println("Student Name: " + studentList.get(studentID).getStudentName());
            System.out.println("Student gender: " + studentList.get(studentID).getStudentGender());
            System.out.println("Student DOB: " + studentList.get(studentID).getStudentDOB());
            System.out.println("Student phone No: " + studentList.get(studentID).getStudentPhoneNo());
            System.out.println("Student address: " + studentList.get(studentID).getStudentAddress());
            System.out.println("Student year of study: " + studentList.get(studentID).getStudentYearOfStudy());
            System.out.println("Student generation: " + studentList.get(studentID).getStudentGeneration());
            System.out.println("Student degree: " + studentList.get(studentID).getStudentDegree());
            System.out.println("User ID: " + studentList.get(studentID).getUserID());
        } else {
            System.out.println("Student ID not found");
        }
    }

    void deleteStudentByID(int studentID) {
        displayLine();
        if (studentList.containsKey(studentID)) {
            studentList.remove(studentID);
            writeFile();
            writeFileToStudentDept();
        } else {
            System.out.println("Student ID not found");
        }
    }

    // for student enrolling progam
    void readFileStudentDept() {
        try {
            FileReader reader = new FileReader("src\\data\\studentDept.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] keyValue = line.split(", ");
                String studentIDStr = keyValue[0];
                String departmentIDStr1 = keyValue[1];
                String departmentIDStr2 = keyValue[2];

                // convert data type
                Integer studentIDInt = Integer.parseInt(studentIDStr);
                int departmentIDInt1 = Integer.parseInt(departmentIDStr1);
                int departmentIDInt2 = Integer.parseInt(departmentIDStr2);
                int[] departmentArray = { departmentIDInt1, departmentIDInt2 };
                studentDept.put(studentIDInt, departmentArray);
                // Close the file
                // bufferedReader.close();
                reader.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void writeFileToStudentDept() {
        readFileStudentDept();
        File file = new File("src\\data\\studentDept.txt");
        try {
            // write file back into account.txt
            FileWriter writer = new FileWriter(file);
            for (int key : studentList.keySet()) {
                if (!studentDept.containsKey(key)) {
                    writer.write(key + ", " + 0 + ", " + 0 + "\n");
                }
            }
            for (int key : studentList.keySet()) {
                if (studentDept.containsKey(key)) {
                    writer.write(key + ", " + studentDept.get(key)[0] + ", " + studentDept.get(key)[1] + "\n");
                }
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
