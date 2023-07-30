package application;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.Airborne;
import entities.Aircraft;
import entities.Car;
import entities.Helicopter;
import entities.Motorcycle;
import entities.Vehicle;

import static entities.Body.NARROW_BODY;
import static entities.Body.WIDE_BODY;

public class Program {
    static void clrsrc(){
        try {
            if (System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }else{
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException ex) {}
    }

    static void showInstructions(){
        System.out.print("1 - Show the instructions of the program\n2 - Add a Vehicle (Car, Motorcycle, Aircraft or Helicopter)\n3 - Show all the vehicles\n0 - Exit the program\n\n");
    }

    static void showGeneralInformation(String type, String name, String color, int weight, int maxSpeed){
        System.out.print(type + "\nName: " + name + "\nColor: " + color + "\nWeight: " + weight + "kg\nMaximum speed: " + maxSpeed + "km/h\n");
    }

    public static void main(String[] args) throws IOException, ParseException {
        final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Aircraft("Boeing 737-800 Next Generation", "white", 41413, 946, 41000, 7130, df.parse("31/07/1997")));
        vehicles.add(new Car("Lamborghini Miura", "red", 1125, 276, df.parse("01/01/1967")));
        vehicles.add(new Aircraft("Airbus A320NEO", "white", 41004, 871, 39000, 6800, df.parse("25/09/2014")));
        vehicles.add(new Car("5th gen Camaro", "yellow", 1700, 296, df.parse("16/03/2009")));
        vehicles.add(new Helicopter("Sikorsky S-97 Raider", "black", 4057, 407, 10000, df.parse("22/05/2015")));
        vehicles.add(new Motorcycle("Harley-Davidson XR-750", "black", 134, 185, df.parse("01/01/1970")));
        vehicles.add(new Aircraft("Boeing 777-300ER", "light gray", 167800, 950, 42400, 17600, WIDE_BODY, df.parse("07/06/1995")));
        showInstructions();
        Scanner sc = new Scanner(System.in); int choice; ArrayList<String> parameters = new ArrayList<>();
        do{
            parameters.clear();
            do{
                System.out.print("Insert a command: ");
                choice = sc.nextInt();
            }while(choice > 3 || choice < 0);
            sc.nextLine();
            clrsrc();
            switch(choice){
                case 1:
                    showInstructions();
                    break;
                case 2:
                    do{
                        System.out.print("Insert the type of the vehicle: ");
                        if(parameters.size() == 0){
                            parameters.add(sc.nextLine());
                        }else {
                            parameters.set(0, sc.nextLine());
                        }
                    }while(!(parameters.get(0).toLowerCase().equals("car")) && !(parameters.get(0).toLowerCase().equals("motorcycle")) && !(parameters.get(0).toLowerCase().equals("aircraft")) && !(parameters.get(0).toLowerCase().equals("helicopter")));
                    System.out.print("Insert the name of the vehicle: "); parameters.add(sc.nextLine());
                    System.out.print("Insert the color of the vehicle: "); parameters.add(sc.nextLine());
                    System.out.print("Insert the weight of the vehicle (in kg): ");
                    if(parameters.size() == 3){
                        parameters.add(sc.nextLine());
                    }else{
                        parameters.set(3, sc.nextLine());
                    }
                    System.out.print("Insert the maximum speed of the vehicle (in km/h): ");
                    if(parameters.size() == 4){
                        parameters.add(sc.nextLine());
                    }else{
                        parameters.set(4, sc.nextLine());
                    }
                    if(parameters.get(0).toLowerCase().equals("aircraft") || parameters.get(0).toLowerCase().equals("helicopter")){
                        System.out.print("Insert the maximum altitude of the airborne (in ft): ");
                        if(parameters.size() == 5){
                            parameters.add(sc.nextLine());
                        }else{
                            parameters.set(5, sc.nextLine());
                        }
                    }
                    if(parameters.get(0).toLowerCase().equals("aircraft")){
                        System.out.print("Insert the flight autonomy of the aircraft (in km): ");
                        if(parameters.size() == 6){
                            parameters.add(sc.nextLine());
                        }else{
                            parameters.set(6, sc.nextLine());
                        }
                        do{
                            System.out.print("Insert the type of the body of the aircraft (Narrow Body or Wide Body): ");
                            if(parameters.size() == 7){
                                parameters.add(sc.nextLine());
                            }else{
                                parameters.set(7, sc.nextLine());
                            }
                        }while(!(parameters.get(parameters.size()-1).toLowerCase().equals("nb")) && !(parameters.get(parameters.size()-1).toLowerCase().equals("narrowbody")) && !(parameters.get(parameters.size()-1).toLowerCase().equals("narrow body")) && !(parameters.get(parameters.size()-1).toLowerCase().equals("wb")) && !(parameters.get(parameters.size()-1).toLowerCase().equals("widebody")) && !(parameters.get(parameters.size()-1).toLowerCase().equals("wide body")));
                    }
                    System.out.print("Insert the date that the vehicle was introduced in: "); parameters.add(sc.nextLine());
                    try{
                        switch(parameters.get(0).toLowerCase()){
                            case "car":
                                vehicles.add(new Car(parameters.get(1), parameters.get(2), Integer.parseInt(parameters.get(3)), Integer.parseInt(parameters.get(4)), df.parse(parameters.get(5))));
                                System.out.println("The car was successfully added to the system.");
                                break;
                            case "motorcycle":
                                vehicles.add(new Motorcycle(parameters.get(1), parameters.get(2), Integer.parseInt(parameters.get(3)), Integer.parseInt(parameters.get(4)), df.parse(parameters.get(5))));
                                System.out.println("The motorcycle was successfully added to the system.");
                                break;
                            case "aircraft":
                                if(parameters.get(7).toLowerCase().equals("nb") || parameters.get(7).toLowerCase().equals("narrowbody") || parameters.get(7).toLowerCase().equals("narrow body")){
                                    vehicles.add(new Aircraft(parameters.get(1), parameters.get(2), Integer.parseInt(parameters.get(3)), Integer.parseInt(parameters.get(4)), Integer.parseInt(parameters.get(5)), Integer.parseInt(parameters.get(6)), NARROW_BODY, df.parse(parameters.get(8))));
                                    System.out.println("The aircraft was successfully added to the system.");
                                }else if(parameters.get(7).toLowerCase().equals("wb") || parameters.get(7).toLowerCase().equals("widebody") || parameters.get(7).toLowerCase().equals("wide body")){
                                    vehicles.add(new Aircraft(parameters.get(1), parameters.get(2), Integer.parseInt(parameters.get(3)), Integer.parseInt(parameters.get(4)), Integer.parseInt(parameters.get(5)), Integer.parseInt(parameters.get(6)), WIDE_BODY, df.parse(parameters.get(8))));
                                    System.out.println("The aircraft was successfully added to the system.");
                                }
                                break;
                            case "helicopter":
                                vehicles.add(new Helicopter(parameters.get(1), parameters.get(2), Integer.parseInt(parameters.get(3)), Integer.parseInt(parameters.get(4)), Integer.parseInt(parameters.get(5)), df.parse(parameters.get(6))));
                                System.out.println("The helicopter was successfully added to the system.");
                                break;
                        }
                    }catch(NumberFormatException e){
                        System.out.println("The vehicle wasn't added to the system, because you didn't put a number (an integer) in a statement that you should put.");
                    }
                    System.out.println();
                    break;
                case 3:
                    for (Vehicle vehicle: vehicles) {
                        showGeneralInformation(vehicle.getClass().getSimpleName().toUpperCase(), vehicle.getName(), vehicle.getColor(), vehicle.getWeight(), vehicle.getMaxSpeed());
                        if(vehicle instanceof Airborne){
                            System.out.println("Maximum altitude: " + ((Airborne) vehicle).getMaxAltitude() + "ft");
                            System.out.print("First flight in: ");
                        }else{
                            System.out.print("Introduced in: ");
                        }
                        if(vehicle.getIntroducedIn().getDate() != 1 && vehicle.getIntroducedIn().getMonth() != 1){
                            System.out.print(vehicle.getIntroducedIn().getDate() + "/" + vehicle.getIntroducedIn().getMonth() + "/");
                        }
                        System.out.print(vehicle.getIntroducedIn().getYear()+1900 + "\n");
                        if(vehicle instanceof Aircraft){
                            System.out.println("Flight autonomy: " + ((Aircraft) vehicle).getFlightAutonomy() + "km");
                            System.out.println("Body model: " + ((Aircraft) vehicle).getBody());
                        }
                        vehicle.Accelerate();
                        System.out.println();
                    }
                    break;
            }
        }while(choice != 0);
        sc.close();
    }
}
