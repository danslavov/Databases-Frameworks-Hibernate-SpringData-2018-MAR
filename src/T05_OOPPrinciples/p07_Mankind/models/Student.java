package T05_OOPPrinciples.p07_Mankind.models;

public class Student extends Human {

    private String facNumber;

    public Student(String firstName, String lastName, String facNumber) {
        super(firstName, lastName);
        this.setFacNumber(facNumber);
    }

    public String getFacNumber() {
        return this.facNumber;
    }

    private void setFacNumber(String facNumber) {
        if (facNumber.length() < 5 || facNumber.length() > 10) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        this.facNumber = facNumber;
    }
}
