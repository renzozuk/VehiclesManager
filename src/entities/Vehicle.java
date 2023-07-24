package entities;

import java.util.Date;

public abstract class Vehicle {
    protected String name;
    protected String color;
    protected int weight;
    protected int maxSpeed;
    protected Date introducedIn;

    public Vehicle(String name, String color, int weight, int maxSpeed, Date introducedIn){
        this.name = name; this.color = color; this.weight = weight; this.maxSpeed = maxSpeed; this.introducedIn = introducedIn;
    }

    public abstract void Accelerate();

    public String getName(){
        return this.name;
    }

    public String getColor(){
        return this.color;
    }

    public int getWeight(){
        return this.weight;
    }

    public int getMaxSpeed(){
        return this.maxSpeed;
    }

    public Date getIntroducedIn(){
        return this.introducedIn;
    }
}
