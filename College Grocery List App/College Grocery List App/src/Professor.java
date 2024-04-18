public class Professor extends Person {

    private int employeeId;

    public Professor(String familyName, String givenNames, int day, int month, int year, boolean isMale) {
        super(familyName, givenNames, day, month, year, isMale);

    }

    // No discount given
    private final int professorDiscount = 1;
}
