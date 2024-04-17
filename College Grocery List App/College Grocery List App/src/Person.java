import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Person implements Shopper {
    private String familyName;
    private String givenNames;
    private int day;
    private int month;
    private int year;
    private boolean isMale;
    private Person father;
    private Person mother;
    private List<Person> children;

    public Person(String familyName, String givenNames, int day, int month, int year, boolean isMale) {
        this.familyName = familyName;
        this.givenNames = givenNames;
        this.day = day;
        this.month = month;
        this.year = year;
        this.isMale = isMale;
        father = null;
        mother = null;
        children = new ArrayList<>();
    }

    public void addFather(Person father) {
        this.father = father;
    }

    public void addMother(Person mother) {
        this.mother = mother;
    }

    public void addChild(String name, int day, int month, int year, boolean isMale, Person partner) {
        Person child = new Person(familyName, name, day, month, year, isMale);
        if (isMale) {
            child.addFather(this);
            child.addMother(partner);
        } else {
            child.addMother(this);
            child.addFather(partner);
        }
        children.add(child);
    }

    public Person getFather() {
        return father;
    }

    public Person getMother() {
        return mother;
    }

    public List<Person> getChildren() {
        children.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getFamilyName().compareTo(o2.getFamilyName());
            }
        });
        return children;
    }

    public String getGivenNames() {
        return givenNames;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String toString() {
        return "Person(familyName=" + familyName + ", givenNames=" + givenNames + ")";
    }
}
