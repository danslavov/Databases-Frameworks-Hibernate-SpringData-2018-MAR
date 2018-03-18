package T05_OOPPrinciples.models;

import T05_OOPPrinciples.interfaces.Car;

public class Ferrari implements Car {

    private static final String MODEL = "488-Spider";

    private String driver;

    public Ferrari(String driver) {
        this.driver = driver;
    }

    @Override
    public String getModel() {
        return MODEL;
    }

    @Override
    public String getDriver() {
        return this.driver;
    }

    @Override
    public void brake() {
        System.out.print("Brakes!");
    }

    @Override
    public void drive() {
        System.out.print("Zadu6avam sA!");
    }
}
