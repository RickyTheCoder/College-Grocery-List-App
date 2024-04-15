import java.util.*;

public class Admin {
    private Set<Person> people;
    private Set<Course> courses;

    public Admin() {
        people = new HashSet<Person>();
        courses = new HashSet<Course>();
    }

    public void recordPerson(String familyName, String givenNames, int day, int month, int year, boolean isMale) {
        people.add(new Person(familyName, givenNames, day, month, year, isMale));
    }

    public void recordStudent(String familyName, String givenNames, int id, int day, int month, int year, boolean isMale) {
        people.add(new Student(familyName, givenNames, id, day, month, year, isMale));
    }

    public void recordUnderGradStudent(String familyName, String givenNames, int id, int day, int month, int year, boolean isMale) {
        people.add(new UnderGradStudent(familyName, givenNames, id, day, month, year, isMale));
    }

    public void recordGradStudent(String familyName, String givenNames, int id, int day, int month, int year, boolean isMale) {
        people.add(new GraduateStudent(familyName, givenNames, id, day, month, year, isMale));
    }

    public Person findPerson(String familyName, String givenNames) {
        for (Person p : people) {
            if (p.getFamilyName().equals(familyName) && p.getGivenNames().equals(givenNames)) {
                return p;
            }
        }
        return null;
    }

    public Student findStudent(String familyName, String givenNames) {
        for (Person person : people) {
            if (person instanceof Student &&
                    person.getFamilyName().equals(familyName) &&
                    person.getGivenNames().equals(givenNames)) {
                return (Student) person;
            }
        }
        return null;
    }

    public void recordCourse(String department, int id, String title, int maxEnrollment, int creditHours) {
        courses.add(new Course(department, id, title, maxEnrollment, creditHours));
    }

    public Course findCourse(String courseName, int courseNum) {
        for (Course course : courses) {
            if (course.getCourseName().equals(courseName) &&
                    course.getCourseNum() == courseNum) {
                return course;
            }
        }
        return null;
    }

    public boolean enrollStudent(String familyName, String givenNames, String department, int id) {
        Student student = findStudent(familyName, givenNames);
        Course course = findCourse(department, id);
        if (student == null || course == null) {
            throw new IllegalArgumentException("Course or Student is null");
        }
        if (course.requestRegistration(student)) {
            student.addCourse(course);
            return true;
        }
        return false;
    }

    public boolean removeStudent(String familyName, String givenNames, String department, int id) {
        Student student = findStudent(familyName, givenNames);
        Course course = findCourse(department, id);
        if (student == null || course == null) {
            throw new IllegalArgumentException("student or course is null");
        }
        course.unenrollStudent(student);
        student.removeCourse(course);
        return true;
    }

    public List<Student> reportRegistrations() {
        List<Student> allRegistered = new ArrayList<>();
        for (Person person : people) {
            if (person instanceof Student && ((Student) person).hasRegisteredCourse()) {
                allRegistered.add((Student) person);
            }
        }
        Collections.sort(allRegistered, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getFamilyName().compareTo(o2.getFamilyName());
            }
        });
        return allRegistered;
    }

    public List<Student> reportWaitListed() {
        Set<Student> set = new HashSet<>();
        for (Course course : courses) {
            set.addAll(course.getWaitlisted());
        }
        List<Student> res = new ArrayList<>(set);
        Collections.sort(res, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getFamilyName().compareTo(o2.getFamilyName());
            }
        });
        return res;
    }
}
