import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Faculty {
    private int facultyID;
    private String facultyName;
    private String deanName;
    private int officeNo;

    public String getDeanName() {
        return deanName;
    }

    public void setDeanName(String deanName) {
        this.deanName = deanName;
    }

    public int getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public int getOfficeNo() {
        return officeNo;
    }

    public void setOfficeNo(int officeNo) {
        this.officeNo = officeNo;
    }

    public Faculty(String facultyName, String deanName, int officeNo) {
        this.facultyName = facultyName;
        this.deanName = deanName;
        this.officeNo = officeNo;
    }

    HashMap<Integer, Faculty> facultyList = new HashMap<>();

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

    void addNewFaculty() {
        readFile();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter faculty ID: ");
            int facultyId = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter faculty name: ");
            String facultyNamee = scanner.nextLine();
            System.out.println("Enter dean name: ");
            String deanNamee = scanner.nextLine();
            System.out.println("Enter office number: ");
            int officeNoo = scanner.nextInt();
            facultyList.put(facultyId, new Faculty(facultyNamee, deanNamee, officeNoo));
            scanner.close();
        } catch (Exception e) {
            System.out.println("Wrong input type");
        }
        writeFile();

    }

    void searchFacultybyID() {
        readFile();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter faculty ID: ");
            int facultyId = scanner.nextInt();
            if (facultyList.containsKey(facultyId)) {
                System.out.println("Faculty ID: " + facultyId);
                System.out.println("Faculty Name: " + facultyList.get(facultyId).getFacultyName());
                System.out.println("Dean Name: " + facultyList.get(facultyId).getDeanName());
                System.out.println("Office No: " + facultyList.get(facultyId).getOfficeNo());
            } else {
                System.out.println("Faculty ID not found");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Wrong input type");
        }
    }

    void updateAFaculty() {
        readFile();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter faculty ID: ");
            int facultyId = scanner.nextInt();
            if (facultyList.containsKey(facultyId)) {
                System.out.println("Enter new faculty name: ");
                String newFacultyName = scanner.nextLine();
                System.out.println("Enter new dean name: ");
                String newDeanName = scanner.nextLine();
                System.out.println("Enter new office number: ");
                int newOfficeNo = scanner.nextInt();
                facultyList.get(facultyId).setFacultyName(newFacultyName);
                facultyList.get(facultyId).setDeanName(newDeanName);
                facultyList.get(facultyId).setOfficeNo(newOfficeNo);
                writeFile();
            } else {
                System.out.println("Faculty ID not found");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Wrong input type");
        }
    }

    void deleteAFaculty() {
        readFile();
        try{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter faculty ID: ");
        int facultyId = scanner.nextInt();
        if (facultyList.containsKey(facultyId)) {
            facultyList.remove(facultyId);
            writeFile();
        } else {
            System.out.println("Faculty ID not found");
        }
        scanner.close();
        } catch (Exception e) {
            System.out.println("Only number is allowed");
        }
    }
}