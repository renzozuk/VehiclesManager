package entities;

import java.util.Date;

public class Motorcycle extends LandBased{
    public Motorcycle(String name, String color, int weight, int maxSpeed, Date introducedIn){
        super(name, color, weight, maxSpeed, introducedIn);
        /*this.name = name;
        this.color = color;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
        this.introducedIn = introducedIn;*/
    }

    @Override
    public void Accelerate(){
        System.out.println("Vruuuuuum vruuuuuuuuum.");
    }
}
