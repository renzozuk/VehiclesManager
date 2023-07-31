package application;

import java.io.IOException;

public class UI {
    protected static void clearScreen() {
        //this function is temporary
        try {
            if (System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }else{
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException ex) {}
    }

    protected static void showInstructions(){
        System.out.print("1 - Show the instructions of the program\n2 - Add a Vehicle (Car, Motorcycle, Aircraft or Helicopter)\n3 - Show all the vehicles\n0 - Exit the program\n\n");
    }

    protected static void showGeneralInformation(String type, String name, String color, int weight, int maxSpeed){
        System.out.print(type + "\nName: " + name + "\nColor: " + color + "\nWeight: " + weight + "kg\nMaximum speed: " + maxSpeed + "km/h\n");
    }
}
