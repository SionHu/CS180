/**
 * Created by apple on 03/03/2017.
 */
public class Professor extends Person {
    double salary;
    String course;
    String rank;

    public Professor(String name, String address, String course, String rank){
        super(name, address);
        this.course = course;
        this.rank = rank;
    }
     public double getSalary(){
         if (rank.equals("Professor")){
             salary = 100000;
         }else if (rank.equals("Assistant")){
             salary = 70000;
         }
        return salary;
    }

     public void setSalary(double salary){
         this.salary = salary;
         if (rank.equals("Prpfessor")){
             salary = 100000;
         }else if (rank.equals("Assistant")){
             salary = 70000;
         }
     }

     public String getCourse(){return course;}

     public void setCourse(String course){this.course = course;}

     public String getRank(){
         if (rank.equals("Prpfessor")){
             salary = 100000;
         }else if (rank.equals("Assistant")){
             salary = 70000;
         }
         return rank;
     }

     public void setRank(String rank){this.rank = rank;}

}
