import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Student extends Person {
    private int id;
    private Set<Course> courses;

    public Student(String familyName, String givenNames, int id, int day, int month, int year) {
        super(familyName, givenNames, day, month, year);
        this.id = id;
        courses = new HashSet<Course>();
    }

    public boolean addCourse(Course course) {
        return courses.add(course);
    }

    public boolean removeCourse(Course course) {
        return courses.remove(course);
    }

    public int amountRegistered() {
        return courses.size();
    }

    public boolean hasRegisteredCourse() {
        return !courses.isEmpty();
    }

    public String toString() {
        return "Student(" + getFamilyName() + ", " + getGivenNames() + ", " + id + ")";
    }
}