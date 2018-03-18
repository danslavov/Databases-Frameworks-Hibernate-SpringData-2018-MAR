package T05_OOPPrinciples.models;

import T05_OOPPrinciples.interfaces.Birthable;
import T05_OOPPrinciples.interfaces.Identifiable;
import T05_OOPPrinciples.interfaces.Person;

public class Citizen implements Person, Identifiable, Birthable {

    private String name;
    private int age;
    private String id;
    private String birthDate;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
