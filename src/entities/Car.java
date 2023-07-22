package entities;

public class Car extends LandBased{
    public Car(String name, String color, int weight, int maxSpeed, String introducedIn){
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
        this.introducedIn = introducedIn;
    }

    @Override
    public void Accelerate() {
        System.out.println("Vrum vrum.");
    }
}
