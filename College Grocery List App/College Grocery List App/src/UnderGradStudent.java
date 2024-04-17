public class UnderGradStudent extends Student {
    public UnderGradStudent(String familyName, String givenNames, int id, int day, int month, int year, boolean isMale) {
        super(familyName, givenNames, id, day, month, year, isMale);
    }

    // Add 10% discount method for undergrad student
    public double undergradDiscount = .9;
}
