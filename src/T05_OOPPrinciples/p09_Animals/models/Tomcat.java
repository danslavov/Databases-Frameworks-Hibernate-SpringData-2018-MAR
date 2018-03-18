package T05_OOPPrinciples.p09_Animals.models;

public class Tomcat extends Cat {

    public Tomcat(String name, int age, String gender) {
        super(name, age, gender);
        this.setGender("Male");
    }

    @Override
    public String produceSound() {
        return "Give me one million b***h";
    }
}
