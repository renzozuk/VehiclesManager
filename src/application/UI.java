package application;

import model.dao.Repository;
import model.entities.Aircraft;
import model.entities.Car;
import model.entities.Helicopter;
import model.entities.Motorcycle;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static model.entities.enums.Body.NARROW_BODY;
import static model.entities.enums.Body.WIDE_BODY;

public class UI {
    static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    protected static void clearScreen() {
        // This function is temporary
        try {
            if (System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }else{
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException ignored) {}
    }

    protected static void showInstructions(){
        System.out.print("1 - Show the instructions of the program\n2 - Add a Vehicle (Car, Motorcycle, Aircraft or Helicopter)\n3 - Show all the vehicles\n0 - Exit the program\n\n");
    }

    protected static void addVehicleToRepository(Repository repository, Scanner sc){
        List<String> parameters = new ArrayList<>();

        do{
            System.out.print("Insert the type of the vehicle: ");
            if(parameters.size() == 0){
                parameters.add(sc.nextLine());
            }else {
                parameters.set(0, sc.nextLine());
            }
        }while(!(parameters.get(0).equalsIgnoreCase("car")) && !(parameters.get(0).equalsIgnoreCase("motorcycle")) && !(parameters.get(0).equalsIgnoreCase("aircraft")) && !(parameters.get(0).equalsIgnoreCase("helicopter")));

        System.out.print("Insert the name of the vehicle: ");
        parameters.add(sc.nextLine());

        System.out.print("Insert the color of the vehicle: ");
        parameters.add(sc.nextLine());

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

        if(parameters.get(0).equalsIgnoreCase("aircraft") || parameters.get(0).equalsIgnoreCase("helicopter")){
            System.out.print("Insert the maximum altitude of the airborne (in ft): ");

            if(parameters.size() == 5){
                parameters.add(sc.nextLine());
            }else{
                parameters.set(5, sc.nextLine());
            }
        }

        if(parameters.get(0).equalsIgnoreCase("aircraft")){
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
            }while(!(parameters.get(parameters.size()-1).equalsIgnoreCase("nb")) && !(parameters.get(parameters.size()-1).equalsIgnoreCase("narrowbody")) && !(parameters.get(parameters.size()-1).equalsIgnoreCase("narrow body")) && !(parameters.get(parameters.size()-1).equalsIgnoreCase("wb")) && !(parameters.get(parameters.size()-1).equalsIgnoreCase("widebody")) && !(parameters.get(parameters.size()-1).equalsIgnoreCase("wide body")));
        }

        System.out.print("Insert the date that the vehicle was introduced in: "); parameters.add(sc.nextLine());

        try{
            switch(parameters.get(0).toLowerCase()){
                case "car":
                    repository.addVehicleToRepository(new Car(parameters.get(1), parameters.get(2), Integer.parseInt(parameters.get(3)), Integer.parseInt(parameters.get(4)), df.parse(parameters.get(5))));
                    //vehicles.add();
                    System.out.println("The car was successfully added to the system.");
                    break;
                case "motorcycle":
                    repository.addVehicleToRepository(new Motorcycle(parameters.get(1), parameters.get(2), Integer.parseInt(parameters.get(3)), Integer.parseInt(parameters.get(4)), df.parse(parameters.get(5))));
                    //vehicles.add();
                    System.out.println("The motorcycle was successfully added to the system.");
                    break;
                case "aircraft":
                    if(parameters.get(7).equalsIgnoreCase("nb") || parameters.get(7).equalsIgnoreCase("narrowbody") || parameters.get(7).equalsIgnoreCase("narrow body")){
                        repository.addVehicleToRepository(new Aircraft(parameters.get(1), parameters.get(2), Integer.parseInt(parameters.get(3)), Integer.parseInt(parameters.get(4)), Integer.parseInt(parameters.get(5)), Integer.parseInt(parameters.get(6)), NARROW_BODY, df.parse(parameters.get(8))));
                        //vehicles.add();
                        System.out.println("The aircraft was successfully added to the system.");
                    }else if(parameters.get(7).equalsIgnoreCase("wb") || parameters.get(7).equalsIgnoreCase("widebody") || parameters.get(7).equalsIgnoreCase("wide body")){
                        repository.addVehicleToRepository(new Aircraft(parameters.get(1), parameters.get(2), Integer.parseInt(parameters.get(3)), Integer.parseInt(parameters.get(4)), Integer.parseInt(parameters.get(5)), Integer.parseInt(parameters.get(6)), WIDE_BODY, df.parse(parameters.get(8))));
                        //vehicles.add();
                        System.out.println("The aircraft was successfully added to the system.");
                    }
                    break;
                case "helicopter":
                    repository.addVehicleToRepository(new Helicopter(parameters.get(1), parameters.get(2), Integer.parseInt(parameters.get(3)), Integer.parseInt(parameters.get(4)), Integer.parseInt(parameters.get(5)), df.parse(parameters.get(6))));
                    System.out.println("The helicopter was successfully added to the system.");
                    break;
            }
        }catch(NumberFormatException | ParseException e){
            System.out.println("The vehicle wasn't added to the system, because you didn't put a number (an integer) in a statement that you should put.");
        }

        System.out.println();
    }
}
