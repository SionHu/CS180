/**
 * Created by apple on 03/03/2017.
 */
public class Person {
    String name;
    String address;
    public Person(String name, String address){
        this.name = name;
        this.address = address;
    }

    public String getName(){return name;}

    public void setName(String name){this.name = name;}

    public String getAddress(){return address;}

    public void setAddress(String address){this.address = address;};

    public static void main(String[] args) {
        String courseName = "MA16200";
        Professor p = new Professor("Dr. Malcom", "MATH", courseName, "Professor");
        Course c = new Course(p, courseName); 		  // creates a new Course

        Student s = new Student("Bobby Jones", "Earhart Hall");  // Creates new Student

        System.out.println(s.getCourses()[0]);              // prints "none"
        System.out.println(c.enroll(s));                    // prints "true"
        System.out.println(s.getCourses()[0]);              // prints "MA16200"
        System.out.println(c.getStudents()[0].getName());   // prints "Bobby Jones"
        System.out.println(c.getProfessor().getName());     // prints "Dr. Malcom"

        System.out.println(c.getcourseName());
        System.out.println(s.getAddress());
        System.out.println(s.addCourse(courseName));
        System.out.println(s.addCourse(courseName));
        System.out.println(p.getSalary());

    }
}
