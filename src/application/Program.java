package application;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import java.text.ParseException;

import model.dao.Repository;
import model.entities.Aircraft;
import model.entities.Car;
import model.entities.Helicopter;
import model.entities.Motorcycle;

import static model.entities.enums.Body.WIDE_BODY;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        Repository repository = new Repository();
        repository.addVehicleToRepository(new Aircraft("Boeing 737-800 Next Generation", "white", 41413, 946, 41000, 7130, df.parse("31/07/1997")));
        repository.addVehicleToRepository(new Aircraft("Airbus A320NEO", "white", 41004, 871, 39000, 6800, df.parse("25/09/2014")));
        repository.addVehicleToRepository(new Car("5th gen Camaro", "yellow", 1700, 296, df.parse("16/03/2009")));
        repository.addVehicleToRepository(new Helicopter("Sikorsky S-97 Raider", "black", 4057, 407, 10000, df.parse("22/05/2015")));
        repository.addVehicleToRepository(new Motorcycle("Harley-Davidson XR-750", "black", 134, 185, df.parse("01/01/1970")));
        repository.addVehicleToRepository(new Aircraft("Boeing 777-300ER", "light gray", 167800, 950, 42400, 17600, WIDE_BODY, df.parse("07/06/1995")));
        repository.addVehicleToRepository(new Car("Lamborghini Miura", "red", 1125, 276, df.parse("01/01/1967")));

        UI.clearScreen(); UI.showInstructions();
        Scanner sc = new Scanner(System.in);
        int choice;

        do{
            do{
                System.out.print("Insert a command: ");
                choice = sc.nextInt();
            }while(choice > 3 || choice < 0);

            if(sc.hasNextLine()){
                sc.nextLine();
            }

            UI.clearScreen();

            switch(choice){
                case 1:
                    UI.showInstructions();
                    break;
                case 2:
                    UI.addVehicleToRepository(repository, sc);
                    break;
                case 3:
                    System.out.print(repository);
                    break;
            }
        }while(choice != 0);

        sc.close();
    }
}
