package entities;

public class Aircraft extends Airborne{
    enum Body{
        NarrowBody,
        WideBody
    }
    private Body bodyModel;
    private int autonomy;

    public Aircraft(String name, String color, int weight, int maxSpeed, int maxAltitude, int autonomy, String introducedIn){
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
        this.maxAltitude = maxAltitude;
        this.autonomy = autonomy;
        bodyModel = Body.NarrowBody;
        this.introducedIn = introducedIn;
    }

    public Aircraft(String name, String color, int weight, int maxSpeed, int maxAltitude, int autonomy, String body, String introducedIn){
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
        this.maxAltitude = maxAltitude;
        this.autonomy = autonomy;
        switch(body){
            case "WideBody":
                bodyModel = Body.WideBody;
                break;
            default:
                bodyModel = Body.NarrowBody;
                break;
        }
        this.introducedIn = introducedIn;
    }

    @Override
    public void Accelerate() {
        System.out.println("The " + this.name + " is patiently flying through the sky...");
    }
    public int getAutonomy(){
        return this.autonomy;
    }
    public String getBody(){
        //return String.valueOf(this.bodyModel);
        if(this.bodyModel == Body.NarrowBody){
            return "Narrow Body";
        }else if(this.bodyModel == Body.WideBody){
            return "Wide Body";
        }
        return "";
    }
}
