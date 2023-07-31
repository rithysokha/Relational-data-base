//group8
package Exercise2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class Department {
    private String deptName;
    private String headName;
    private int officeNo;
    private int facultyID;

    public String getDeptName() {
        return deptName;
    }
    public String getHeadName() {
        return headName;
    }
    public int getOfficeNo() {
        return officeNo;
    }
    public int getFacultyID() {
        return facultyID;
    }

    public Department(String deptName, String headName, int officeNo, int facultyID) {
        this.deptName = deptName;
        this.headName = headName;
        this.officeNo = officeNo;
        this.facultyID = facultyID;
    }

    HashMap<Integer, Department> departmentList = new HashMap<>();

    void displayLine() {
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

    // this method is used to add new department and update department
    // this method is reusable with update department by ID
    void addNewDepartment(int deptID, String deptName, String headName, int officeNo, int facultyID) {
        displayLine();
        departmentList.put(deptID, new Department(deptName, headName, officeNo, facultyID));
        writeFile();
    }

    // this method is used to search department by ID
    void searchDepartmentByID(int deptID) {
        displayLine();
        if (departmentList.containsKey(deptID)) {
            System.out.println("Department ID: " + deptID);
            System.out.println("Department name: " + departmentList.get(deptID).getDeptName());
            System.out.println("Department head name: " + departmentList.get(deptID).getHeadName());
            System.out.println("Department office No: " + departmentList.get(deptID).getOfficeNo());
            System.out.println("Faculty No: " + departmentList.get(deptID).getFacultyID());
        } else {
            System.out.println("Invalid ID");
        }
    }

    // this method is used to delete department by ID
    void deleteDepartmentByID(int deptID) {
        displayLine();
        if (departmentList.containsKey(deptID)) {
            departmentList.remove(deptID);
            writeFile();
        } else {
            System.out.println("Invalid department ID.");
        }
    }

    // this method is used to display department in faculty
    void deisplayDepartmentInFaculty(int facultyID) {
        displayLine();
        readFile();
        System.out.println("Department in faculty: ");
        System.out.println("Faculty ID" + "\t" + "Department ID" + "\t" + "Department name" + "\t"
                + "Department head name" + "\t" + "Department office No");
        for (int key : departmentList.keySet()) {
            if (departmentList.get(key).getFacultyID() == facultyID) {
                System.out.println(facultyID + "\t" + key + "\t" + departmentList.get(key).getDeptName() + "\t"
                        + departmentList.get(key).getHeadName() + "\t" + departmentList.get(key).getOfficeNo());
            }
        }
    }
}
