public class AtLarge extends Student{
    public AtLarge(String familyName, String givenNames, int id, int day, int month, int year, boolean isMale) {
        super(familyName, givenNames, id, day, month, year, isMale);
    }

    // No discount given
    private int atLargeDiscount = 1;
}
