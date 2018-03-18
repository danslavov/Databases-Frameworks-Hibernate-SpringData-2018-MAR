package T05_OOPPrinciples.p09_Animals.models;

public class Dog extends Animal {
    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "BauBau";
    }
}
