package model.entities;

import java.util.Date;

public class Motorcycle extends LandBased{
    public Motorcycle(String name, String color, int weight, int maxSpeed, Date introducedIn){
        super(name, color, weight, maxSpeed, introducedIn);
    }

    @Override
    public String accelerate(){
        return "Vruuuuuum vruuuuuuuuum." + "\n";
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
