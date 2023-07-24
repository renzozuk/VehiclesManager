package entities;

import java.util.Date;

public abstract class LandBased extends Vehicle {
    public LandBased(String name, String color, int weight, int maxSpeed, Date introducedIn){
        super(name, color, weight, maxSpeed, introducedIn);
    }
}
