package T04_Fundamentals;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String firstName;
    private String lastName;
    private int group;
    private byte age;
    private String email;
    private String phone;
    private List<Byte> grades = new ArrayList<>();
    private String facNumber;

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGroup() {
        return this.group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public byte getAge() {
        return this.age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Byte> getGrades() {
        return this.grades;
    }

    public String getFacNumber() {
        return this.facNumber;
    }

    public void setFacNumber(String facNumber) {
        this.facNumber = facNumber;
    }
}
