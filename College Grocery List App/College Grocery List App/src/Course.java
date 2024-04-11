import java.util.*;


public class Course {

    private String courseName;                 // e.g., COMP
    private int courseNum;                     // e.g., 271-002
    private String courseTitle;                // e.g., Data Structures I
    private int maxEnrollment;                 // Total capacity of classroom
    private int courseCreditHours;             // Total credit hours per class
    private Set<Student> registeredStudents;   // List of students registered
    private Queue<Student> waitList;           // List of students in order of arrival on a waitList for a course


    /**
     * Constructors
     **/
    public Course(String courseName, int courseNum, String courseTitle, int maxEnrollment, int courseCreditHours) {
        this.courseName = courseName;
        this.courseNum = courseNum;
        this.courseTitle = courseTitle;
        this.maxEnrollment = maxEnrollment;
        this.courseCreditHours = courseCreditHours;
        this.registeredStudents = new TreeSet<>(Comparator.comparing(Person::getFamilyName).thenComparing(Person::getGivenName));
        this.waitList = new LinkedList<>();
    }


    /**
     * Getter (Accessor) & Setter (Mutator) Methods()
     **/
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(int courseNum) {
        this.courseNum = courseNum;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getCourseCreditHours() {
        return courseCreditHours;
    }

    public void setCourseCreditHours(int courseCreditHours) {
        this.courseCreditHours = courseCreditHours;
    }

    public Set<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }


    /**
     * enrollStudent Method() - Registers a student to course if available, otherwise student is placed into a waitlist.
     **/
    public boolean enrollStudent(Student student) {
        if (registeredStudents.size() < maxEnrollment) {
            registeredStudents.add(student);
            return true;
        } else {
            waitList.add(student);
            return false;
        }
    }


    /**
     * unenrollStudent Method() - Removes a student from a course.  Then registers the next student on the waitlist
     *                            (assuming the waitlisted student still wants to be registered)
     **/
    public void unenrollStudent(Student student) {
        registeredStudents.remove(student);
        if (!waitList.isEmpty()) {
            registeredStudents.add(waitList.poll());
        }
    }
}