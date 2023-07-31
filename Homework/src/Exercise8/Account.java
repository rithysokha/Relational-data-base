package Exercise8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class Account {

    HashMap<Integer, Integer> accountList = new HashMap<>();
    HashMap<Integer, Integer> studentList = new HashMap<>();
    HashMap<Integer, Integer> teacherList = new HashMap<>();
    void displayLine(){
        System.out.println("==================================================");
    }
    void displayMenu(){
        displayLine();
        System.out.println("A. Create account for student.");
        System.out.println("B. Create account for teacher.");
        System.out.println("C. Exit.");
    }
     // read file and input data to hashmap
    void readFileStudent() {
        try {
            // Creates a reader that is linked with the myFile.txt
            FileReader reader = new FileReader("src\\data\\student.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] keyValue = line.split(", ");
                String studentIDStr = keyValue[0];
                String userIDString = keyValue[9];
                // convert data type
                Integer studentIDInt = Integer.parseInt(studentIDStr);
                int userIDInt = Integer.parseInt(userIDString);
                // Add the key-value pair to the HashMap.
                studentList.put(studentIDInt, userIDInt);
            }
            // Close the file
            bufferedReader.close();
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    // read file and input data to hashmap
    void readFileTeacher() {
        try {
            // Creates a reader that is linked with the myFile.txt
            FileReader reader = new FileReader("src\\data\\teacher.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] keyValue = line.split(", ");
                String teacherIDStr = keyValue[0];
                String userIDString = keyValue[6];
                // convert data type
                Integer teacherIDInt = Integer.parseInt(teacherIDStr);
                int userIDInt = Integer.parseInt(userIDString);
                // Add the key-value pair to the HashMap.
                teacherList.put(teacherIDInt, userIDInt);
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
        File file = new File("src\\data\\account.txt");
        try {
            // write file back into account.txt
            FileWriter writer = new FileWriter(file);
            for (int key : accountList.keySet()) {
                writer.write(key + ", " +accountList.get(key)+ "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    void createAccount(int userID, int password){
        displayLine();
        accountList.put(userID, password);
        System.out.println("The account is created!");
        System.out.println("UserID: " + userID);
        System.out.println("Password: "+accountList.get(userID));
        writeFile();
    }
}
