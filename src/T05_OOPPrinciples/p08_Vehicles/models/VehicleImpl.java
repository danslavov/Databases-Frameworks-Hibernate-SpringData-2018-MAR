package T05_OOPPrinciples.p08_Vehicles.models;

import T05_OOPPrinciples.p08_Vehicles.interfaces.Vehicle;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {

    private double quantity;
    private double consumption;
    private final DecimalFormat df = new DecimalFormat("#.##########");


    protected VehicleImpl(double quantity, double consumption) {
        this.quantity = quantity;
        this.consumption = consumption;

    }

    @Override
    public double getQuantity() {
        return quantity;
    }

    protected void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    protected double getConsumption() {
        return consumption;
    }

    protected DecimalFormat getDf() {
        return this.df;
    }
}
