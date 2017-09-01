import java.util.Arrays;

/**
 * Created by apple on 03/03/2017.
 */
public class Student extends Person {
    String[] courses;
    char[] grades;

    public Student(String name, String address){
        super(name,address);
        this.courses = new String[6];
        Arrays.fill(courses, "none");
        this.grades = new char[6];
        Arrays.fill(grades, 'A');

    }
    public boolean addCourse(String course){
        boolean result = false;
        int num_courses = 0;
        for (int i = 0; i < courses.length; i++){
            if (courses[i] != null){
                num_courses++;
            }
            if (courses[i] != course && num_courses != 6){
                if (courses[i] == null){
                    courses[i] = course;
                    result = true;
                }
            }else result = false;
        }
        return result;
    }

    public String[] getCourses(){return courses;}

    public void setCourses(String[] courses){this.courses = courses;}

    public char[] getGrades(){return grades;}

    public void setGrades(char[] grades){this.grades = grades;}
}
