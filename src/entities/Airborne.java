package entities;

public abstract class Airborne extends Vehicle {
    protected int maxAltitude;

    public int getMaxAltitude(){
        return this.maxAltitude;
    }
}
