package T05_OOPPrinciples.p08_Vehicles.models;

public class Truck extends VehicleImpl {

    public Truck(double quantity, double consumption) {
        super(quantity, consumption);
    }

    @Override
    public void drive(double distance) {
        if (distance >= 0) {
            double fuelNeeded = distance * (super.getConsumption() + 1.6);
            if (fuelNeeded > super.getQuantity()) {
                System.out.println("Truck needs refueling");
            } else {
                super.setQuantity(super.getQuantity() - fuelNeeded);
                System.out.printf("Truck travelled %s km%n", super.getDf().format(distance));
            }
        }
    }

    @Override
    public void refuel(double quantity) {
        if (quantity > 0) {
            super.setQuantity(super.getQuantity() + quantity * 0.95);
        }
    }
}
