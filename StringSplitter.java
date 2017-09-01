/**
 * Created by apple on 20/01/2017.
 */
public class StringSplitter {
    public String formSubmission(String s){
        String firstName = s.substring(0,s.indexOf(' '));
        String lastName = s.substring(s.indexOf(' ')+1, s.indexOf(','));
        String[] date = s.split("/");
        int Yr = Integer.parseInt(date[2]);
        int age = 2017 - Yr;
        String agenum = Integer.toString(age);
        return "First name: " + firstName +"\n"+ "Last name: " + lastName +"\n"+ "Approximate Age: " + agenum;
    }

    public static void main(String[] args) {
        StringSplitter stringSplitter = new StringSplitter();
        System.out.println(stringSplitter.formSubmission("John Doe, 1/7/1992"));
    }
}
