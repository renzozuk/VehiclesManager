package application;

import java.util.ArrayList;

import entities.Airborne;
import entities.Aircraft;
import entities.Car;
import entities.Helicopter;
import entities.Motorcycle;
import entities.Vehicle;

public class Program {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Aircraft("Boeing 737-800 Next Generation", "white", 41413, 946, 41000, 7130, "31/07/1997"));
        vehicles.add(new Car("Lamborghini Miura", "red", 1125, 276, "1967"));
        vehicles.add(new Aircraft("Airbus A320NEO", "light gray", 41004, 871, 39000, 6800, "25/09/2014"));
        vehicles.add(new Helicopter("Sikorsky S-97 Raider", "black", 4057, 407, 10000, "22/05/2015"));
        vehicles.add(new Motorcycle("Harley-Davidson XR-750", "black", 134, 185, "1970"));
        for (Vehicle vehicle: vehicles) {
            System.out.println(vehicle.getClass().getSimpleName().toUpperCase());
            System.out.println("Name: " + vehicle.getName());
            System.out.println("Color: " + vehicle.getColor());
            System.out.println("Weight: " + vehicle.getWeight() + "kg");
            System.out.println("Maximum Speed: " + vehicle.getMaxSpeed() + "km/h");
            if(vehicle instanceof Airborne){
                System.out.println("Maximum altitude: " + ((Airborne) vehicle).getMaxAltitude() + "ft");
                System.out.println("First flight in: " + vehicle.getIntroducedIn());
            }else{
                System.out.println("Introduced in: " + vehicle.getIntroducedIn());
            }
            if(vehicle instanceof Aircraft){
                System.out.println("Flight autonomy: " + ((Aircraft) vehicle).getAutonomy() + "km");
                System.out.println("Body model: " + ((Aircraft) vehicle).getBody());
            }
            vehicle.Accelerate();
            System.out.println();
        }
    }
}
