package entities;

import java.util.Date;

public class Aircraft extends Airborne{
    private Body body;
    private int flightAutonomy;

    public Aircraft(String name, String color, int weight, int maxSpeed, int maxAltitude, int flightAutonomy, Date introducedIn){
        super(name, color, weight, maxSpeed, maxAltitude, introducedIn);
        this.flightAutonomy = flightAutonomy;
        body = Body.NARROW_BODY;
    }

    public Aircraft(String name, String color, int weight, int maxSpeed, int maxAltitude, int flightAutonomy, Body body, Date introducedIn){
        super(name, color, weight, maxSpeed, maxAltitude, introducedIn);
        this.flightAutonomy = flightAutonomy;
        this.body = body;
    }

    @Override
    public void Accelerate() {
        System.out.println("The " + this.name + " is patiently flying through the sky...");
    }

    public int getFlightAutonomy(){
        return this.flightAutonomy;
    }

    public String getBody(){
        if(this.body == Body.NARROW_BODY){
            return "Narrow Body";
        }else if(this.body == Body.WIDE_BODY){
            return "Wide Body";
        }
        return "";
    }
}
