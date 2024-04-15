import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    /*
    This is an expansion of the WaitListTester to add GroceryStore and GroceryItem objects for testing
    Version 2, making some students graduates and some undergraduates

    As we continue to add more functionality to our combined code, please keep the full set of test cases
        ...even if not used in the current assignment.
        You need to have all the combined code working together (as in your UML overview diagram)

    As before, my test cases assume separate container / collection classes for key parts of the app
    Adjust the code as necessary if you have a combined or different approach to get access to these objects
    */
    public static void main(String[] args)
    {
        //Instantiate an additional collection to hold GroceryStores (or eliminate by setting stores = your collection
        GroceryStoreContainer stores = new GroceryStoreContainer();
        // createStores(stores);
        //Add GroceryItems to at least two stores
        // createGroceryItems(stores);

        // Instantiate one or two collections to hold Person and Course objects
        Admin admin = new Admin();

        // Create some people and students in the container
        createPeopleAndStudents(admin);
        // Create some courses in the container
        createCourses(admin);

        // Enroll students by name in courses by name
        registerStudents(admin);
        //Show current state (requirement 2a and 2b as List<String> suitable for printing)
        System.out.println("Registered after initial registrations:\n" + admin.reportRegistrations());
        System.out.println("Waitlisted after initial registrations:\n" + admin.reportWaitListed());

        // Remove some courses for some students
        dropStudents(admin);
        //Show current state again
        System.out.println("Registered after some drop:\n" + admin.reportRegistrations());
        System.out.println("Waitlisted after some drop:\n" + admin.reportWaitListed());

        addParentsAndChildren(admin);

        terminal(admin);
    }

    public static void terminal(Admin admin) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to children program!");
        System.out.print("Enter the family name of the person you're looking for: ");
        String familyName = sc.nextLine();
        System.out.print("Enter the given names of the person you're looking for: ");
        String givenNames = sc.nextLine();
        Person person = admin.findPerson(familyName, givenNames);
        if (person == null) {
            System.out.println("Person not found");
            return;
        }
        System.out.println("1. add a Father");
        System.out.println("2. add a Mother");
        System.out.println("3. add a Child");
        System.out.println("4. print lineage");
        System.out.println("5. exit");
        System.out.print("Please select the option: ");
        int option = sc.nextInt();
        if (option == 1) {
            addFather(admin, person, sc);
        } else if (option == 2) {
            addMother(admin, person, sc);
        } else if (option == 3) {
            addChild(admin, person, sc);
        } else if (option == 4) {
            receipt(person);
        } else if (option == 5){
            return;
        } else {
            System.out.println("Please select a valid option");
        }
        terminal(admin);
    }

    public static void addFather(Admin admin, Person person, Scanner sc) {
        sc.nextLine();
        System.out.print("Please enter the family name of the father: ");
        String familyName = sc.nextLine();
        System.out.print("Please enter the given name of the father: ");
        String givenNames = sc.nextLine();
        person.addFather(admin.findPerson(familyName, givenNames));
        if (person.getFather() != null) {
            System.out.println(person.getFather() + " added successfully!");
        } else {
            System.out.println("Father not found!");
        }
    }

    public static void addMother(Admin admin, Person person, Scanner sc) {
        sc.nextLine();
        System.out.print("Please enter the family name of the mother: ");
        String familyName = sc.nextLine();
        System.out.print("Please enter the given name of the mother: ");
        String givenNames = sc.nextLine();
        person.addMother(admin.findPerson(familyName, givenNames));
        if (person.getMother() != null) {
            System.out.println(person.getMother() + " added successfully!");
        } else {
            System.out.println("Mother not found!");
        }
    }

    public static void addChild(Admin admin, Person person, Scanner sc) {
        sc.nextLine();
        System.out.println("Please enter the family name of the partner: ");
        String familyName = sc.nextLine();
        System.out.println("Please enter the given names of the partner: ");
        String givenNames = sc.nextLine();
        Person partner = admin.findPerson(familyName, givenNames);
        if (partner == null) {
            System.out.println("Partner not found!");
            return;
        }
        System.out.println("Please enter the name of the child: ");
        String name = sc.nextLine();
        System.out.println("Please enter the day: ");
        int day = sc.nextInt();
        System.out.println("Please enter the month: ");
        int month = sc.nextInt();
        System.out.println("Please enter the year: ");
        int year = sc.nextInt();
        System.out.println("Enter the sex (1 for male, 0 for female): ");
        int sex = sc.nextInt();
        boolean isMale = sex == 1;
        person.addChild(name, day, month, year, isMale, partner);
        System.out.println("Child added successfully!");
        receipt(person);
    }

    public static void receipt(Person person) {
        List<Person> paternal = new ArrayList<>();
        List<Person> maternal = new ArrayList<>();
        List<Person> children = new ArrayList<>();
        Person pointer = person;
        while (pointer.getFather() != null) {
            paternal.add(pointer.getFather());
            pointer = pointer.getFather();
        }
        pointer = person;
        while (pointer.getMother() != null) {
            maternal.add(pointer.getMother());
            pointer = pointer.getMother();
        }
        children = person.getChildren();
        System.out.println("Paternal line: " + paternal);
        System.out.println("Maternal line: " + maternal);
        System.out.println("Children: " + children);
    }

    /*
    The following methods use whatever containers you have to create Course and Student objects
        then enroll and remove students from courses, printing out the results
    Assumes containers are "expert patters" and responsible for creating the Course and Student objects
        so they can keep track of them, provide searches, etc.
     */
    public static void createPeopleAndStudents(Admin r){
        // 11 Students and 2 People who are not students  (be sure you allow both using Person inheritance)
        // Assumed parameters familyName, givenNameS, studentID, day, month, year (of birth)
        // Person has no ID

        // Your container class collection can ignore some of these parameters and adjust as needed to use your
        // Person and Student constructors
        r.recordPerson("Smith","Adam", 1, 12, 1984, true);
        r.recordStudent("Quincy","Elizabeth", 1000001, 12, 1, 1990, false);
        r.recordUnderGradStudent("Smith","Betsey", 1000002, 10, 3, 2000, false);
        r.recordUnderGradStudent("Smith","Mary", 1000003, 1, 10, 2003, false);
        r.recordUnderGradStudent("Smith","Abigail", 1000004, 21, 8, 2005, false);
        r.recordGradStudent("Franklin","Benjamin", 1000005, 19, 3, 2020, true);
        r.recordGradStudent("Washington","George", 1000006, 2, 11, 1984, true);
        r.recordGradStudent("Custis","Daniel Parke", 1000007, 12, 12, 1980, true);

        r.recordStudent("Custis","Martha Dandridge", 1000008, 29, 11, 1984, false);
        r.recordStudent("Custis","Daniel Parke Jr", 1000009, 2, 12, 2003, true);
        r.recordStudent("Custis","Adam Parke", 1000010, 10, 1, 2004, true);
        r.recordStudent("Custis","Martha Parke \"Patsy\"", 1000011, 4, 8, 2006, false);
        r.recordPerson("Henry","Patrick", 9, 5, 190, true);
    }
    public static void createCourses(Admin c) {
        // 3 courses
        // Assumed parameters departmentName, courseNumber, courseTitle, maxCapacity
        c.recordCourse("COMP", 170, "Intro to OOP", 3, 3);
        c.recordCourse("COMP", 271, "Data Structures I", 5, 3);
        c.recordCourse("COMP", 272, "Data Structures II", 3, 3);
    }
    public static void registerStudents(Admin c){
        c.enrollStudent("Quincy","Elizabeth", "COMP", 170);
        c.enrollStudent("Quincy","Elizabeth", "COMP", 271);
        c.enrollStudent("Quincy","Elizabeth", "COMP", 272);
        c.enrollStudent("Smith","Betsey", "COMP", 170);
        c.enrollStudent("Smith","Betsey", "COMP", 170);			//duplicate, should be ignored
        c.enrollStudent("Smith","Mary", "COMP", 170);
        c.enrollStudent("Franklin","Benjamin", "COMP", 170);  	//will waitlist
        c.enrollStudent("Franklin","Benjamin", "COMP", 272);
        c.enrollStudent("Washington","George", "COMP", 271);
        c.enrollStudent("Custis","Martha Dandridge", "COMP", 271);
        c.enrollStudent("Custis","Daniel Parke Jr", "COMP", 272);
        c.enrollStudent("Custis","Adam Parke", "COMP", 170);	//will waitlist
        c.enrollStudent("Custis","Adam Parke", "COMP", 272);	//will waitlist
		/*expected
		170 [Elizabeth, Betsey, Mary] wait [Benjamin, Adam]
		271 [Elizabeth,George, Martha] wait [ ]
		272 [Elizabeth, Benjamin, Daniel Jr] wait [Adam]
		 */
    }

    public static void dropStudents(Admin c){
        c.removeStudent("Smith","Abigail", "COMP", 170 );	//in no courses, should do nothing
        c.removeStudent("Washington","George", "COMP", 170 );	//registered but not this course, should do nothing
        c.removeStudent("Custis","Martha Dandridge", "COMP", 271 );	//remove, no wait list present
        c.removeStudent("Custis","Daniel Parke Jr", "COMP",272);	//remove, process wait list
		/*expected
		170 [Elizabeth, Betsey, Mary] wait [Benjamin, Adam]
		271 [Elizabeth,George] wait [ ]
		272 [Elizabeth, Benjamin, Adam] wait [ ]
		 */
    }

    public static void addParentsAndChildren(Admin admin) {
        Person adamSmith = admin.findPerson("Smith", "Adam");
        adamSmith.addFather(new Person("Smith", "John", 1, 1, 1800, true));
        adamSmith.getFather().addFather(new Person("Smith", "Joe", 1, 1, 1775, true));
        adamSmith.addMother(new Person("Adams", "Elizebeth", 1, 1, 1800, false));
        adamSmith.getMother().addMother(new Person("Perry", "Elizebeth", 1, 1, 1775, false));
        admin.recordPerson("Smith", "Mother", 1, 1, 1825, false);
        adamSmith.addChild("Child1", 15, 4, 2024, false, admin.findPerson("Smith", "Mother"));
    }

    public static void createStores(GroceryStoreContainer s) {
        s.recordStore("Jewel Roger's Park");
        s.recordStore("Mariano's Evanston");
    }
    public static void createGroceryItems(GroceryStoreContainer s){
        // Give all stores some GroceryItems
        // Assumes there is a way to get all GroceryStores in an interable form
        //kludge to set up some different priced items for each of first two stores
        int store = 0;
        for(GroceryStore g : s.getStores()) {
            //These will be same in all stores
            g.addItem("Peanut butter", 3.99, "Aisle 2");
            g.addItem("Apples, delicious",0.99, "Produce");
            g.addItem("Florida oranges",1.29, "Produce");
            g.addItem("Oat Milk, 1 quart", 1.99, "Aisle 1");
            g.addItem("Blueberry muffins", 4.59, "Bakery");
            g.addItem("Coffee beans", 6.00, "Aisle 2");
            if (store == 0) {
                g.addItem("Whole wheat bread", 4.99, "Aisle 2");
                g.addItem("Orange juice", 1.99, "Aisle 1");
                store++;
            }
            if (store == 1) {
                g.addItem("Whole wheat bread", 1.99, "Aisle 7");
                g.addItem("Orange juice", 3.99, "Aisle 6");
                store++;
            }
        }
    }
}