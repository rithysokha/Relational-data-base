package Exercise9;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;

public class Login {
    HashMap<Integer, Integer> accountList = new HashMap<>();
    HashMap<Integer, String> studentList = new HashMap<>();
    HashMap<Integer, String> teacherList = new HashMap<>();

    // read file and input data to hashmap
    void readFileStudent() {
        try {
            FileReader reader = new FileReader("src\\data\\student.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] keyValue = line.split(", ");
                String studentIDStr = keyValue[0];
                String studentName = keyValue[1];
                // convert data type
                Integer studentIDInt = Integer.parseInt(studentIDStr);

                // Add the key-value pair to the HashMap.
                studentList.put(studentIDInt, studentName);
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
            FileReader reader = new FileReader("src\\data\\teacher.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] keyValue = line.split(", ");
                String teacherIDStr = keyValue[0];
                String teacherName = keyValue[1];
                // convert data type
                Integer teacherIDInt = Integer.parseInt(teacherIDStr);
                // Add the key-value pair to the HashMap.
                teacherList.put(teacherIDInt, teacherName);
            }
            // Close the file
            bufferedReader.close();
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void readFileAccount() {
        try {
            FileReader reader = new FileReader("src\\data\\account.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] keyValue = line.split(", ");
                String userIDStr = keyValue[0];
                String password = keyValue[1];
                // convert data type
                Integer userIDInt = Integer.parseInt(userIDStr);
                Integer passwordInt = Integer.parseInt(password);
                // Add the key-value pair to the HashMap.
                accountList.put(userIDInt, passwordInt);
            }
            // Close the file
            bufferedReader.close();
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //login
    void logIn(int userID, int password){
        if (accountList.containsKey(userID)) {
            if (accountList.get(userID) == password) {
                System.out.println("Login successful");
                //if the userID higher than 1000 they are student
                if (userID > 1000) {
                    System.out.println("Hi student " + studentList.get(userID - 1000));
                } else {
                    //if userID lower than 1000 they are teacher
                    System.out.println("Hi teacher " + teacherList.get(userID));
                }
            } else {
                System.out.println("Wrong password");
            }
        } else {
            System.out.println("Wrong userID");
        }
    }
}