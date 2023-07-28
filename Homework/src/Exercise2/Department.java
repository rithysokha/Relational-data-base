package Exercise2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Department {
    private int deptID;
    private String deptName;
    private String headName;
    private int officeNo;
    private int facultyID;

    public int getDeptID() {
        return deptID;
    }

    public void setDeptID(int deptID) {
        this.deptID = deptID;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getHeadName() {
        return headName;
    }

    public void setHeadName(String headName) {
        this.headName = headName;
    }

    public int getOfficeNo() {
        return officeNo;
    }

    public void setOfficeNo(int officeNo) {
        this.officeNo = officeNo;
    }

    public int getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }

    public Department(String deptName, String headName, int officeNo, int facultyID) {
        this.deptName = deptName;
        this.headName = headName;
        this.officeNo = officeNo;
        this.facultyID = facultyID;
    }

    HashMap<Integer, Department> departmentList = new HashMap<>();

    void displayLine(){
        System.out.println("==================================================");
    }
    // read file and input data to hashmap
    void readFile() {
        try {
            // Creates a reader that is linked with the myFile.txt
            FileReader reader = new FileReader("src\\data\\department.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] keyValue = line.split(", ");
                String deptIDStr = keyValue[0];
                String deptNameStr = keyValue[1];
                String headNameStr = keyValue[2];
                String officeNoStr = keyValue[3];
                String facultyIDStr = keyValue[4];
                // convert string to integer and double
                Integer deptIdInt = Integer.parseInt(deptIDStr);
                int officeNoInt = Integer.parseInt(officeNoStr);
                int facultyIdInt = Integer.parseInt(facultyIDStr);

                // Add the key-value pair to the HashMap.
                departmentList.put(deptIdInt, new Department(deptNameStr, headNameStr, officeNoInt, facultyIdInt));
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
        File file = new File("src\\data\\department.txt");
        try {
            // write file back into account.txt
            FileWriter writer = new FileWriter(file);
            for (int key : departmentList.keySet()) {
                writer.write(key + ", " + departmentList.get(key).getDeptName() + ", " +
                        departmentList.get(key).getHeadName() + ", " +
                        departmentList.get(key).getOfficeNo() + ", " + departmentList.get(key).getFacultyID() + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void addNewDepartment() {
        displayLine();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter department ID: ");
            int deptartmentID = scanner.nextInt();
            scanner.nextLine();

            if (departmentList.containsKey(deptartmentID)) {
                System.out.println("Department ID already exist.");
            } else {
                System.out.println("Enter department name: ");
                String departmentName = scanner.nextLine();
                System.out.println("Enter department head name: ");
                String departmentHead = scanner.nextLine();
                System.out.println("Enter department office No: ");
                int officeNoo = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter faculty id: ");
                int facultyId = scanner.nextInt();
                scanner.nextLine();
                departmentList.put(deptartmentID, new Department(departmentName, departmentHead, officeNoo, facultyId));
            }
            writeFile();
        } catch (Exception e) {
            System.out.println("Wrong input type");
        }
    }

    void searchDepartmentByID() {
        displayLine();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter department ID");
            int departmentId = scanner.nextInt();
            scanner.nextLine();
            if (departmentList.containsKey(departmentId)) {
                System.out.println("Department ID: " + departmentId);
                System.out.println("Department name: " + departmentList.get(departmentId).getDeptName());
                System.out.println("Department head name: " + departmentList.get(departmentId).getHeadName());
                System.out.println("Department office No: " + departmentList.get(departmentId).getOfficeNo());
                System.out.println("Faculty No: " + departmentList.get(departmentId).getFacultyID());
            } else {
                System.out.println("Invalid ID");
            }
        } catch (Exception e) {
            System.out.println("Only number is allowed");
        }
    }

    void updateADepartmentByID() {
        displayLine();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter department ID you want to update: ");
            int departmetnId = scanner.nextInt();
            scanner.nextLine();
            if (departmentList.containsKey(departmetnId)) {
                System.out.println("Enter new department name: ");
                String departmentName = scanner.nextLine();
                System.out.println("Enter new department head name: ");
                String departmentHead = scanner.nextLine();
                System.out.println("Enter new department office No: ");
                int officeNoo = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter new faculty ID: ");
                int facultyId = scanner.nextInt();
                scanner.nextLine();
                departmentList.put(departmetnId, new Department(departmentName, departmentHead, officeNoo, facultyId));
                writeFile();
            }else{
                System.out.println("Invalid department ID.");
            }

        } catch (Exception e) {
            System.out.println("Wrong input type");
        }
    }
    void deleteDepartmentByID(){
        displayLine();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter department ID you want to delete: ");
            int departmentId = scanner.nextInt();
            scanner.nextLine();
            if (departmentList.containsKey(departmentId)) {
                departmentList.remove(departmentId);
                writeFile();
            }else{
                System.out.println("Invalid department ID.");
            }
        } catch (Exception e) {
            System.out.println("Wrong input type");
        }
    }
    void deisplayDepartmentInFaculty(){
        displayLine();
        readFile();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter faculty ID: ");
            int facultyId = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Department in faculty: ");
            System.out.println("Faculty ID" +"\t" + "Department ID" + "\t" + "Department name" + "\t" + "Department head name" + "\t" + "Department office No"	);
            for (int key : departmentList.keySet()) {
                if (departmentList.get(key).getFacultyID() == facultyId) {
                    System.out.println(facultyId + "\t" + key + "\t" + departmentList.get(key).getDeptName() + "\t" + departmentList.get(key).getHeadName() + "\t" + departmentList.get(key).getOfficeNo());
                }
            }
        } catch (Exception e) {
            System.out.println("Wrong input type");
        }
    }
}
