public class Person implements Shopper {
    private String familyName;
    private String givenNames;
    private int day;
    private int month;
    private int year;
    public Person(String familyName, String givenNames, int day, int month, int year) {
        this.familyName = familyName;
        this.givenNames = givenNames;
        this.day = day;
        this.month = month;
        this.year = year;
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
