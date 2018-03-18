package T05_OOPPrinciples.p08_Vehicles;

import T05_OOPPrinciples.p08_Vehicles.interfaces.Vehicle;
import T05_OOPPrinciples.p08_Vehicles.models.Car;
import T05_OOPPrinciples.p08_Vehicles.models.Truck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().trim().split("\\s+");
        Vehicle car = new Car(
                Double.parseDouble(input[1]),
                Double.parseDouble(input[2]));
        input = reader.readLine().trim().split("\\s+");
        Vehicle truck = new Truck(
                Double.parseDouble(input[1]),
                Double.parseDouble(input[2]));

        byte n = Byte.parseByte(reader.readLine());
        for (byte i = 0; i < n; i++) {
            input = reader.readLine().trim().split("\\s+");
            if (input.length != 3) {
                continue;
            }
            String action = input[0];
            String type = input[1];
            double value = Double.parseDouble(input[2]);
            if ("drive".equalsIgnoreCase(action)) {
                if ("car".equalsIgnoreCase(type)) {
                    car.drive(value);
                } else {
                    truck.drive(value);
                }
            } else if ("car".equalsIgnoreCase(type)) {
                car.refuel(value);
            } else {
                truck.refuel(value);
            }
        }
        System.out.printf("Car: %.2f%nTruck: %.2f%n",
                car.getQuantity(), truck.getQuantity());
    }
}
