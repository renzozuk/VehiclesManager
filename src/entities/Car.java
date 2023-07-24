package entities;

import java.util.Date;

public class Car extends LandBased{
    public Car(String name, String color, int weight, int maxSpeed, Date introducedIn){
        super(name, color, weight, maxSpeed, introducedIn);
    }

    @Override
    public void Accelerate() {
        System.out.println("Vrum vrum.");
    }
}
