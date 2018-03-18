package T05_OOPPrinciples.p07_Mankind.models;

import T05_OOPPrinciples.p07_Mankind.interfaces.Nameable;

public abstract class Human implements Nameable {

    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    private void setFirstName(String firstName) {
        if (Character.isLowerCase(firstName.charAt(0))) {
            throw new IllegalArgumentException(
                    "Expected upper case letter!Argument: firstName");
        }
        if (firstName.length() < 4) {
            throw new IllegalArgumentException(
                    "Expected length at least 4 symbols!Argument: firstName");
        }
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        if (Character.isLowerCase(lastName.charAt(0))) {
            throw new IllegalArgumentException(
                    "Expected upper case letter!Argument: lastName");
        }
        if (lastName.length() < 3) {
            throw new IllegalArgumentException(
                    "Expected length at least 3 symbols!Argument: lastName");
        }
        this.lastName = lastName;
    }
}
