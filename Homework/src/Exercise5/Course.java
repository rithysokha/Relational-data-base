package Exercise5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;


public class Course {
    private int courseID;
    private String courseName;
    private int credit;
    private String type;

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    Course(String courseName, int credit, String type) {
        this.courseName = courseName;
        this.credit = credit;
        this.type = type;
    }

    HashMap<Integer, Course> courseList = new HashMap<>();

    // read file and input data to hashmap
    void readFile() {
        try {
            // Creates a reader that is linked with the myFile.txt
            FileReader reader = new FileReader("src\\data\\course.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] keyValue = line.split(", ");
                String courseIDStr = keyValue[0];
                String courseNameStr = keyValue[1];
                String creditStr = keyValue[2];
                String typeStr = keyValue[3];
                // convert to data type
                Integer courseIDInteger = Integer.parseInt(courseIDStr);
                int creditInt = Integer.parseInt(creditStr);

                // Add the key-value pair to the HashMap.
                courseList.put(courseIDInteger, new Course(courseNameStr, creditInt, typeStr));
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
        File file = new File("src\\data\\course.txt");
        try {
            // write file back into account.txt
            FileWriter writer = new FileWriter(file);
            for (int key : courseList.keySet()) {
                writer.write(key + ", " + courseList.get(key).getCourseName() + ", " +
                        courseList.get(key).getCredit() + ", " +
                        courseList.get(key).getType() + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void displayLine() {
        System.out.println("========================================================");
    }

    void displayMenu() {
        displayLine();
        System.out.println("A. Add new course.");
        System.out.println("Search course by ID.");
        System.out.println("Update course.");
        System.out.println("Delete course.");
    }

    void createCourse(int courseID, String courseName, int credit, String type) {
        courseList.put(courseID, new Course(courseName, credit, type));
    }

    void searchCourse(int courseID) {
        if (courseList.containsKey(courseID)) {
            System.out.println("Course name: " + courseList.get(courseID).getCourseName());
            System.out.println("Credit: " + courseList.get(courseID).getCredit());
            System.out.println("Type: " + courseList.get(courseID).getType());
        } else {
            System.out.println("Course not found.");
        }
    }

    void deleteCourse(int courseID) {
        if (courseList.containsKey(courseID)) {
            courseList.remove(courseID);
        } else {
            System.out.println("Course not found.");
        }
    }
}
