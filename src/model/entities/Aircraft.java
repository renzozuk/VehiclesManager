package model.entities;

import model.entities.enums.Body;

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
    public String accelerate() {
        return "The " + this.name + " is patiently flying through the sky..." + "\n";
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

    @Override
    public String toString(){
        return super.toString() + "Body model: " + getBody() + "\nFlight autonomy: " + flightAutonomy + "km\n";
    }
}
