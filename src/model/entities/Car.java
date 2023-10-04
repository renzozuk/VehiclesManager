package model.entities;

import java.util.Date;

public class Car extends LandBased{
    public Car(String name, String color, int weight, int maxSpeed, Date introducedIn){
        super(name, color, weight, maxSpeed, introducedIn);
    }

    @Override
    public String accelerate() {
        return "Vrum vrum." + "\n";
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
