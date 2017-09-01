/**
 * Created by apple on 03/03/2017.
 */
public class Course {
    Professor professor;
    Student[] students = new Student[100];
    String courseName;
    int numEnrolled;

    public Course(Professor professor, String courseName){
        this.professor = professor;
        this.courseName = courseName;
    }

    public boolean enroll(Student s){
        boolean result = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = s;
                numEnrolled += 1;
                if (numEnrolled < 100) {
                    result = true;
                }
            }else {
                result = false;
            }
        }
        return result;
    }

    public Professor getProfessor(){return professor;}

    public Student[] getStudents(){return students;}

    public String getcourseName(){return courseName;}

    public int getNumEnrolled(){return numEnrolled;}
}
