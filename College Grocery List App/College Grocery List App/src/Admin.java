import java.util.*;

public class Admin {
    private Set<Person> people;
    private Set<Course> courses;

    public Admin() {
        people = new HashSet<Person>();
        courses = new HashSet<Course>();
    }

    public void recordPerson(String familyName, String givenNames) {
        people.add(new Person(familyName, givenNames));
    }

    public void recordStudent(String familyName, String givenNames, int id) {
        people.add(new Student(familyName, givenNames, id));
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

    public void recordCourse(String department, int id, String title, int maxEnrollment) {
        courses.add(new Course(department, id, title, maxEnrollment));
    }

    public Course findCourse(String department, int id) {
        for (Course course : courses) {
            if (course.getDepartment().equals(department) &&
                    course.getId() == id) {
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
        if (course.enrollStudent(student)) {
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
            set.addAll(course.allWaitlisted());
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
