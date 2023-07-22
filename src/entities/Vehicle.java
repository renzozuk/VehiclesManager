package entities;

public abstract class Vehicle {
    protected String name;
    protected String color;
    protected int weight;
    protected int maxSpeed;
    protected String introducedIn;

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

    public String getIntroducedIn(){
        return this.introducedIn;
    }
}
