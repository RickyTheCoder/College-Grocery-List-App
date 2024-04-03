public class Person implements Shopper {
    private String familyName;
    private String givenNames;

    public Person(String familyName, String givenNames) {
        this.familyName = familyName;
        this.givenNames = givenNames;
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
