public class GraduateStudent extends Student {
    public GraduateStudent(String familyName, String givenNames, int id, int day, int month, int year, boolean isMale) {
        super(familyName, givenNames, id, day, month, year, isMale);
    }

    // Add 15% discount method for graduate student
    public double graduateDiscount = .85;
}
