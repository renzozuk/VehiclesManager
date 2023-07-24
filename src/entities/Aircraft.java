package entities;

import java.util.Date;

public class Aircraft extends Airborne{
    enum Body{
        NarrowBody,
        WideBody
    }
    private Body bodyModel;
    private int autonomy;

    public Aircraft(String name, String color, int weight, int maxSpeed, int maxAltitude, int autonomy, Date introducedIn){
        super(name, color, weight, maxSpeed, maxAltitude, introducedIn);
        this.autonomy = autonomy;
        bodyModel = Body.NarrowBody;
    }

    public Aircraft(String name, String color, int weight, int maxSpeed, int maxAltitude, int autonomy, String body, Date introducedIn){
        super(name, color, weight, maxSpeed, maxAltitude, introducedIn);
        this.autonomy = autonomy;
        switch(body){
            case "WideBody":
                bodyModel = Body.WideBody;
                break;
            default:
                bodyModel = Body.NarrowBody;
                break;
        }
    }

    @Override
    public void Accelerate() {
        System.out.println("The " + this.name + " is patiently flying through the sky...");
    }

    public int getAutonomy(){
        return this.autonomy;
    }

    public String getBody(){
        if(this.bodyModel == Body.NarrowBody){
            return "Narrow Body";
        }else if(this.bodyModel == Body.WideBody){
            return "Wide Body";
        }
        return "";
    }
}
