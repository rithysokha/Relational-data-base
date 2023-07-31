package Exercise7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class TeacherCourse {
    private int teacherID;
    private String teacherName;
    private int courseID;
    private String courseName;

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

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

    HashMap<Integer, int[]> teacherCourseList = new HashMap<>();
    HashMap<Integer, String> courseList = new HashMap<>();
    HashMap<Integer, String> teacherList = new HashMap<>();

    void displayLine() {
        System.out.println("====================================================");
    }

    void displayMenu() {
        displayLine();
        System.out.println("A. Assign a course to a teacher");
        System.out.println("B. Remove a course from a teacher");
        System.out.println("C. Display all courses taught by a teacher");
        System.out.println("D. Exit");
        displayLine();
    }

    void readFileTeacher() {
        try {
            // Creates a reader that is linked with the myFile.txt
            FileReader reader = new FileReader("src\\data\\teacher.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] keyValue = line.split(", ");
                String teacherIDStr = keyValue[0];
                String teacherNameStr = keyValue[1];
                // convert data type
                Integer teacherIDInt = Integer.parseInt(teacherIDStr);
                // put data back to hashMap
                teacherList.put(teacherIDInt, teacherNameStr);
            }
            // Close the file
            bufferedReader.close();
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void readFileCourse() {
        try {
            // Creates a reader that is linked with the myFile.txt
            FileReader reader = new FileReader("src\\data\\course.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] keyValue = line.split(", ");
                String courseIDStr = keyValue[0];
                String courseNameStr = keyValue[1];
                // convert to data type
                Integer courseIDInteger = Integer.parseInt(courseIDStr);
                // Add the key-value pair to the HashMap.
                courseList.put(courseIDInteger, courseNameStr);
            }
            // Close the file.
            bufferedReader.close();
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // read file teacherCourse.txt and put into teacherCourseList
    void readFileTeacherCourse() {
        try {
            // Creates a reader that is linked with the myFile.txt
            FileReader reader = new FileReader("src\\data\\teacherCourse.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] keyValue = line.split(", ");
                String teacherIDStr = keyValue[0];

                String courseIDStr1 = keyValue[1];
                String courseIDStr2 = keyValue[2];
                String courseIDStr3 = keyValue[3];
                String courseIDStr4 = keyValue[4];
                String courseIDStr5 = keyValue[5];

                // convert data type
                Integer teacherIDInteger = Integer.parseInt(teacherIDStr);
                int courseIDInt1 = Integer.parseInt(courseIDStr1);
                int courseIDInt2 = Integer.parseInt(courseIDStr2);
                int courseIDInt3 = Integer.parseInt(courseIDStr3);
                int courseIDInt4 = Integer.parseInt(courseIDStr4);
                int courseIDInt5 = Integer.parseInt(courseIDStr5);

                // storing department id for each student (max 5)
                int[] courseArray = new int[5];
                courseArray[0] = courseIDInt1;
                courseArray[1] = courseIDInt2;
                courseArray[2] = courseIDInt3;
                courseArray[3] = courseIDInt4;
                courseArray[4] = courseIDInt5;
                teacherCourseList.put(teacherIDInteger, courseArray);
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
        File file = new File("src\\data\\teacher.txt");
        try {
            // write file back into account.txt
            FileWriter writer = new FileWriter(file);
            for (int key : teacherCourseList.keySet()) {
                writer.write(key + ", " + teacherCourseList.get(key)[0] + ", " + teacherCourseList.get(key)[1] + ", "
                        + teacherCourseList.get(key)[2] + ", " + teacherCourseList.get(key)[3] + ", "
                        + teacherCourseList.get(key)[4] + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void assignCourseToATeacher(int teacherID, int courseID) {
        if (teacherCourseList.get(teacherID)[0] == 0) {
            teacherCourseList.get(teacherID)[0] = courseID;
        } else if (teacherCourseList.get(teacherID)[1] == 0) {
            teacherCourseList.get(teacherID)[1] = courseID;
        } else if (teacherCourseList.get(teacherID)[2] == 0) {
            teacherCourseList.get(teacherID)[2] = courseID;
        } else if (teacherCourseList.get(teacherID)[3] == 0) {
            teacherCourseList.get(teacherID)[3] = courseID;
        } else if (teacherCourseList.get(teacherID)[4] == 0) {
            teacherCourseList.get(teacherID)[4] = courseID;
        } else {
            System.out.println("This teacher has already assigned 5 courses");
        }
    }

    void removeCourseFromATeacher(int teacherID, int courseID) {
        if (teacherCourseList.get(teacherID)[0] == courseID) {
            teacherCourseList.get(teacherID)[0] = 0;
        } else if (teacherCourseList.get(teacherID)[1] == courseID) {
            teacherCourseList.get(teacherID)[1] = 0;
        } else if (teacherCourseList.get(teacherID)[2] == courseID) {
            teacherCourseList.get(teacherID)[2] = 0;
        } else if (teacherCourseList.get(teacherID)[3] == courseID) {
            teacherCourseList.get(teacherID)[3] = 0;
        } else if (teacherCourseList.get(teacherID)[4] == courseID) {
            teacherCourseList.get(teacherID)[4] = 0;
        } else {
            System.out.println("This teacher does not have this course");
        }
    }

    void displayAllCourseToughByATeacher(int teacherID) {
        readFileCourse();
        System.out.println("Teacher ID: " + teacherID);
        System.out.println("Teacher Name: " + teacherList.get(teacherID));
        for (int index = 0; index <= 4; index++) {
            if (teacherCourseList.get(teacherID)[index] != 0) {
                System.out.println("Course ID: " + teacherCourseList.get(teacherID)[index]);
                System.out.println("Course Name: " + courseList.get(teacherCourseList.get(teacherID)[index]));
            }
        }
    }

}
