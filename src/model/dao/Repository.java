package model.dao;

import model.entities.Vehicle;

import java.util.ArrayList;

public class Repository {
    ArrayList<Vehicle> vehicles;

    public Repository(){
        vehicles = new ArrayList<>();
    }

    public void addVehicleToRepository(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public void removeVehicleFromRepository(Vehicle vehicle){
        vehicles.remove(vehicle);
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();

        for (Vehicle vehicle : vehicles) {
            result.append(vehicle).append(vehicle.accelerate()).append("\n");
        }

        return result.toString();
    }
}
