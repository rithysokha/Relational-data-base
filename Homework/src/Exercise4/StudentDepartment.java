//group8
package Exercise4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class StudentDepartment {
    private int studentID;
    private String studentName;
    private String studentGender;
    private String studentDOB;
    private int studentPhoneNo;
    private String studentAddress;
    private int studentYearOfStudy;
    private int studentGeneration;
    private String studentDegree;
    private int userID;
    private int departmentID;
    private String departmentName;

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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public StudentDepartment(String studentName, String studentGender, String studentDOB, int studentPhoneNo,
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

    HashMap<Integer, StudentDepartment> studentList = new HashMap<>();
    HashMap<Integer, int[]> studentInDepartment = new HashMap<>();
    HashMap<Integer, String> department = new HashMap<>();

    void displayLine() {
        System.out.println("==========================================================");
    }

    void displayMenu() {
        displayLine();
        System.out.println("A. Enroll student to department");
        System.out.println("B. Remove student from department");
        System.out.println("C. Display all student in department");
        System.out.println("D. Display departments enrolled by student");
    }

    void readFileStudent() {
        // read file for student
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
                int studentPhoneNoInt = Integer.parseInt(studentPhoneNoStr);
                int studentYearOfStudyInt = Integer.parseInt(studentYearOfStudyStr);
                int studentGenerationInt = Integer.parseInt(studentGenerationStr);
                int userIDInt = Integer.parseInt(userIDString);

                // Add the key-value pair to the HashMap.
                studentList.put(studentIDInt, new StudentDepartment(studentNameStr, studentGenderStr, studentDOBStr,
                        studentPhoneNoInt, studentAddressStr, studentYearOfStudyInt, studentGenerationInt,
                        studentDegreeStr, userIDInt));
            }
            // Close the file
            bufferedReader.close();
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    void readFileStudentDept() {
        // read file for student in department
        try {
            // Creates a reader that is linked with the myFile.txt
            FileReader reader = new FileReader("src\\data\\studentDept.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] keyValue = line.split(", ");
                String studentIDStr = keyValue[0];
                String deptartmentIDStr1 = keyValue[1];
                String deptartmentIDStr2 = keyValue[2];
                if (deptartmentIDStr1.equals("")) {
                    deptartmentIDStr1 = "0";
                }
                if (deptartmentIDStr2.equals("")) {
                    deptartmentIDStr2 = "0";
                }
                // convert data type
                Integer studentIDInteger = Integer.parseInt(studentIDStr);
                int departmentIDInteger1 = Integer.parseInt(deptartmentIDStr1);
                int departmentIDInteger2 = Integer.parseInt(deptartmentIDStr2);
                // storing department id for each student (max 2)
                int[] departmentArray = new int[2];
                departmentArray[0] = departmentIDInteger1;
                departmentArray[1] = departmentIDInteger2;
                studentInDepartment.put(studentIDInteger, departmentArray);
            }
            // Close the file
            bufferedReader.close();
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // read department file and put into hashmap
    void readFileDepartment() {
        try {
            // Creates a reader that is linked with the myFile.txt
            FileReader reader = new FileReader("src\\data\\department.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] keyValue = line.split(", ");
                String deptIDStr = keyValue[0];
                String deptNameStr = keyValue[1];
                // convert string to integer and double
                Integer deptIdInt = Integer.parseInt(deptIDStr);

                // Add the key-value pair to the HashMap.
                department.put(deptIdInt, deptNameStr);
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
        File file = new File("src\\data\\studentDept.txt");
        try {
            // write file back into account.txt
            FileWriter writer = new FileWriter(file);
            for (int key : studentInDepartment.keySet()) {
                writer.write(
                        key + ", " + studentInDepartment.get(key)[0] + ", " + studentInDepartment.get(key)[1] + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Student ID is invalid");
        }
    }

    void enrollStudentToDepartment(int studentID, int departmentID) {
        // check if student is already enrolled in 2 departments
        if (studentInDepartment.get(studentID)[0] == 0) {
            studentInDepartment.get(studentID)[0] = departmentID;
        } else if (studentInDepartment.get(studentID)[1] == 0) {
            studentInDepartment.get(studentID)[1] = departmentID;
        } else {
            System.out.println("Student is already enrolled in 2 departments");
        }
        writeFile();
    }

    void removeStudentFromDepartment(int studentID, int departmentID) {
        // check if student is enrolled in the department
        if (studentInDepartment.get(studentID)[0] == departmentID) {
            studentInDepartment.get(studentID)[0] = 0;
        } else if (studentInDepartment.get(studentID)[1] == departmentID) {
            studentInDepartment.get(studentID)[1] = 0;
        } else {
            System.out.println("Student is not enrolled in the department");
        }
        writeFile();
    }

    void displayAllStudentInDepartment(int deptpartmentID) {
        System.out.println("Student in department " + deptpartmentID + ":");
        for (int key : studentInDepartment.keySet()) {
            if (studentInDepartment.get(key)[0] == deptpartmentID
                    || studentInDepartment.get(key)[1] == deptpartmentID) {
                System.out.println(studentList.get(key).getStudentName());
            }
        }
    }

    void displayAllDepartmentOfStudent(int studentID) {
        readFileDepartment();
        System.out.println("Department enrolled by student " + studentID + ":");
        for (int key : studentInDepartment.keySet()) {
            if (key == studentID) {
                //willo display only the department they enrolled in
                if (department.get(studentInDepartment.get(key)[0]) != null) {
                    System.out.println(department.get(studentInDepartment.get(key)[0]));
                }
                if (department.get(studentInDepartment.get(key)[1]) != null) {
                    System.out.println(department.get(studentInDepartment.get(key)[1]));
                }
            }
        }
    }

}
