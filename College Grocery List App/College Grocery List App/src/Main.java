import java.util.Scanner;

public class GroceryWaitListTester
{
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
        createStores(stores);
        //Add GroceryItems to at least two stores
        createGroceryItems(stores);

        // Instantiate one or two collections to hold Person and Course objects
        Admin admin = new Admin();

        // Create some people and students in the container
        createPeopleAndStudents(people);
        // Create some courses in the container
        createCourses(courses);

        // Enroll students by name in courses by name
        registerStudents(courses);
        //Show current state (requirement 2a and 2b as List<String> suitable for printing)
        System.out.println("Registered after initial registrations:\n" + courses.reportRegistrations());
        System.out.println("Waitlisted after initial registrations:\n" + courses.reportWaitListed());

        // Remove some courses for some students
        dropStudents(courses);
        //Show current state again
        System.out.println("Registered after some drop:\n" + courses.reportRegistrations());
        System.out.println("Waitlisted after some drop:\n" + courses.reportWaitListed());
    }

    /*
    The following methods use whatever containers you have to create Course and Student objects
        then enroll and remove students from courses, printing out the results
    Assumes containers are "expert patters" and responsible for creating the Course and Student objects
        so they can keep track of them, provide searches, etc.
     */
    public static void createPeopleAndStudents(Registry r){
        // 11 Students and 2 People who are not students  (be sure you allow both using Person inheritance)
        // Assumed parameters familyName, givenNameS, studentID, day, month, year (of birth)
        // Person has no ID

        // Your container class collection can ignore some of these parameters and adjust as needed to use your
        // Person and Student constructors
        r.recordPerson("Smith","Adam", 1, 12, 1984);
        r.recordStudent("Quincy","Elizabeth", 1000001, 12, 1, 1990);
        r.recordUnderGradStudent("Smith","Betsey", 1000002, 10, 3, 2000);
        r.recordUnderGradStudent("Smith","Mary", 1000003, 1, 10, 2003);
        r.recordUnderGradStudent("Smith","Abigail", 1000004, 21, 8, 2005);
        r.recordGradStudent("Franklin","Benjamin", 1000005, 19, 3, 2020);
        r.recordGradStudent("Washington","George", 1000006, 2, 11, 1984);
        r.recordGradStudent("Custis","Daniel Parke", 1000007, 12, 12, 1980);

        r.recordStudent("Custis","Martha Dandridge", 1000008, 29, 11, 1984);
        r.recordStudent("Custis","Daniel Parke Jr", 1000009, 2, 12, 2003);
        r.recordStudent("Custis","Adam Parke", 1000010, 10, 1, 2004);
        r.recordStudent("Custis","Martha Parke \"Patsy\"", 1000011, 4, 8, 2006);
        r.recordPerson("Henry","Patrick", 9, 5, 190);
    }
    public static void createCourses(Locus c) {
        // 3 courses
        // Assumed parameters departmentName, courseNumber, courseTitle, maxCapacity
        c.recordCourse("COMP", 170, "Intro to OOP", 3);
        c.recordCourse("COMP", 271, "Data Structures I", 5);
        c.recordCourse("COMP", 272, "Data Structures II", 3);
    }
    public static void registerStudents(Locus c){
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

    public static void dropStudents(Locus c){
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

    public static void createStores(AvailableStores s) {
        s.recordStore("Jewel Roger's Park");
        s.recordStore("Mariano's Evanston");
    }
    public static void createGroceryItems(AvailableStores s){
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