package entities;

import java.util.Date;

public class Helicopter extends Airborne {
    public Helicopter(String name, String color, int weight, int maxSpeed, int maxAltitude, Date introducedIn){
        super(name, color, weight, maxSpeed, maxAltitude, introducedIn);
    }

    @Override
    public void Accelerate() {
        System.out.println("The " + this.name + " is flying through the sky...");
    }
}
