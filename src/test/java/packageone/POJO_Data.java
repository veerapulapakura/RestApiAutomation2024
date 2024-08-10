package packageone;
import static io.restassured.RestAssured.given;

public class POJO_Data {

    String name;
    String job;
    String[] courses;

    // Getter for name
    public String getName () {
        return name;
    }

    // Setter for name
    public void setName (String name){
        this.name = name;
    }

    // Getter for job
    public String getJob () {
        return job;
    }
    // Setter for job
    public void setJob (String job){
        this.job = job;
    }

    // Getter for courses
    public String[] getCourses() {
        return courses;
    }

    // Setter for courses
    public void setCourses(String[] courses) {
        this.courses = courses;
    }

}
