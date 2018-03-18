package T05_OOPPrinciples.p09_Animals.models;

import T05_OOPPrinciples.p09_Animals.interfaces.AnimalInterface;

public class Animal implements AnimalInterface {

    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    @Override
    public String produceSound() {
        return "Not implemented!";
    }

    public String getName() {
        return this.name;
    }

    public String getGender() {
        return this.gender;
    }

    public int getAge() {
        return this.age;
    }

    protected void setGender(String gender) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    private void setName(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException();
        }
        this.age = age;
    }
}
