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

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    HashMap<Integer, String> studentList = new HashMap<>();
    HashMap<Integer, int[]> studentInDepartment = new HashMap<>();
    HashMap<Integer, String> departmentList = new HashMap<>();

    void displayLine() {
        System.out.println("==========================================================");
    }

    void displayMenu() {
        displayLine();
        System.out.println("A. Enroll student to department");
        System.out.println("B. Remove student from department");
        System.out.println("C. Display all student in department");
        System.out.println("D. Display departments enrolled by student");
        System.out.println("E. Exit");
    }
    //read file and input data to hashmap studentList
    void readFileStudent() {
        try {
            FileReader reader = new FileReader("src\\data\\student.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] keyValue = line.split(", ");
                String studentIDStr = keyValue[0];
                String studentNameStr = keyValue[1];
                // convert data type
                Integer studentIDInt = Integer.parseInt(studentIDStr);
                // Add the key-value pair to the HashMap.
                studentList.put(studentIDInt, studentNameStr);
            }
            // Close the file
            bufferedReader.close();
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    //read file studentDept and put data to hashmap studentInDepartment
    void readFileStudentDept() {
        try {
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
                departmentList.put(deptIdInt, deptNameStr);
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
    // enroll studnent into department (max 2)
    void enrollStudentToDepartment(int studentID, int departmentID) {
        if (departmentList.containsKey(departmentID)) {
            //check if student is already enrolled in that department
            if (studentInDepartment.get(studentID)[1] != departmentID
                    && studentInDepartment.get(studentID)[0] != departmentID) { 
                    // check if student is already enrolled in 2 departments
                if (studentInDepartment.get(studentID)[0] == 0) {
                    studentInDepartment.get(studentID)[0] = departmentID;
                } else if (studentInDepartment.get(studentID)[1] == 0) {
                    studentInDepartment.get(studentID)[1] = departmentID;
                } else {
                    System.out.println("Student is already enrolled in 2 departments");
                }
                writeFile();
            } else {
                System.out.println("Student is already enrolled in this department");
            }
        } else {
            System.out.println("Department ID is invalid");
        }

    }
    //remove student from department
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
    //display all student in department
    void displayAllStudentInDepartment(int departmentID) {
        if (departmentList.containsKey(departmentID)) {
            System.out.println("Student in department " + departmentList.get(departmentID) + ":");
            for (int key : studentInDepartment.keySet()) {
                if (studentInDepartment.get(key)[0] == departmentID
                        || studentInDepartment.get(key)[1] == departmentID) {
                    System.out.println(studentList.get(key));
                }
            }
        } else {
            System.out.println("Department ID is invalid");
        }
    }
    //display all department that one student enrolled
    void displayAllDepartmentOfStudent(int studentID) {
        if (studentList.containsKey(studentID)) {
            System.out.println("Department enrolled by student " + studentList.get(studentID) + ":");
            for (int key : studentInDepartment.keySet()) {
                if (key == studentID) {
                    // will only display only the department they enrolled in
                    if (departmentList.get(studentInDepartment.get(key)[0]) != null) {
                        System.out.println(departmentList.get(studentInDepartment.get(key)[0]));
                    }
                    if (departmentList.get(studentInDepartment.get(key)[1]) != null) {
                        System.out.println(departmentList.get(studentInDepartment.get(key)[1]));
                    }
                }
            }
        } else {
            System.out.println("Student ID is invalid");
        }
    }

}
