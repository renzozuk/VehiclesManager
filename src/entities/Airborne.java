package entities;

import java.util.Date;

public abstract class Airborne extends Vehicle {
    protected int maxAltitude;

    public Airborne(String name, String color, int weight, int maxSpeed, int maxAltitude, Date introducedIn){
        super(name, color, weight, maxSpeed, introducedIn);
        this.maxAltitude = maxAltitude;
    }

    public int getMaxAltitude(){
        return this.maxAltitude;
    }
}
