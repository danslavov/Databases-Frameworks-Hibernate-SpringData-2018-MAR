package T05_OOPPrinciples.p09_Animals.models;

public class Kitten extends Cat {

    public Kitten(String name, int age, String gender) {
        super(name, age, gender);
        this.setGender("Female");
    }

    @Override public String produceSound() {
        return "Miau";
    }
}
