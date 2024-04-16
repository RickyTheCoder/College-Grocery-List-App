public class Professor extends Person {

    private int employeeId;

    public Professor(String familyName, String givenNames, int day, int month, int year, boolean isMale) {
        super(familyName, givenNames, day, month, year, isMale);

    }

    /**
     *
     * Add discount method for professor...even though doesn't get one (multiply by 1).
     *
     */
    public int professorDiscount() {

    }
}
