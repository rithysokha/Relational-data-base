//group8
package Exercise1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class Faculty {
    private String facultyName;
    private String deanName;
    private int officeNo;

    public String getDeanName() {
        return deanName;
    }
    public String getFacultyName() {
        return facultyName;
    }
    public int getOfficeNo() {
        return officeNo;
    }

    public Faculty(String facultyName, String deanName, int officeNo) {
        this.facultyName = facultyName;
        this.deanName = deanName;
        this.officeNo = officeNo;
    }

    HashMap<Integer, Faculty> facultyList = new HashMap<>();

    void displayLine() {
        System.out.println("=================================================");
    }

    // read file and input data to hashmap
    void readFile() {
        try {
            // Creates a reader that is linked with the myFile.txt
            FileReader reader = new FileReader("src\\data\\faculty.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] keyValue = line.split(", ");
                String facID = keyValue[0];
                String facultyNameStr = keyValue[1];
                String deanNameStr = keyValue[2];
                String officeNoStr = keyValue[3];
                // convert string to integer and double
                Integer facultyIdInt = Integer.parseInt(facID);
                int officeNoInt = Integer.parseInt(officeNoStr);

                // Add the key-value pair to the HashMap.
                facultyList.put(facultyIdInt, new Faculty(facultyNameStr, deanNameStr, officeNoInt));
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
        File file = new File("src\\data\\faculty.txt");
        try {
            // write file back into account.txt
            FileWriter writer = new FileWriter(file);
            for (int key : facultyList.keySet()) {
                writer.write(key + ", " + facultyList.get(key).getFacultyName() + ", " +
                        facultyList.get(key).getDeanName() + ", " +
                        facultyList.get(key).getOfficeNo() + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void addNewFaculty(int facultyID, String facultyName, String deanName, int officeNo) {
        displayLine();
            facultyList.put(facultyID, new Faculty("Faculty of " + facultyName, deanName, officeNo));
            writeFile();
    }

    void searchFacultybyID(int facultyID) {
        displayLine();
            if (facultyList.containsKey(facultyID)) {
                System.out.println("Faculty ID: " + facultyID);
                System.out.println("Faculty Name: " + facultyList.get(facultyID).getFacultyName());
                System.out.println("Dean Name: " + facultyList.get(facultyID).getDeanName());
                System.out.println("Office No: " + facultyList.get(facultyID).getOfficeNo());
            } else {
                System.out.println("Faculty ID not found");
            }
    }

    void deleteAFaculty(int facultyID) {
        displayLine();
       
            if (facultyList.containsKey(facultyID)) {
                facultyList.remove(facultyID);
                writeFile();
            } else {
                System.out.println("Faculty ID not found");
            }
    }
}